package com.qa.studinskyi_1lec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep extends FileManager{
    @Override
    public String getName() {
        //
        return "find word occurrence in file ";
    }

    @Override
    public void execute() {

        String fullPathToFile = "";
        String nameFile = "";
        String textToFile = "";
        String word = "";
        int count = 0;

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 1) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }

        if (nameFile.equals(""))
           nameFile = FileManager.requestLine("input name of file ");

        // проверка наличия введенного слова для поиска
        if (FileManager.commandParameters.size() > 2) {
            try {
                word = FileManager.commandParameters.get(2);
            } catch (Exception e) {
                word = "";
            }
        }

        if (word.equals(""))
            word = FileManager.requestLine("input word to find");

        if (!nameFile.equals("")) {
            fullPathToFile = folderFile + nameFile + ".txt";
            if (fileExist(fullPathToFile)) {
                //if (f.exists()) {
                Pattern pattern = Pattern.compile(word);
                String fileContent = "";
                try {
                    fileContent = readFile(fullPathToFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Matcher matcher = pattern.matcher(fileContent);
                int pos = 0;

                while (matcher.find(pos)) {
                    count++;
                    pos = matcher.start() + 1;
                }


            } else
                System.out.println("file does not exist: " + fullPathToFile);
        }

        System.out.println("occurrences found words: " + count);
    }
}
