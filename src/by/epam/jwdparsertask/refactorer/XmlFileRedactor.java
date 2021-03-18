package by.epam.jwdparsertask.refactorer;

import java.io.*;

public class XmlFileRedactor implements Redactor {

    public static void redactXmlFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        //TODO CHANGE ABSOLUTE PATH
        FileWriter fileWriter = new FileWriter(
                new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\temp.xml"),
                true
        );

        while (line != null) {
            fileWriter.write(line);

            line = bufferedReader.readLine();
        }

        fileWriter.close();

        bufferedReader.close();
        fileReader.close();
    }
}
