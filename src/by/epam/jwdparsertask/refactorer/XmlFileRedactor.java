package by.epam.jwdparsertask.refactorer;

import java.io.*;

public class XmlFileRedactor implements Redactor {

    public void redactXmlFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        cleanTempFile();

        //TODO CHANGE ABSOLUTE PATH
        FileWriter fileWriter = new FileWriter(
                new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\temp.xml"),
                true
        );

        while (line != null) {
            fileWriter.write(tempFileLine(line));

            line = bufferedReader.readLine();
        }

        fileWriter.close();

        bufferedReader.close();
        fileReader.close();
    }

    private void cleanTempFile() throws IOException {
        FileWriter fileWriter = new FileWriter(
                new File("C:\\Users\\Пользователь\\IdeaProjects\\epam-jwd-task3\\temp.xml"),
                false
        );
        //TODO CHANGE ABSOLUTE PATH
        fileWriter.write("");
        fileWriter.close();
    }

    private String tempFileLine(String targetFileLine) {
        StringBuilder writeToTempFile = new StringBuilder(targetFileLine);

        if (targetFileLine.contains("<?")
                || ("".equals(targetFileLine))
                || ("\t".equals(targetFileLine))
                || ("\n".equals(targetFileLine))) {
            return "";
        } else if (targetFileLine.contains("<")) {
            writeToTempFile.insert(targetFileLine.indexOf('<'), "\n");
        }

        return writeToTempFile.toString();
    }
}
