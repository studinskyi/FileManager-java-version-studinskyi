package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("0 - выход");
        System.out.println("1 - просмотр фалйлов");
        System.out.println("2 - создать файл");
        System.out.println("3 - удалить файл");
        System.out.println("4 - переименовать файл");
        String command = reader.readLine();
        while (!command.equals("0")) {
            if (command.equals("1")) {
                System.out.println("просмотр списка файлов");
            } else if(command.equals("2"))  {
                System.out.println("создание файла");
            }
            else if(command.equals("3"))  {
                System.out.println("удаление файла");
            }
            command = reader.readLine();
        }
        System.out.println("Работа программы файлового менеджера завершена!");
    }
}
