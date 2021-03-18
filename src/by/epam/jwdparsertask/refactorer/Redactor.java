package by.epam.jwdparsertask.refactorer;

import java.io.File;
import java.io.IOException;

public interface Redactor {
    void redactXmlFile(File file) throws IOException;
}
