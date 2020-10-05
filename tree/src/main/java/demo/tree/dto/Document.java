package demo.tree.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Document {

	private Long id;
	private Long parentId;
	private String name;
	private String description;
	private Long level;
	private List<Document> children = new ArrayList<Document>();
}
