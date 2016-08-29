package com.qa.studinskyi_1lec;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    public static HashMap<String, String> executedOperations;

    public static void listFiles() {
        System.out.println("просмотр списка файлов");
        File dir = new File(folderFile);
        if (dir.isDirectory()) {
            // если объект представляет каталог
            for (File item : dir.listFiles()) {
                // получаем все вложенные объекты в каталоге
                if (item.isDirectory())
                    System.out.println(item.getName() + "\tкаталог");
                else
                    System.out.println(item.getName() + "\tфайл");
            }
        }
    }

    public static void createFile() throws IOException {

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

    public static void deleteFile() {
        //        File dir = new File(folderFile);
        //        File fileForDelet = null;
        //        if (dir.isDirectory()) {
        //            // если объект представляет каталог
        //            for (File item : dir.listFiles()) {
        //                // получаем все вложенные объекты в каталоге
        //                if (!item.isDirectory()) {
        //                    fileForDelet = item;
        //                    break;
        //                }
        //            }
        //        }
        String nameFile = "";
        try {
            System.out.println("enter the name of the file to delete:");
            nameFile = FileManager.reader.readLine();
        } catch (IOException e) {
            nameFile = "";
            //e.printStackTrace();
        }

        String fullPathToFile = "";
        if (!nameFile.equals("")) {
            fullPathToFile = folderFile + nameFile + ".txt";
            File f = new File(fullPathToFile);
            if (f.exists()) {
                System.out.println("file is deleted: " + fullPathToFile);
                // начало блока обработки возможной ислючительной ситуации
                f.delete();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
            }
        }

    }

    public static void renameFile() {
        String nameFile1 = "";
        try {
            System.out.println("enter the name of the file to rename:");
            nameFile1 = FileManager.reader.readLine();
        } catch (IOException e) {
            nameFile1 = "";
        }
        String fullPathToFile1 = "";
        if (!nameFile1.equals("")) {
            fullPathToFile1 = folderFile + nameFile1 + ".txt";
            File f = new File(fullPathToFile1);
            if (f.exists()) {
                String nameFile2 = "";
                try {
                    System.out.println("enter the new name of the file:");
                    nameFile2 = FileManager.reader.readLine();
                } catch (IOException e) {
                    nameFile2 = "";
                }
                String fullPathToFile2 = "";
                if (!nameFile2.equals("")) {
                    fullPathToFile2 = folderFile + nameFile2 + ".txt";
                    File fileWithNewName = new File(fullPathToFile2);
                    if (!fileWithNewName.exists()) {
                        if (f.renameTo(fileWithNewName))
                            System.out.println("rename file - " + fullPathToFile1 + " на " + fullPathToFile2);

                    } else {
                        System.out.println("file is already exists: " + fullPathToFile2);
                    }
                }
            } else {
                System.out.println("file does not exist: " + fullPathToFile1);
            }
        }


        //       File dir = new File(folderFile);
        //        File fileForRename = null;
        //        if (dir.isDirectory()) {
        //            // если объект представляет каталог
        //            for (File item : dir.listFiles()) {
        //                // получаем все вложенные объекты в каталоге
        //                if (!item.isDirectory()) {
        //                    fileForRename = item;
        //                    break;
        //                }
        //            }
        //        }
        //        if (fileForRename.exists()) {
        //            Date d = new Date();
        //            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
        //            String fullPathToNewName = folderFile + nameFile2 + "_" + formatDate.format(d) + ".txt";
        //            File fileWithNewName = new File(fullPathToNewName);
        //            if (fileForRename.renameTo(fileWithNewName))
        //                System.out.println("переименование первого в списке файла - " + fileForRename + " на " + fullPathToNewName);
        //        }
    }


//     private boolean fileExist(String fullPathToFile) {
//        // 'Path' used to locate a file in a file system. It will
//        // typically represent a system dependent file path.
//        Path path = Paths.get(fullPathToFile);
//
//        //  'Files' class consists exclusively of static methods that operate on files,
//        // directories, or other types of files.
//        if (Files.exists(path)) {
//            return true;
//        }
//        return true;
//
//    }

}
