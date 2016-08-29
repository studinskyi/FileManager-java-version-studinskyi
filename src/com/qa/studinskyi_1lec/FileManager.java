package com.qa.studinskyi_1lec;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FileManager {
    private static String folderFile;
    private static BufferedReader reader;

    public static void setReader(BufferedReader reader) {
        FileManager.reader = reader;
    }

    public static BufferedReader getReader() {
        return reader;
    }

    private static HashMap<String, String> executedOperations;

    public static String getFolderFile() {
        return FileManager.folderFile;
    }

    public static void setFolderFile(String folderFile) {
        FileManager.folderFile = folderFile;
    }

    public FileManager() {
    }

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

        String nameFile = "";
        try {
            System.out.println("input name of new file ");
            nameFile = FileManager.getReader().readLine();
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

    public static void deleteFile(String nameFile) {
        File dir = new File(folderFile);
        File fileForDelet = null;
        if (dir.isDirectory()) {
            // если объект представляет каталог
            for (File item : dir.listFiles()) {
                // получаем все вложенные объекты в каталоге
                if (!item.isDirectory()) {
                    fileForDelet = item;
                    break;
                }
            }
        }
        if (fileForDelet.exists()) {
            System.out.println("удаление первого в списке файла - " + fileForDelet);
            try {
                fileForDelet.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void renameFile(String nameFile1, String nameFile2) {
        File dir = new File(folderFile);
        File fileForRename = null;
        if (dir.isDirectory()) {
            // если объект представляет каталог
            for (File item : dir.listFiles()) {
                // получаем все вложенные объекты в каталоге
                if (!item.isDirectory()) {
                    fileForRename = item;
                    break;
                }
            }
        }
        if (fileForRename.exists()) {
            Date d = new Date();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
            String fullPathToNewName = folderFile + nameFile2 + "_" + formatDate.format(d) + ".txt";
            File fileWithNewName = new File(fullPathToNewName);
            if (fileForRename.renameTo(fileWithNewName))
                System.out.println("переименование первого в списке файла - " + fileForRename + " на " + fullPathToNewName);
        }
    }


}
