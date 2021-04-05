package by.epam.jwdparsertask;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new XmlParser(
                new File(System.getProperty("notes.xml"))
        );

        Node root = parser.parse();
        System.out.println(root.toString());
    }
}