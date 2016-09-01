package com.qa.studinskyi_1lec;

import java.io.File;

public class Sed extends FileManager {
    @Override
    public String getName() {
        // "sed - replace word in file"
        return "replace word in file (sed \"name file\" \"substring search\" \"substring replace\")";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";
        String textToFile = "";
        String wordSource = "";
        String wordTarget = "";

        //        sed 's/foo/bar/g'
        //        (замена ВСЕХ совпадений в строке)

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
                wordSource = FileManager.commandParameters.get(2);
            } catch (Exception e) {
                wordSource = "";
            }
        }
        if (wordSource.equals(""))
            wordSource = FileManager.requestLine("input word to find");

        // проверка наличия введенного слова для замены
        if (FileManager.commandParameters.size() > 2) {
            try {
                wordTarget = FileManager.commandParameters.get(3);
            } catch (Exception e) {
                wordTarget = "";
            }
        }
        if (wordTarget.equals(""))
            wordTarget = FileManager.requestLine("input word to replace");

        if (!nameFile.equals("")) {
            fullPathToFile = folderFile + File.separator + nameFile + ".txt";
            count = findWordOccurrenceInFile(fullPathToFile, wordSource);
        } else
            System.out.println("file does not exist: " + fullPathToFile);

        replaceWordInFile(fullPathToFile,wordSource,wordTarget);

        System.out.println("строка поиска: " + wordSource);
        System.out.println("строка замены: " + wordTarget);
        System.out.println("occurrences found words: " + count);



    }


}
