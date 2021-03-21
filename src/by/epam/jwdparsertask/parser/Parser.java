package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.model.Node;

import java.io.File;
import java.io.IOException;

public interface Parser {
   Node parse(File file) throws IOException;
}
