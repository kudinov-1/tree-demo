/*
 * This file is generated by jOOQ.
 */
package demo.tree.pojo.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DocumentTree implements Serializable {

    private static final long serialVersionUID = -706236801;

    private Long   id;
    private Long   parentId;
    private String name;
    private String description;
    private Long   leftBranch;
    private Long   rightBranch;
    private Long   level;

    public DocumentTree() {}

    public DocumentTree(DocumentTree value) {
        this.id = value.id;
        this.parentId = value.parentId;
        this.name = value.name;
        this.description = value.description;
        this.leftBranch = value.leftBranch;
        this.rightBranch = value.rightBranch;
        this.level = value.level;
    }

    public DocumentTree(
        Long   id,
        Long   parentId,
        String name,
        String description,
        Long   leftBranch,
        Long   rightBranch,
        Long   level
    ) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.leftBranch = leftBranch;
        this.rightBranch = rightBranch;
        this.level = level;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLeftBranch() {
        return this.leftBranch;
    }

    public void setLeftBranch(Long leftBranch) {
        this.leftBranch = leftBranch;
    }

    public Long getRightBranch() {
        return this.rightBranch;
    }

    public void setRightBranch(Long rightBranch) {
        this.rightBranch = rightBranch;
    }

    public Long getLevel() {
        return this.level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DocumentTree (");

        sb.append(id);
        sb.append(", ").append(parentId);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(leftBranch);
        sb.append(", ").append(rightBranch);
        sb.append(", ").append(level);

        sb.append(")");
        return sb.toString();
    }
}
