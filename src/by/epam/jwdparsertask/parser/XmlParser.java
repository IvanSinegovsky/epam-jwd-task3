package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.model.Attribute;
import by.epam.jwdparsertask.model.Node;
import by.epam.jwdparsertask.refactorer.XmlFileRedactor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlParser implements Parser {

    public Node parse(File file) throws IOException {
        Node rootNode;

        XmlFileRedactor xmlFileRedactor = new XmlFileRedactor();
        xmlFileRedactor.redactXmlFile(file);

        List<String> fileLines = readFileByTheLine(file);
        rootNode = linesListToNode(fileLines);

        return rootNode;
    }

    private List<String> readFileByTheLine (File file) throws IOException {
        List<String> fileLines = new ArrayList<>(50);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        while (line != null) {
            fileLines.add(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return fileLines;
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
        if (tag.contains(" ")) {
            tag = tag.substring(1, tag.indexOf(' '));
        } else {
            tag = tag.substring(1, tag.indexOf('>'));
        }

        return tag;
    }

    private boolean isEndTag(String tagName) {
        if (tagName.charAt(1) == '/') {
            return true;
        }

        return false;
    }

    private List<Attribute> getAttributesFromTag(String tag) {
        int attributesQuantity = attributesQuantity(tag);
        List<Attribute> attributes = new ArrayList<>(attributesQuantity);

        int attributeBegins = tag.indexOf(' ');
        int attributeEnds = tag.length() - 1;

        String tagPart = tag.substring(attributeBegins + 1, attributeEnds);

        attributeEnds = tagPart.indexOf(' ');

        for (int i = 0; i < attributesQuantity; i++) {
            attributes.add(getAttribute(tagPart.substring(0, attributeEnds)));

            attributeBegins = attributeEnds;
            tagPart = tag.substring(attributeBegins, tag.length() - 1);
            attributeEnds = tagPart.indexOf(' ');
        }

        return attributes;
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
}
