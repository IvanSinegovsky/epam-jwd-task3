package by.epam.jwdparsertask.editor;

import java.io.IOException;
import java.util.List;

public interface Editor {
    List<String> fileToEditedLines() throws IOException;
}
