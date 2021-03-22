package by.epam.jwdparsertask;

import by.epam.jwdparsertask.editor.XmlFileEditor;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlFileEditor xmlFileEditor = new XmlFileEditor();
        xmlFileEditor.editFile(
                new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml"));
        xmlFileEditor.close();
    }
}

/*  ТРЕБОВАНИЯ    */

/*
* 1) ЧТЕНИЕ ФАЙЛА ПО ЧАСТЯМ
* 2) РАСПАРСИТЬ НА УЗЛЫ
* 3) СОБРАТЬ ДЕРЕВО
*
* SOLO RESPONSIBILITY
*
* ПЕРЕОПРЕДЕЛИТЬ ИКУАЛС И ХЭШКОД
*
* КОНСТРУКТОРЫ БЕЗ ПАРАМЕТРОВ
*
* РЕАЛИЗОВАТЬ ДАО КЛАСС ДЛЯ ВВОДА ВЫВОДА В XML-FILE ДЛЯ КЛАССОВ PARSER И REDACTOR
* */