package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;
import by.epam.jwdparsertask.entity.Attribute;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.editor.XmlFileEditor;

import java.io.*;
import java.util.List;

public class XmlParser implements Parser {

    private File file;
    private FileDao fileDao;

    public XmlParser(File file) {
        this.file = file;
        this.fileDao = new XmlFileDao(file);
    }

    public Node parse() throws IOException {
        Node rootNode;

        fileDao.setFile(redactFile());
        rootNode = linesListToNode(fileDao.getLines());

        return rootNode;
    }

    private File redactFile() throws IOException {
        XmlFileEditor xmlFileEditor = new XmlFileEditor();
        xmlFileEditor.editFile(file);

        return xmlFileEditor.getTempXmlFile();
    }

    private Node linesListToNode(List<String> lines) {
        return null;
    }


    public void close() throws IOException {
        fileDao.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
