package by.epam.jwdparsertask;

import by.epam.jwdparsertask.editor.XmlFileEditor;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
/*
        XmlFileEditor xmlFileEditor
                = new XmlFileEditor(
                        new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml"));

        String editedLine = xmlFileEditor.fileToEditedLine();

        System.out.println(editedLine);

        //nice tag patterns:
        //<\/?\w*>
        //"<\\/?\\w*\\:?\\w*>"
        //"<\\/?\\w*\\:?[^>]*>"
        //"<\\/?\\w*\\:*[^>]*>"

        //content patterns:
        //"[^>]+<\\/?\\w*\\:*[^>]*>"

        Pattern tagPattern = Pattern.compile("<\\/?\\w*\\:*[^>]*>");

        Matcher tagMatcher = tagPattern.matcher(editedLine);

        while (tagMatcher.find()){
            System.out.println(tagMatcher.group());
        }
*/


        Parser parser = new XmlParser(
                new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml")
        );

        parser.parse();
    }
}

/*  ТРЕБОВАНИЯ    */

/*
* 1) ЧТЕНИЕ ФАЙЛА ПО ЧАСТЯМ
* 2) РАСПАРСИТЬ НА УЗЛЫ
* 3) СОБРАТЬ ДЕРЕВО
*
* КОНСТРУКТОРЫ БЕЗ ПАРАМЕТРОВ
*
* use lambdas and method references
*
* */