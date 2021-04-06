package by.epam.jwdparsertask.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileDao implements FileDao, Closeable {
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private File file;

    public XmlFileDao(File file) throws IOException {
        this.file = file;
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public List<String> getLines() throws IOException {

        List<String> fileLines = new ArrayList<>(50);

        String currentLine = bufferedReader.readLine();

        while (currentLine != null) {
            if (!currentLine.contains("<?")){
                fileLines.add(currentLine);
            }

            currentLine = bufferedReader.readLine();
        }

        return fileLines;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
