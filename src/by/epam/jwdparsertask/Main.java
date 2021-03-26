package by.epam.jwdparsertask;

import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new XmlParser(
                new File(System.getProperty("notes.xml"))
        );

        System.out.println(parser.parse());
    }
}