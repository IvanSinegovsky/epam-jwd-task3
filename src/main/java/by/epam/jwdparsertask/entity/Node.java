package by.epam.jwdparsertask.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {
    private Tag tag;
    private List<Node> childNodes = new ArrayList<>();
    private Node parentNode;
    private String content;

    public Node() { }

    public Node(Tag tag) {
        this.tag = tag;
    }

    public Node(Tag tag, List<Node> childNodes, Node parentNode, String content) {
        this.tag = tag;
        this.childNodes = childNodes;
        this.parentNode = parentNode;
        this.content = content;
    }

    public void addChildNode(Node node) {
        childNodes.add(node);
        if (node.getParentNode() == null) {
            node.setParentNode(this);
        }
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

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setParentNode(Node parentNode) {
        if (!parentNode.getChildNodes().contains(this)){
            parentNode.addChildNode(this);
        }

        this.parentNode = parentNode;
    }

    public void output() {
        treeOutput(new StringBuilder(), 1);
    }

    /**
     * Provides tree output like:
     *
     * 	Node tc has no content and has 1 child(ren):
     * 			Node note has no content and has 4 child(ren):
     * 				Node to has content "Вася" and 0 child(ren):
     * 				Node from has content "Света" and 0 child(ren):
     * 				Node heading has content "Напоминание" and 0 child(ren):
     * 				Node body has content "Позвони мне завтра!" and 0 child(ren):
     */
    private void treeOutput(StringBuilder tabulations, int counter) {
        for (int i = 0; i < counter; i++) {
            tabulations.append('\t');
        }

        if (content != null) {
            System.out.println(tabulations + "Node " + tag.getName() + " has content \"" + content + "\" and "
                    + childNodes.size() + " child(ren):");
        } else {
            System.out.println(tabulations + "Node " + tag.getName() + " has no content and has "
                    + childNodes.size() + " child(ren):");
        }

        for (int i = 0; i < childNodes.size(); i++) {
            if (i == childNodes.size() - 1) {
                counter++;
            } else {
                counter--;
            }

            childNodes.get(i).treeOutput(tabulations, counter);
        }

        if (childNodes.size() == 0) {
            return;
        }
    }

    @Override
    public String toString() {
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
        return Objects.equals(tag, node.tag) && Objects.equals(childNodes, node.childNodes) && Objects.equals(parentNode, node.parentNode) && Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, childNodes, parentNode, content);
    }
}
