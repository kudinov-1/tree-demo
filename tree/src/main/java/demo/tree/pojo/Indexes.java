/*
 * This file is generated by jOOQ.
 */
package demo.tree.pojo;


import demo.tree.pojo.tables.DocumentTree;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>tree_demo</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index DOCUMENT_TREE_DOC_TREE_LEFT_IDX = Indexes0.DOCUMENT_TREE_DOC_TREE_LEFT_IDX;
    public static final Index DOCUMENT_TREE_DOC_TREE_LEFTRIGHT_IDX = Indexes0.DOCUMENT_TREE_DOC_TREE_LEFTRIGHT_IDX;
    public static final Index DOCUMENT_TREE_DOC_TREE_PARENT_FK_IDX = Indexes0.DOCUMENT_TREE_DOC_TREE_PARENT_FK_IDX;
    public static final Index DOCUMENT_TREE_DOC_TREE_RIGHT_IDX = Indexes0.DOCUMENT_TREE_DOC_TREE_RIGHT_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index DOCUMENT_TREE_DOC_TREE_LEFT_IDX = Internal.createIndex("doc_tree_left_IDX", DocumentTree.DOCUMENT_TREE, new OrderField[] { DocumentTree.DOCUMENT_TREE.LEFT_BRANCH }, false);
        public static Index DOCUMENT_TREE_DOC_TREE_LEFTRIGHT_IDX = Internal.createIndex("doc_tree_leftright_IDX", DocumentTree.DOCUMENT_TREE, new OrderField[] { DocumentTree.DOCUMENT_TREE.LEFT_BRANCH, DocumentTree.DOCUMENT_TREE.RIGHT_BRANCH }, false);
        public static Index DOCUMENT_TREE_DOC_TREE_PARENT_FK_IDX = Internal.createIndex("doc_tree_parent_FK_idx", DocumentTree.DOCUMENT_TREE, new OrderField[] { DocumentTree.DOCUMENT_TREE.PARENT_ID }, false);
        public static Index DOCUMENT_TREE_DOC_TREE_RIGHT_IDX = Internal.createIndex("doc_tree_right_IDX", DocumentTree.DOCUMENT_TREE, new OrderField[] { DocumentTree.DOCUMENT_TREE.RIGHT_BRANCH }, false);
    }
}
