package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager.setFolderFile("e:\\Java_projects\\QA_Hillel_DEV\\test_folder\\");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Menu menu = new Menu();
        menu.reader = reader;
        menu.runMenu();

        reader.close();
        System.out.println("Работа программы файлового менеджера завершена!");
    }
}
