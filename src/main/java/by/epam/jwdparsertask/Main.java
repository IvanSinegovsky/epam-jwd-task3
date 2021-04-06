package by.epam.jwdparsertask;

import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new XmlParser(
                new File("notes.xml")
        );

        Node root = parser.parse();

        parser.close();
    }
}