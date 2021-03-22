package by.epam.jwdparsertask.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileDao {
    List<String> getLines() throws IOException;
    void writeLines(List<String> lines, File file) throws IOException;
    void close() throws IOException;
    void cleanFile(File file) throws IOException;
    void setFile(File file);
}
