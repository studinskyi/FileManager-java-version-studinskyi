package com.qa.studinskyi_1lec;


import java.util.HashMap;

public class FileManager {
    private static String folderFile;
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
    }

    public static void createFile(String nameFile) {
        System.out.println("создание файла " + nameFile);
    }

    public static void deleteFile(String nameFile) {
        System.out.println("удаление файла " + nameFile);
    }

    public static void renameFile(String nameFile1, String nameFile2) {
        System.out.println("переименование файла " + nameFile1 + " в " + nameFile2);
    }


}
