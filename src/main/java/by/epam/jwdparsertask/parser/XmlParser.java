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

public class XmlParser implements Parser, Closeable{
    private File file;
    private FileDao fileDao;

    public XmlParser(File file) throws IOException {
        this.file = file;
        this.fileDao = new XmlFileDao(file);
    }

    public Node parse() throws IOException {
        String editedLine = fileToEditedLines();
        List<Tag> tags = Tag.parseTags(editedLine);
        List<String> content = extractContent(editedLine);
        Node rootNode = treeFromTags(tags, content);

        return rootNode;
    }

    private String fileToEditedLines() throws IOException {
        Editor editor = new XmlFileEditor(file);

        return editor.fileToEditedLine();
    }

    private Node treeFromTags(List<Tag> tags, List<String> content) {
        Node rootNode = new Node(tags.get(0));

        Node parentNode = new Node(tags.get(1));
        parentNode.setParentNode(rootNode);

        Node childNode = new Node(tags.get(2));
        childNode.setParentNode(parentNode);

        for (int i = 3, j = 0; i < tags.size()  && j < content.size(); i++) {
            if (tags.get(i).getIsEndTag()) {
                //go down the tree
                childNode.setContent(content.get(j).substring(0, content.get(j).length() - 1));
                j++;
                childNode = parentNode;
                parentNode = parentNode.getParentNode();
            } else {
                //go up the tree
                parentNode = childNode;
                childNode = new Node(tags.get(i));
                parentNode.addChildNode(childNode);
            }
        }

        return rootNode;
    }

    private List<String> extractContent(String line) {
        List<String> content = new ArrayList<>();

        Pattern contentPattern = Pattern.compile("[^>]+<");
        Matcher contentMatcher = contentPattern.matcher(line);

        while (contentMatcher.find()) {
            content.add(contentMatcher.group());
        }

        return content;
    }

    private Tag extractTag(String line) {
        Tag tag = new Tag(line);
        return tag;
    }

    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
