package by.epam.jwdparsertask.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileDao implements FileDao, Closeable {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private File file;

    public XmlFileDao(File file) {
        this.file = file;
    }

    public List<String> getLines() throws IOException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);

        List<String> fileLines = new ArrayList<>(50);

        String currentLine = bufferedReader.readLine();

        while (currentLine != null) {
            fileLines.add(currentLine);
            currentLine = bufferedReader.readLine();
        }

        return fileLines;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
