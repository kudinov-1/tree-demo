package demo.tree.services;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.tree.dto.Document;
import demo.tree.dto.DocumentFlatItem;

@Service
public interface DocumentTreeService {

	
	/**
	 * Returns a hierarchical view of the documents under the given document (including the given document) 
	 * @param documentId
	 * @return
	 */
	public Document getDocumentTree(Long documentId);

	/**
	 * Returns a list of documents in the hierarchy, located under the given document (including the given document)
	 * The returning list of documents has a plain structure, not hierarchical
	 * @param documentId
	 * @return List<DocumentEntity> - list of documents
	 */
	public List<DocumentFlatItem> getDocumentList(Long documentId);
	
	/**
	 * Creates a new document in the hierarchy. 
	 * @param documentEntity Contains the new document data, including an ID of the parent element, where the new document has to be created 
	 * @return Returns an id of the newly created document
	 * @throws Exception 
	 */
	public Long addDocument(Document documentEntity) throws Exception;
}
