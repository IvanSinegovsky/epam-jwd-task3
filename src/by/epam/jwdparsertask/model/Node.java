package by.epam.jwdparsertask.model;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {

    private String name;
    private List<Attribute> attributes;
    private List<Node> nodes;
    private String content;

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
}
