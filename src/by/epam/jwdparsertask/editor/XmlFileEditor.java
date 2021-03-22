package by.epam.jwdparsertask.editor;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.dao.XmlFileDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileEditor implements Editor, Closeable {

    private File tempXmlFile;
    private FileDao fileDao;

    public XmlFileEditor() {
        tempXmlFile = new File(String.valueOf(new File("temp.xml").getAbsoluteFile()));
    }

    public void editFile(File file) throws IOException {
        fileDao = new XmlFileDao(file);

        List<String> initialLines = fileDao.getLines();
        List<String> editedLines = linesEditor(initialLines);

        fileDao.cleanFile(tempXmlFile);
        fileDao.writeLines(editedLines, tempXmlFile);
    }

    private List<String> linesEditor(List<String> initialLines) {
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

    public File getTempXmlFile() {
        return tempXmlFile;
    }

    @Override
    public void close() throws IOException {
        fileDao.close();
    }
}
