package by.epam.jwdparsertask.entity;

import by.epam.jwdparsertask.exception.InvalidXmlFileException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {

    private Tag tag;
    private List<Node> childNodes;
    private Node parentNode;
    private String content;

    public Node() {
    }

    public Node(Tag tag) {
        this.tag = tag;
    }

    public void addChildNode(Node node) {
        childNodes.add(node);
    }

    public void searchNodeToSetContent(Tag tagToCompare, String content) {
        searchNodeByTag(tagToCompare).setContent(content);
    }

    public void searchNodeToSetAttributes(Tag tagToCompare, List<Attribute> attributes) {
        searchNodeByTag(tagToCompare).getTag().setAttributes(attributes);
    }

    private Node searchNodeByTag(Tag tagToCompare) {
        int nullChildrenQuantity = 0;

        for (Node childNode : childNodes) {
            if (nullChildrenQuantity == childNodes.size()) {
                throw new InvalidXmlFileException("Invalid xml-file syntax");
            } else if (childNodes.isEmpty() || childNode != null) {
                if (tagToCompare.equals(tag)) {
                    return childNode;
                }
                searchNodeByTag(tagToCompare);
            } else {
                nullChildrenQuantity++;
            }
        }

        return null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Tag getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        //TODO CHANGE TO VALID FOR OUTPUT

        return "Node{" +
                "tag=" + tag +
                ", childNodes=" + childNodes +
                ", parentNode=" + parentNode +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return tag.equals(node.tag) && Objects.equals(childNodes, node.childNodes) && Objects.equals(parentNode, node.parentNode) && Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, childNodes, parentNode, content);
    }
}
