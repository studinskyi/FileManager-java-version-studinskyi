package com.qa.studinskyi_1lec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreateFile extends FileManager {
    @Override
    public String getName() {
        // "touch - create file"
        return "create file (touch \"name file\" \"text of file\")";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";
        String textToFile = "";
        String fileContent = "";
        String lineSeparator = System.getProperty("line.separator");

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 0) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }

        // проверка наличия введенного текста для записи в файл
        if (FileManager.commandParameters.size() > 1) {
            try {
                for (int i = 2; i < FileManager.commandParameters.size(); i++)
                    textToFile += FileManager.commandParameters.get(i) + " ";
            } catch (Exception e) {
                textToFile = "";
            }
        }
        if (textToFile.equals(""))
            textToFile = "ТЕКСТ ФАЙЛА ПО-УМОЛЧАНИЮ" + lineSeparator +
                    " //        МИНИМУМ" + lineSeparator +
                    " //        Что из Java Core мы не рассмотрели выполняя задачу FileManager - то и рассмотрим на следующем занятии" + lineSeparator +
                    " //        изучить код FileManager и почитать в интрнете по всем не знакомым словам информацию. Все что не сможете переварить - пишите в личку заранее." + lineSeparator +
                    " //                имплементировать deleteFile(), renameFile()" + lineSeparator +
                    " //        СРЕДНЯЯ СЛОЖНОСТЬ" + lineSeparator +
                    " //        сделать так что бы программа работала вечно и заканчивала свою работу только, если пользователь выберет 0. выход" + lineSeparator +
                    " //        сделать так что бы можно было прололжить создавать файл, пока пользоваль не пожелает закончить эту операцию и перейти к следующей. Например, выбрали 1, создали файл, потом программа спрашивает - продолжить создавать файл или нет?" + lineSeparator +
                    " //        ПОВЫШЕННАЯ СЛОЖНОСТЬ" + lineSeparator +
                    " //        имплементировать методы findWordOccurrenceInFile(), replaceWordInFile(), showLineNumbersWhereWordWasFound()" + lineSeparator;

        while (true) {
            if (nameFile.equals("")) {
                String answer = FileManager.requestLine("Create new file? y\\n");
                if (!answer.equals("y")) {
                    System.out.println("file creation is canceled");
                    break;
                }
                nameFile = FileManager.requestLine("input name of new file ");
            }

            if (!nameFile.equals("")) {
                fullPathToFile = folderFile + nameFile + ".txt"; // + File.separator
                fileContent = fullPathToFile + lineSeparator + textToFile;
                //File f = new File(fullPathToFile);
                if (!fileExist(fullPathToFile)) {
                    //if (!f.exists()) {
                    try {
                        OutputStream outStream = new FileOutputStream(fullPathToFile);
                        outStream.write(fileContent.getBytes());
                        outStream.close();
                        System.out.println("file was created: " + fullPathToFile);
                        //f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
                    } catch (IOException e) {
                        System.out.println("did not created file: " + fullPathToFile);
                    }
                } else {
                    System.out.println("file is already exists: " + fullPathToFile);
                }
            }
            //        Date d = new Date();
            //        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
            //        String fullPathToFile = folderFile + nameFile + "_" + formatDate.format(d) + ".txt";
            //        File f = new File(fullPathToFile);
            //        // начало блока обработки возможной ислючительной ситуации
            //        try {
            //            f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
            //            // у программы не будет прав на работу с файлом или директорией, которые вы указали.
            //        } catch (IOException e) {
            //            e.printStackTrace(); // код, который выполниться, если возникнет исклбчительная ситуация
            //        }
            nameFile = "";
        }

    }
}
