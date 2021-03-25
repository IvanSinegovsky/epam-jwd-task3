package by.epam.jwdparsertask.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {

    private Tag tag;
    private List<Attribute> attributes;
    private List<Node> nodes;
    private String content;

    public Node() {
    }

    public Node(Tag tag) {
        this.tag = tag;
    }

    public Node(Tag tag, List<Attribute> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public Tag getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public void addChildNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + tag + '\'' +
                ", attributes=" + attributes +
                ", nodes=" + nodes +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        return Objects.equals(tag, node.tag)
                && Objects.equals(attributes, node.attributes)
                && Objects.equals(nodes, node.nodes)
                && Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, attributes, nodes, content);
    }
}
