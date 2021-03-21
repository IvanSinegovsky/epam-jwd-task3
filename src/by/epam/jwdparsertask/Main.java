package by.epam.jwdparsertask;

import by.epam.jwdparsertask.model.Node;
import by.epam.jwdparsertask.parser.Parser;
import by.epam.jwdparsertask.parser.XmlParser;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser xmlParser = new XmlParser();
        String path  = "C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\notes.xml";

        Node node = xmlParser.parse(new File(path));
    }
}

/*  ТРЕБОВАНИЯ    */

/*
* УБРАТЬ ХАРДКОДЫ ПУТЕЙ К ФАЙЛАМ
*
* 1) ЧТЕНИЕ ФАЙЛА ПО ЧАСТЯМ
* 2) РАСПАРСИТЬ НА УЗЛЫ
* 3) СОБРАТЬ ДЕРЕВО
*
* SOLO RESPONSIBILITY
* ВОЗМОЖНО ПЕРЕЧИСЛЕНИЕ ТИПОВ ТЕГА И КЛАСС ТЕГ ИМЕЮЩИЙ ТАКОЕ ПОЛЕ
*
* ДОБАВИТЬ ПОЛЯ РИДЕРОВ
* КЛАСС ПАРСЕРА ИМПЛЕМЕНТИРУЕТ КЛОУЗБЛ
* РЕАЛИЗУЕТСЯ МЕТОД КЛОУЗ С ЗАКРЫТИЕМ ПОТОКОВ ЧТЕНИЯ ФАЙЛА
*
* УБРАТЬ ДОБАВЛЕНИЕ ПУСТОЙ СТРОКИ ИЗ ТЕМП-ФАЙЛА
*
* УДАЛИТЬ МУСОР ИЗ РЕПОЗИТОРИЯ
*
* НОД ИМПЛЕМЕНТС СЕРИАЛАЙЗБЛ
*
* ПЕРЕОПРЕДЕЛИТЬ ИКУАЛС И ХЭШКОД
*
* КОНСТРУКТОРЫ БЕЗ ПАРАМЕТРОВ
* */