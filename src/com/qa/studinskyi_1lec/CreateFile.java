package com.qa.studinskyi_1lec;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreateFile extends FileManager {
    @Override
    public String getName() {
        // "2 - create file"
        return "create file";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";
        String answer = "";
        String textToFile = "";
        while (true) {
            try {
                System.out.println("Create new file? y\\n ");
                answer = FileManager.reader.readLine();
            } catch (IOException e) {
                answer = "";
            }
            if (!answer.equals("y")) {
                System.out.println("file creation is canceled");
                break;
            }

            try {
                System.out.println("input name of new file ");
                nameFile = FileManager.reader.readLine();
            } catch (IOException e) {
                nameFile = "";
            }
            textToFile = "//        МИНИМУМ\n" +
                    "        //        Что из Java Core мы не рассмотрели выполняя задачу FileManager - то и рассмотрим на следующем занятии\n" +
                    "        //        изучить код FileManager и почитать в интрнете по всем не знакомым словам информацию. Все что не сможете переварить - пишите в личку заранее.\n" +
                    "        //                имплементировать deleteFile(), renameFile()\n" +
                    "        //        СРЕДНЯЯ СЛОЖНОСТЬ\n" +
                    "        //        сделать так что бы программа работала вечно и заканчивала свою работу только, если пользователь выберет 0. выход\n" +
                    "        //        сделать так что бы можно было прололжить создавать файл, пока пользоваль не пожелает закончить эту операцию и перейти к следующей. Например, выбрали 1, создали файл, потом программа спрашивает - продолжить создавать файл или нет?\n" +
                    "        //        ПОВЫШЕННАЯ СЛОЖНОСТЬ\n" +
                    "        //        имплементировать методы findWordOccurrenceInFile(), replaceWordInFile(), showLineNumbersWhereWordWasFound()";
            textToFile = fullPathToFile + "\n" + textToFile;

            if (!nameFile.equals("")) {
                fullPathToFile = folderFile + nameFile + ".txt";
                //File f = new File(fullPathToFile);
                if (!fileExist(fullPathToFile)) {
                    //if (!f.exists()) {
                    try {
                        OutputStream outStream = new FileOutputStream(fullPathToFile);
                        outStream.write(textToFile.getBytes());
                        outStream.close();
                        //f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
                        //// у программы не будет прав на работу с файлом или директорией, которые вы указали.
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
            System.out.println("создание файла " + fullPathToFile);
        }

    }
}
