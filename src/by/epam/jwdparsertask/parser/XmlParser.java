package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.model.Attribute;
import by.epam.jwdparsertask.model.Node;
import by.epam.jwdparsertask.editor.XmlFileEditor;

import java.io.*;
import java.util.List;

public class XmlParser implements Parser {

    private File file;
    private FileDao fileDao;

    public XmlParser(File file) {
        this.file = file;
    }

    public Node parse() throws IOException {

        Node rootNode;

        redactFile();

        List<String> fileLines = readFileByTheLine(file);
        rootNode = linesListToNode(fileLines);

        return rootNode;
    }

    private void redactFile() throws IOException {
        XmlFileEditor xmlFileEditor = new XmlFileEditor();
        xmlFileEditor.editFile(file);
    }

    private Node linesListToNode(List<String> fileLines) {
        Node rootElement = new Node(getNameFromTag(fileLines.get(0)));
        Node previousNode = new Node(getNameFromTag(fileLines.get(1)), getAttributesFromTag(fileLines.get(1)));

        boolean isDeepInto = true;

        for (int i = 0; !isEndTag(rootElement.getName()); i++) {
            if (isDeepInto = true) {
                rootElement.addChildNode(previousNode);
            }

            if (previousNode.getContent().equals(null)) {
                isDeepInto = true;
            }

            if (isEndTag(previousNode.getName())) {
                isDeepInto = false;
            }

            previousNode = new Node(getNameFromTag(fileLines.get(i)), getAttributesFromTag(fileLines.get(i)));
        }

        return rootElement;
    }

    private String getNameFromTag(String tag) {
        return null;
    }

    private boolean isEndTag(String tagName) {
        return false;
    }

    private List<Attribute> getAttributesFromTag(String tag) {
        return null;
    }

    private int attributesQuantity(String tag) {
        int attributesQuantity = 0;

        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) == '=') {
                attributesQuantity++;
            }
        }

        return attributesQuantity;
    }

    private Attribute getAttribute(String tagPart) {
        String attributeName = tagPart.substring(0, '=');
        String attributeValue = tagPart.substring(attributeName.length() + 1, tagPart.length() - 1);

        Attribute attribute = new Attribute(attributeName, attributeValue);

        return attribute;
    }

    public void close() throws IOException {
        ///////////
    }

    public void setFile(File file) {
        this.file = file;
    }
}
