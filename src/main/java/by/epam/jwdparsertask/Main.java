package by.epam.jwdparsertask;

import by.epam.jwdparsertask.dao.FileDao;
import by.epam.jwdparsertask.entity.Attribute;
import by.epam.jwdparsertask.entity.Node;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new XmlParser(
                new File("notes.xml")
        );

        Node root = parser.parse();
        System.out.println(root.toString());
    }
}