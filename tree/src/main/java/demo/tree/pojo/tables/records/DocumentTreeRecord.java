/*
 * This file is generated by jOOQ.
 */
package demo.tree.pojo.tables.records;


import demo.tree.pojo.tables.DocumentTree;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DocumentTreeRecord extends UpdatableRecordImpl<DocumentTreeRecord> implements Record7<Long, Long, String, String, Long, Long, Long> {

    private static final long serialVersionUID = 708415324;

    /**
     * Setter for <code>tree_demo.document_tree.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tree_demo.document_tree.parent_id</code>.
     */
    public void setParentId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>tree_demo.document_tree.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tree_demo.document_tree.description</code>.
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tree_demo.document_tree.left_branch</code>.
     */
    public void setLeftBranch(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.left_branch</code>.
     */
    public Long getLeftBranch() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>tree_demo.document_tree.right_branch</code>.
     */
    public void setRightBranch(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.right_branch</code>.
     */
    public Long getRightBranch() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>tree_demo.document_tree.level</code>.
     */
    public void setLevel(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>tree_demo.document_tree.level</code>.
     */
    public Long getLevel() {
        return (Long) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, String, String, Long, Long, Long> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, Long, String, String, Long, Long, Long> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return DocumentTree.DOCUMENT_TREE.ID;
    }

    @Override
    public Field<Long> field2() {
        return DocumentTree.DOCUMENT_TREE.PARENT_ID;
    }

    @Override
    public Field<String> field3() {
        return DocumentTree.DOCUMENT_TREE.NAME;
    }

    @Override
    public Field<String> field4() {
        return DocumentTree.DOCUMENT_TREE.DESCRIPTION;
    }

    @Override
    public Field<Long> field5() {
        return DocumentTree.DOCUMENT_TREE.LEFT_BRANCH;
    }

    @Override
    public Field<Long> field6() {
        return DocumentTree.DOCUMENT_TREE.RIGHT_BRANCH;
    }

    @Override
    public Field<Long> field7() {
        return DocumentTree.DOCUMENT_TREE.LEVEL;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getParentId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getDescription();
    }

    @Override
    public Long component5() {
        return getLeftBranch();
    }

    @Override
    public Long component6() {
        return getRightBranch();
    }

    @Override
    public Long component7() {
        return getLevel();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getParentId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getDescription();
    }

    @Override
    public Long value5() {
        return getLeftBranch();
    }

    @Override
    public Long value6() {
        return getRightBranch();
    }

    @Override
    public Long value7() {
        return getLevel();
    }

    @Override
    public DocumentTreeRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value2(Long value) {
        setParentId(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value5(Long value) {
        setLeftBranch(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value6(Long value) {
        setRightBranch(value);
        return this;
    }

    @Override
    public DocumentTreeRecord value7(Long value) {
        setLevel(value);
        return this;
    }

    @Override
    public DocumentTreeRecord values(Long value1, Long value2, String value3, String value4, Long value5, Long value6, Long value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DocumentTreeRecord
     */
    public DocumentTreeRecord() {
        super(DocumentTree.DOCUMENT_TREE);
    }

    /**
     * Create a detached, initialised DocumentTreeRecord
     */
    public DocumentTreeRecord(Long id, Long parentId, String name, String description, Long leftBranch, Long rightBranch, Long level) {
        super(DocumentTree.DOCUMENT_TREE);

        set(0, id);
        set(1, parentId);
        set(2, name);
        set(3, description);
        set(4, leftBranch);
        set(5, rightBranch);
        set(6, level);
    }
}
