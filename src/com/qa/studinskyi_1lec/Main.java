package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("File manager menu:");
        System.out.println("1 - просмотр файлов");
        System.out.println("2 - создать файл");
        System.out.println("3 - удалить файл");
        System.out.println("4 - переименовать файл");
        System.out.println("0 - выход");

        FileManager.setFolderFile("e:\\Java_projects\\QA_Hillel_DEV\\test_folder\\");

        String command = null;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!command.equals("0")) {
            if (command.equals("1")) {
                FileManager.listFiles();
            } else if (command.equals("2")) {
                FileManager.createFile("file1122");
            } else if (command.equals("3")) {
                FileManager.deleteFile("file1122");
            } else if (command.equals("4")) {
                FileManager.renameFile("file1122", "file334445555");
            }
            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Работа программы файлового менеджера завершена!");
    }
}
