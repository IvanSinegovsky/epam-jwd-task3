package by.epam.jwdparsertask;

import by.epam.jwdparsertask.node.Node;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser xmlParser = new XmlParser();
        Node node = xmlParser.parse(new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml"));
    }
}
