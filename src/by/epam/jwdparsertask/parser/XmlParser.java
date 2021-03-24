package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;
import by.epam.jwdparsertask.editor.Editor;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.editor.XmlFileEditor;

import java.io.*;

public class XmlParser implements Parser {

    private File file;
    private FileDao fileDao;

    public XmlParser(File file) {
        this.file = file;
        this.fileDao = new XmlFileDao(file);
    }

    public Node parse() throws IOException {
        Node rootNode;

        String editedLine = fileToEditedLines();
        rootNode = linesListToNode(editedLine);

        return rootNode;
    }

    private String fileToEditedLines() throws IOException {
        Editor editor = new XmlFileEditor(file);
        return editor.fileToEditedLine();
    }

    private Node linesListToNode(String line) {
        return null;
    }


    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
