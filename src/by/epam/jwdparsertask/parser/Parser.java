package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.node.Node;

import java.io.File;
import java.io.IOException;

public interface Parser {
   Node parse(File file) throws IOException;
}
