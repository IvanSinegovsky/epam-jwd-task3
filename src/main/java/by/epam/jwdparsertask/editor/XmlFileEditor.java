package by.epam.jwdparsertask.editor;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;

import java.io.*;
import java.util.List;

public class XmlFileEditor implements Editor, Closeable {
    private FileDao fileDao;

    public XmlFileEditor(File file) {
        fileDao = new XmlFileDao(file);
    }

    public String fileToEditedLine() throws IOException {
        List<String> initialLines = fileDao.getLines();
        StringBuilder editedLine = new StringBuilder(initialLines.size() * 20);

        for (String initialLine : initialLines) {
            editedLine.append(initialLine);
        }

        return removeSpaces(editedLine.toString());
    }

    private String removeSpaces(String line) {
        String lineWithoutSpaces = line.replaceAll("\t|  ", "");

        return lineWithoutSpaces;
    }

    @Override
    public void close() throws IOException {
        fileDao.close();
    }
}
