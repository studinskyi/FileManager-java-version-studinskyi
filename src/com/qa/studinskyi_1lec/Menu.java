package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private BufferedReader reader;

    public BufferedReader getReader() {
        return reader;
    }

    public Menu() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private String readAnswer() throws IOException {

        String command = null;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            command = "";
            //e.printStackTrace();
        }

//        Scanner in = new Scanner(System.in);
//        // Считывает строку с номером команды из консоли
//        //и сохраняет ее в переменную
//        String command = null;
//        try {
//            command = in.nextLine();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        in.close();
        System.out.println("Selected answer : " + command);
        // передаем номер строку с номером выбранной команды назад в метод runMenu()
        return command;
    }

    public void runMenu() throws IOException {

        printMenu();
        String answer = ""; // строка для выбранного варианта из меню
        while (true) {
            answer = readAnswer();
            if (answer.equals("0")) {
                System.out.println("Exit from the program");
                break;
            }
            switch (answer) {
                case "1": {
                    System.out.println("start list files");
                    FileManager.listFiles();
                    break;
                }
                case "2": {
                    System.out.println("start create file");
                    FileManager.createFile("testFile");
                    break;
                }
                case "3": {
                    System.out.println("start delete file");
                    FileManager.deleteFile("testFile");
                    break;
                }
                case "4": {
                    System.out.println("start rename file");
                    FileManager.renameFile("testFile", "testFile2");
                    break;
                }
                case "9": {
                    System.out.println("print menu");
                    printMenu();
                    break;
                }
                default: {
                    System.out.println("No such command. Try again");
                    printMenu();
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("File manager menu:");
        System.out.println("0 - exit");
        System.out.println("1 - list files");
        System.out.println("2 - create file");
        System.out.println("3 - delet file");
        System.out.println("4 - rename file");
        System.out.println("9 - print menu");

    }
}
