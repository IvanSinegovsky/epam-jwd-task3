package by.epam.jwdparsertask.dao;

import java.io.IOException;
import java.util.List;

public interface FileDao {
    List<String> getLines() throws IOException;
    void close() throws IOException;
}
