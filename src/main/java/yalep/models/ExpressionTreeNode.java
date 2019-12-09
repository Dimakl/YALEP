package yalep.models;

import org.antlr.v4.runtime.tree.ParseTree;

public class ExpressionTreeNode {

    NodeType type;
    String nodeText;
    Boolean isNegated;
    ExpressionTreeNode next;
    Integer boxStartX;
    Integer boxStartY;
    Boolean occupied = false;

    // конструктор поменять
    public ExpressionTreeNode(ParseTree node, Boolean isNegated, NodeType nodeType, ExpressionTreeNode next) {
        this.type = nodeType;
        this.next = next;
        this.nodeText = node.getText();
        this.isNegated = isNegated;
    }

    public enum NodeType {
        VARIABLE,
        OR,
        AND,
        PARENS,
        XOR
    }

}
