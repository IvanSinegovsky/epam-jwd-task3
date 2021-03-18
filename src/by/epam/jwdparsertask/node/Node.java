package by.epam.jwdparsertask.node;

import by.epam.jwdparsertask.attribute.Attribute;

import java.util.List;

public class Node {

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
}
