package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.attribute.Attribute;
import by.epam.jwdparsertask.node.Node;
import by.epam.jwdparsertask.refactorer.XmlFileRedactor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlParser implements Parser {

    public static String parse(File file) throws IOException {
        XmlFileRedactor.redactXmlFile(file);

        return null;
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
        fileReader.close();

        return fileLines;
    }

    private Node linesListToNode(List<String> fileLines) {
        Node rootElement = new Node(getNameFromTag(fileLines.get(0)));
        Node previousNode = new Node(getNameFromTag(fileLines.get(1)), getAttributesFromTag(fileLines.get(1)));

        int nestingLevel = 1;

        for (int i = 0; !isEndTag(rootElement.getName()); i++) {
            if (nestingLevel == 1) {
                rootElement.addChildNode(previousNode);
            }

            if (previousNode.getContent().equals(null)) {
                nestingLevel++;
            }

            if (isEndTag(previousNode.getName())) {
                nestingLevel--;
            }

            previousNode = new Node(getNameFromTag(fileLines.get(i)), getAttributesFromTag(fileLines.get(i)));
        }

        return rootElement;
    }

    private String getNameFromTag(String tag) {
        String name = "name";

        return name;
    }

    private boolean isEndTag(String tagName) {
        if (true) {
            return true;
        }

        return false;
    }

    private List<Attribute> getAttributesFromTag(String tag) {
        return new ArrayList<>();
    }
}
