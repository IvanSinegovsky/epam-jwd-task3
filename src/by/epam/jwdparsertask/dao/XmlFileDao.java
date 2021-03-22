package by.epam.jwdparsertask.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileDao implements FileDao, Closeable {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private File file;

    public XmlFileDao(File file) {
        this.file = file;
    }

    public List<String> getLines() throws IOException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);

        List<String> fileLines = new ArrayList<>(50);

        String line = bufferedReader.readLine();

        while (line != null) {
            fileLines.add(line);
            line = bufferedReader.readLine();
        }

        return fileLines;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
        fileWriter.close();
    }

    @Override
    public void writeLines(List<String> lines, File file) throws IOException {
        fileWriter = new FileWriter(file, true);

        for(String line : lines) {
            fileWriter.write(line);
        }
    }

    public void cleanFile(File file) throws IOException {
        fileWriter = new FileWriter(file, false);
        fileWriter.write("");
    }
}
