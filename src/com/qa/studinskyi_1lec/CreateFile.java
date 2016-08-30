package com.qa.studinskyi_1lec;


import java.io.File;
import java.io.IOException;

public class CreateFile extends FileManager {
    @Override
    public String getName() {
        return "2 - create file";
    }

    @Override
    public void execute() {
        while (true) {
            String answer = "";
            try {
                System.out.println("create new file y\\n ");
                answer = FileManager.reader.readLine();
            } catch (IOException e) {
                answer = "";
            }

            if (!answer.equals("y")) {
                System.out.println("file creation canceled");
                break;
            }

            String nameFile = "";
            try {
                System.out.println("input name of new file ");
                nameFile = FileManager.reader.readLine();
            } catch (IOException e) {
                nameFile = "";
                //e.printStackTrace();
            }

            String fullPathToFile = "";

            if (!nameFile.equals("")) {
                fullPathToFile = folderFile + nameFile + ".txt";
                File f = new File(fullPathToFile);
                if (!f.exists()) {
                    // начало блока обработки возможной ислючительной ситуации
                    try {
                        f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
                        // у программы не будет прав на работу с файлом или директорией, которые вы указали.
                    } catch (IOException e) {
                        System.out.println("did not created file: " + fullPathToFile);
                        //e.printStackTrace(); // код, который выполниться, если возникнет исклбчительная ситуация
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

//
//    public static void createFile() throws IOException {
//
//        while (true) {
//            String answer = "";
//            try {
//                System.out.println("create new file y\\n ");
//                answer = FileManager.reader.readLine();
//            } catch (IOException e) {
//                answer = "";
//            }
//
//            if (!answer.equals("y")) {
//                System.out.println("file creation canceled");
//                break;
//            }
//
//            String nameFile = "";
//            try {
//                System.out.println("input name of new file ");
//                nameFile = FileManager.reader.readLine();
//            } catch (IOException e) {
//                nameFile = "";
//                //e.printStackTrace();
//            }
//
//            String fullPathToFile = "";
//
//            if (!nameFile.equals("")) {
//                fullPathToFile = folderFile + nameFile + ".txt";
//                File f = new File(fullPathToFile);
//                if (!f.exists()) {
//                    // начало блока обработки возможной ислючительной ситуации
//                    try {
//                        f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
//                        // у программы не будет прав на работу с файлом или директорией, которые вы указали.
//                    } catch (IOException e) {
//                        System.out.println("did not created file: " + fullPathToFile);
//                        //e.printStackTrace(); // код, который выполниться, если возникнет исклбчительная ситуация
//                    }
//                } else {
//                    System.out.println("file is already exists: " + fullPathToFile);
//                }
//            }
//
//            //        Date d = new Date();
//            //        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
//            //        String fullPathToFile = folderFile + nameFile + "_" + formatDate.format(d) + ".txt";
//            //        File f = new File(fullPathToFile);
//            //        // начало блока обработки возможной ислючительной ситуации
//            //        try {
//            //            f.createNewFile();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
//            //            // у программы не будет прав на работу с файлом или директорией, которые вы указали.
//            //        } catch (IOException e) {
//            //            e.printStackTrace(); // код, который выполниться, если возникнет исклбчительная ситуация
//            //        }
//            System.out.println("создание файла " + fullPathToFile);
//        }
//    }
//