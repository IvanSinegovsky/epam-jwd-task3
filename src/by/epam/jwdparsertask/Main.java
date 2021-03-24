package by.epam.jwdparsertask;

import by.epam.jwdparsertask.editor.XmlFileEditor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlFileEditor xmlFileEditor
                = new XmlFileEditor(
                        new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml"));

        String editedLine = xmlFileEditor.fileToEditedLine();

        System.out.println(editedLine);
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