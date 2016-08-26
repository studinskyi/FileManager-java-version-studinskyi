package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager.setFolderFile("c:\\test_QA\\");

        Menu menu = new Menu();
        menu.runMenu();
        menu.getReader().close();

        System.out.println("Работа программы файлового менеджера завершена!");
    }
}
