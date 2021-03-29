package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;
import by.epam.jwdparsertask.editor.Editor;
import by.epam.jwdparsertask.entity.Attribute;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.editor.XmlFileEditor;
import by.epam.jwdparsertask.entity.Tag;
import by.epam.jwdparsertask.exception.InvalidXmlFileException;

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

        System.out.println(rootNode);

        setContent(editedLine, rootNode);
        setAttributes(tags, rootNode);

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
        if (tags.isEmpty()) {
            throw new InvalidXmlFileException("Invalid xml-file syntax");
        }

        Node rootNode = new Node(tags.get(0));

        Node parentNode = new Node(tags.get(1));
        parentNode.setParentNode(rootNode);

        Node childNode = new Node(tags.get(2));
        childNode.setParentNode(parentNode);

        for (int i = 0; i < tags.size() - 1 ; i++) {
            if (childNode.getTag().getIsEndTag()) {
                //down
                childNode = parentNode;
                parentNode = parentNode.getParentNode();
            } else {
                //up
                parentNode = childNode;
                childNode = new Node(tags.get(i));
                parentNode.addChildNode(childNode);
            }
        }

        return rootNode;
    }

    private void setContent(String line, Node rootNode) {
        String contentAndEndTag;
        Pattern contentPattern = Pattern.compile("[^>]+<\\/?\\w*\\:*[^>]*>");
        Matcher contentMatcher = contentPattern.matcher(line);

        while (contentMatcher.find()) {
            contentAndEndTag = contentMatcher.group();
            rootNode.searchNodeToSetContent(extractTag(contentAndEndTag), contentAndEndTag);
        }
    }

    private Tag extractTag(String line) {
        Tag tag = new Tag(line);
        return tag;
}

    private void setAttributes(List<Tag> tags, Node rootNode) {
        for (Tag tag : tags) {
            rootNode.searchNodeToSetAttributes(tag, tag.getAttributes());
        }
    }

    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
