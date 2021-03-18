package by.epam.jwdparsertask;

import by.epam.jwdparsertask.refactorer.XmlFileRedactor;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        XmlFileRedactor.redactXmlFile(
                new File(
                        "C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml"
                )
        );
    }
}
