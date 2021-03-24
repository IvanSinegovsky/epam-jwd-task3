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

    //прочитать строку от < до >
    private String linesToElement(List<String> initialLines) {
        StringBuilder element = new StringBuilder();
        String line;

        boolean hasCloseParenthesis = false;

        for (int i = 0; i < initialLines.size(); i++) {
            while (!hasCloseParenthesis) {
                element.append(line);

                if (initialLines.get(i).contains(">")) {
                    hasCloseParenthesis = true;

                    line = initialLines.get(i).;
                }
                i++;
            }
        }


        return element.toString();
    }

    //записать содержимое в одну строку
    //редактировать вышестоящую строку(избавить от пробелов и т д)
    //контент должен быть ондельным элементом листа
















    @Override
    public void close() throws IOException {
        fileDao.close();
    }
}
