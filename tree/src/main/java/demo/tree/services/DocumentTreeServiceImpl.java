package demo.tree.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.tree.dto.Document;
import demo.tree.dto.DocumentFlatItem;

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
	 * Uses MySQL "with recursive" CTE function to select the hierarchy in one go
	 */
	@Override
	public List<DocumentFlatItem> getDocumentList(Long documentId) {
		return dsl.withRecursive("children").as(
				DSL.select(DOCUMENT_TREE.ID, DOCUMENT_TREE.PARENT_ID, DOCUMENT_TREE.NAME, DSL.field("1", Long.class).as("level"))
				.from(DOCUMENT_TREE)
				.where(DOCUMENT_TREE.ID.eq(documentId))
				.unionAll(
						DSL.select(DOCUMENT_TREE.ID, DOCUMENT_TREE.PARENT_ID, DOCUMENT_TREE.NAME, DSL.field("children.level + 1", Long.class).as("level"))
						.from(DOCUMENT_TREE)
						.innerJoin(DSL.name("children"))
						.on(DOCUMENT_TREE.PARENT_ID.eq(DSL.field(DSL.name("children", "ID"), Long.class)))
						)
				)
		.select(DOCUMENT_TREE.as("children").ID, DOCUMENT_TREE.as("children").PARENT_ID, DOCUMENT_TREE.as("children").NAME, DSL.field("level", Long.class))
		.from(DSL.name("children"))
		.orderBy(DSL.field("level"))
		.fetch().into(DocumentFlatItem.class);
	}


	/*
	 * (non-Javadoc)
	 * @see demo.tree.services.DocumentTreeService#addDocument(demo.tree.dto.Document)
	 * Creates a new document in the hierarchy. 
	 */
	@Override
	public Long addDocument(Document document) {
		
		//4. insert the new document to the hierarchy
		Long newDocumentId = dsl.insertInto(DOCUMENT_TREE,
				DOCUMENT_TREE.PARENT_ID,
				DOCUMENT_TREE.NAME,
				DOCUMENT_TREE.DESCRIPTION)
			.values(document.getParentId(),
					document.getName(),
					document.getDescription())
			.returning()
			.fetchOne().getId();

		return newDocumentId;
	}

}
