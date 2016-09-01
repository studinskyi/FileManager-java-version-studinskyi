package com.qa.studinskyi_1lec;

import java.io.File;

public class Grep extends FileManager {
    @Override
    public String getName() {
        // "grep - find word occurrence in file"
        return "find word occurrence in file (grep \"name file\" \"substring search\")";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";
        String textToFile = "";
        String word = "";
        int count = 0;

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 0) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }
        if (nameFile.equals(""))
            nameFile = FileManager.requestLine("input name of file ");

        // проверка наличия введенного слова для поиска
        if (FileManager.commandParameters.size() > 1) {
            try {
                word = FileManager.commandParameters.get(2);
            } catch (Exception e) {
                word = "";
            }
        }
        if (word.equals(""))
            word = FileManager.requestLine("input word to find");

        if (!nameFile.equals("")) {
            fullPathToFile = folderFile + File.separator + nameFile + ".txt";
            count = findWordOccurrenceInFile(fullPathToFile, word);
        } else
            System.out.println("file does not exist: " + fullPathToFile);

        System.out.println("occurrences found words: " + count);
    }
}
