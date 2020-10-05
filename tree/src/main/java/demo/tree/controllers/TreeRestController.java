package demo.tree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.tree.dto.Document;
import demo.tree.dto.DocumentFlatItem;
import demo.tree.dto.DocumentRequest;
import demo.tree.services.DocumentTreeService;
import io.swagger.annotations.Api;


@Api
@RestController("TreeRestController")
@RequestMapping("api")
public class TreeRestController {

	
	@Autowired
	private DocumentTreeService documentTreeService;

	
	/**
	 * This GET REST returns a hierarchical view of the tree, starting from the giveт document ID and all his descendants
	 * @param documentId
	 * @return
	 */
	@GetMapping(value="get-document-tree")
	public ResponseEntity<Document> getDocumentTree(@RequestParam(name = "id", required = true) Long documentId) {
		return ResponseEntity
				.ok(documentTreeService.getDocumentTree(documentId));
	}
	
	
	/**
	 * This GET REST method returns a list of documents starting from the given document ID and all his descendants
	 * The result has a plain list structure 
	 * @param documentId
	 * @return
	 */
	@GetMapping(value="get-document-list")
	public ResponseEntity<List<DocumentFlatItem>> getDocumentList(@RequestParam(name = "id", required = true) Long documentId) {
		List<DocumentFlatItem> documentList = documentTreeService.getDocumentList(documentId);
		return ResponseEntity
				.ok(documentList);
	}
	
	
	/**
	 * This POST REST method adds a new document into the hierarchy
	 * @param Document
	 * @return
	 */
	@PostMapping(value="add-document")
	public ResponseEntity<Long> putDocument(@RequestBody DocumentRequest document) {
		try {
			//try to add a new document
			Long newDocumentId = documentTreeService.addDocument(document);
			//and return an id of the newly created document
			return ResponseEntity
					.ok(newDocumentId);
		} catch (Exception e) {
			//e.printStackTrace();
			//return 500 status code if there is an error during the document creation
			return ResponseEntity
					.status(500).body(null);
		}
	}
}
