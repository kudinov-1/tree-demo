package demo.tree.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Setter;

public class DocumentRequest extends Document {
	@ApiModelProperty(hidden = true) 
	@Setter(AccessLevel.NONE)
	private Long id;

	@ApiModelProperty(hidden = true) 
	@Setter(AccessLevel.NONE)
	private List<Document> children;

	@ApiModelProperty(hidden = true) 
	@Setter(AccessLevel.NONE)
	private Long level;
}
