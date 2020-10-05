/*
 * This file is generated by jOOQ.
 */
package demo.tree.pojo;


import demo.tree.pojo.tables.DocumentTree;
import demo.tree.pojo.tables.records.DocumentTreeRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>tree_demo</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<DocumentTreeRecord, Long> IDENTITY_DOCUMENT_TREE = Identities0.IDENTITY_DOCUMENT_TREE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DocumentTreeRecord> KEY_DOCUMENT_TREE_PRIMARY = UniqueKeys0.KEY_DOCUMENT_TREE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DocumentTreeRecord, DocumentTreeRecord> DOC_TREE_PARENT_FK = ForeignKeys0.DOC_TREE_PARENT_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<DocumentTreeRecord, Long> IDENTITY_DOCUMENT_TREE = Internal.createIdentity(DocumentTree.DOCUMENT_TREE, DocumentTree.DOCUMENT_TREE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<DocumentTreeRecord> KEY_DOCUMENT_TREE_PRIMARY = Internal.createUniqueKey(DocumentTree.DOCUMENT_TREE, "KEY_document_tree_PRIMARY", new TableField[] { DocumentTree.DOCUMENT_TREE.ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<DocumentTreeRecord, DocumentTreeRecord> DOC_TREE_PARENT_FK = Internal.createForeignKey(Keys.KEY_DOCUMENT_TREE_PRIMARY, DocumentTree.DOCUMENT_TREE, "doc_tree_parent_FK", new TableField[] { DocumentTree.DOCUMENT_TREE.PARENT_ID }, true);
    }
}
