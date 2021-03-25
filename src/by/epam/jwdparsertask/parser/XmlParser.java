package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;
import by.epam.jwdparsertask.editor.Editor;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.editor.XmlFileEditor;
import by.epam.jwdparsertask.entity.Tag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser implements Parser {

    private File file;
    private FileDao fileDao;

    public XmlParser(File file) {
        this.file = file;
        this.fileDao = new XmlFileDao(file);
    }

    public Node parse() throws IOException {
        String editedLine = fileToEditedLines();

        List<Tag> tags = parseTags(editedLine);

        Node rootNode = treeFromTags(tags);

        setContent(editedLine, rootNode);

        return rootNode;
    }

    private String fileToEditedLines() throws IOException {
        Editor editor = new XmlFileEditor(file);

        return editor.fileToEditedLine();
    }

    private List<Tag> parseTags(String line) {
        List<Tag> tags = new ArrayList<>();

        Pattern tagPattern = Pattern.compile("<\\/?\\w*\\:*[^>]*>");
        Matcher tagMatcher = tagPattern.matcher(line);

        while (tagMatcher.find()) {
            tags.add(new Tag(tagMatcher.group()));
        }

        return tags;
    }

    private Node treeFromTags(List<Tag> tags) {
        Tag overlyingTag = tags.get(0);
        Tag underlyingTag = tags.get(1);

        Node rootNode = new Node(overlyingTag);
        rootNode.setParentNode(null);

        Node overlyingNode = new Node(overlyingTag);

        Node underlyingNode = overlyingNode;
        underlyingNode.setParentNode(rootNode);

        for (int i = 1; i < tags.size(); i++) {
            underlyingTag = tags.get(i);

            if (!tags.get(i).isEndTag()) {
                underlyingNode = new Node(tags.get(i));
            } else {
                underlyingNode = overlyingNode;
                overlyingNode = overlyingNode.getParentNode();

                overlyingTag = overlyingNode.getTag();
            }
        }

        return rootNode;
    }

    private void setContent(String line, Node rootNode) {
        Pattern contentPattern = Pattern.compile("[^>]+<\\/?\\w*\\:*[^>]*>");
        Matcher contentMatcher = contentPattern.matcher(line);

        List<String> contents = new ArrayList<>();

        while (contentMatcher.find()) {
            contents.add(contentMatcher.group());
        }

        removeParenthesisFromContent(contents);

        //TODO OBHOD PO DEREVU
    }

    private void removeParenthesisFromContent(List<String> contents) {
        for (int i = 0; i < contents.size(); i++) {
            contents.set(i, contents.get(i).substring(1, contents.get(i).length() - 1));
        }
    }

    private void setAttributes(String line, Node rootNode) {
        //TODO OBHOD PO DEREVU
    }

    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
