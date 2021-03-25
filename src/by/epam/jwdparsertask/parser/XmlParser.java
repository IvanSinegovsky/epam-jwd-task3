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
        Node rootNode = new Node();
        String editedLine = fileToEditedLines();

        List<Tag> tags = parseTags(editedLine);

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
            return null;
        }

        Tag overlyingTag = tags.get(0);
        Tag underlyingTag = tags.get(1);

        Node rootNode = new Node(overlyingTag);
        Node overlying = new Node(overlyingTag);
        Node underlying = overlying;

        for (int i = 1; i < tags.size(); i++) {
            overlyingTag = underlyingTag;
            underlyingTag = tags.get(i);



            if (!underlyingTag.isEndTag()) {    //низший не закрывающийся - спускаемся
                overlying.addChildNode(overlying);
            } else {                            //поднимаемся

            }
        }


        return null;
    }














    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
