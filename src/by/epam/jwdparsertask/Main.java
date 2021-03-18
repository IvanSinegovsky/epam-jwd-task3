package by.epam.jwdparsertask;

import by.epam.jwdparsertask.refactorer.XmlFileRedactor;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        XmlFileRedactor xmlFileRedactor = new XmlFileRedactor();

        xmlFileRedactor.redactXmlFile(
                new File(
                        "C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\students2.xml"
                )
        );
    }
}
