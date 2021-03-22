package by.epam.jwdparsertask.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {

    private String name;
    private List<Attribute> attributes;
    private List<Node> nodes;
    private String content;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, List<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
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
                "name='" + name + '\'' +
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

        return Objects.equals(name, node.name)
                && Objects.equals(attributes, node.attributes)
                && Objects.equals(nodes, node.nodes)
                && Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attributes, nodes, content);
    }
}
