package by.epam.jwdparsertask.editor;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileEditor implements Editor, Closeable {

    private FileDao fileDao;

    public XmlFileEditor(File file) {
        fileDao = new XmlFileDao(file);
    }

    public List<String> fileToEditedLines() throws IOException {
        List<String> initialLines = fileDao.getLines();
        List<String> editedLines = new ArrayList<>(initialLines.size());

        for (String initialLine : initialLines) {
            editedLines.add(lineEditor(initialLine));
        }

        return editedLines;
    }

    private String lineEditor(String initialLine) {
        StringBuilder editedLine = new StringBuilder(initialLine);

        if (initialLine.contains("<?")
                || ("".equals(initialLine))
                || ("\t".equals(initialLine))
                || ("\n".equals(initialLine))) {
            return "";
        } else if (initialLine.contains("<")) {
            editedLine.insert(initialLine.indexOf('<'), "\n");
        }

        return editedLine.toString();
    }

    @Override
    public void close() throws IOException {
        fileDao.close();
    }
}
