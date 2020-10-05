package demo.tree.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.tree.dto.Document;
import demo.tree.dto.DocumentFlatItem;
import demo.tree.pojo.tables.DocumentTree;
import demo.tree.pojo.tables.records.DocumentTreeRecord;

import static demo.tree.pojo.tables.DocumentTree.DOCUMENT_TREE;

@Service
public class DocumentTreeServiceImpl implements DocumentTreeService {

	@Autowired
	private DSLContext dsl;
	
	/*
	 * (non-Javadoc)
	 * @see demo.tree.services.DocumentTreeService#getDocumentTree(java.lang.Long)
	 * Returns a hierarchical view of the documents under the given document (including the given document)
	 */
	@Override
	public Document getDocumentTree(Long documentId) {
		//first, get the list of document entities
		List<DocumentFlatItem> documentList = getDocumentList(documentId);


		//then convert the list to a hierarchical structure
		Map<Long, Document> map = documentList
				.stream()
				.collect(Collectors.toMap(Document::getId, de -> de));
		map.forEach((k, v) -> {
			if (v.getParentId() != null && map.get(v.getParentId()) != null) {
				map.get(v.getParentId()).getChildren().add(v);
			}
		});
		//return the requested document and all his descendants
		return map.get(documentId);
	}

	
	/*
	 * (non-Javadoc)
	 * @see demo.tree.services.DocumentTreeService#getDocumentList(java.lang.Long)
	 * Returns a list of documents in the hierarchy, located under the given document (including the given document)
	 * The returning list of documents has a plain structure, not hierarchical
	 */
	@Override
	public List<DocumentFlatItem> getDocumentList(Long documentId) {
		DocumentTree parent = DOCUMENT_TREE.as("parent");
		DocumentTree node = DOCUMENT_TREE.as("node");
		
		return dsl.select(node.ID,
				node.PARENT_ID,
				node.NAME,
				node.DESCRIPTION,
				node.LEVEL)
				.from(parent, node).where(node.LEFT_BRANCH.between(parent.LEFT_BRANCH, parent.RIGHT_BRANCH)
						.and(parent.ID.eq(documentId)))
				.orderBy(node.LEFT_BRANCH)
				.fetch().into(DocumentFlatItem.class);
	}

	
	/*
	 * The method is annotated as @Transactional, because it executes a set of SQL queries which has to be executed in one transaction.
	 * If one of the queries is failing, the whole transaction shall be rolled back
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long addDocument(Document document) throws Exception {
		
		//1. get the right index of the parent element
		DocumentTreeRecord parentRecord = dsl
				.selectFrom(DOCUMENT_TREE)
				.where(DOCUMENT_TREE.ID.eq(document.getParentId()))
				.fetchOne();

		//2. update right indexes
		dsl.update(DOCUMENT_TREE)
			.set(DOCUMENT_TREE.RIGHT_BRANCH, DOCUMENT_TREE.RIGHT_BRANCH.add(2))
			.where(DOCUMENT_TREE.RIGHT_BRANCH.ge(parentRecord.getRightBranch()))
			.execute();
		
		//3. update left indexes
		dsl.update(DOCUMENT_TREE)
			.set(DOCUMENT_TREE.LEFT_BRANCH, DOCUMENT_TREE.LEFT_BRANCH.add(2))
			.where(DOCUMENT_TREE.LEFT_BRANCH.ge(parentRecord.getRightBranch()))
			.execute();
		
		//4. insert the new document to the hierarchy
		Long newDocumentId = dsl.insertInto(DOCUMENT_TREE,
				DOCUMENT_TREE.PARENT_ID,
				DOCUMENT_TREE.NAME,
				DOCUMENT_TREE.DESCRIPTION,
				DOCUMENT_TREE.LEFT_BRANCH,
				DOCUMENT_TREE.RIGHT_BRANCH,
				DOCUMENT_TREE.LEVEL)
			.values(document.getParentId(),
					document.getName(),
					document.getDescription(),
					parentRecord.getRightBranch(),
					parentRecord.getRightBranch() + 1,
					parentRecord.getLevel() + 1)
			.returning()
			.fetchOne().getId();

		return newDocumentId;
	}

	
}
