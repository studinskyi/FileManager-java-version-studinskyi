package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ShowFile extends FileManager {
    @Override
    public String getName() {
        // "cat - show file"
        return "show file (cat \"name file\")";
    }

    @Override
    public void execute() {

        String fullPathToFile = "";
        String nameFile = "";

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 0) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }

        if (nameFile.equals("") && FileManager.interactivCommand)
            nameFile = FileManager.requestLine("input name of file");

        if (!nameFile.equals(""))
            fullPathToFile = folderFile + nameFile; // + File.separator
            //fullPathToFile = folderFile + nameFile + ".txt"; // + File.separator

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return;
        }

        System.out.println("opening file: " + fullPathToFile);

        String textFromFile = "";
        try {
            textFromFile = FileManager.readFile(fullPathToFile);
            System.out.println(textFromFile);
        } catch (IOException e) {
            System.out.println("error reading the file contents " + fullPathToFile);
        }
    }
}
