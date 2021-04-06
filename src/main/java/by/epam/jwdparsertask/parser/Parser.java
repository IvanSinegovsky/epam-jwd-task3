package by.epam.jwdparsertask.parser;

import by.epam.jwdparsertask.entity.Node;

import java.io.IOException;

public interface Parser {
   Node parse() throws IOException;
   void close() throws IOException;
}
