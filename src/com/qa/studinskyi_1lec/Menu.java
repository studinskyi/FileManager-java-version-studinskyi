package com.qa.studinskyi_1lec;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    public Map<String, FileManager> menuItems = new HashMap<String, FileManager>();

    public Menu() {
        menuItems.put("1", new ListFiles());
        menuItems.put("2", new CreateFile());
//        menuItems.put(2, new FindCommand());
//        menuItems.put(3, new AddCommand());
//        menuItems.put(4, new DeleteCommand());
    }

    private String readAnswer() throws IOException {

        String command = null;
        try {
            command = FileManager.reader.readLine();
            //command = FileManager.getReader().readLine();
        } catch (IOException e) {
            command = "";
            //e.printStackTrace();
        }

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

            if (!menuItems.containsKey(answer)) {
                System.out.println("No such command. Try again");
                continue;
            } else {
                menuItems.get(answer).execute();
            }

//            switch (answer) {
//                case "1": {
//                    System.out.println("start list files");
//                    FileManager.listFiles();
//                    break;
//                }
////                case "2": {
////                    System.out.println("start create file");
////                    FileManager.createFile();
////                    break;
////                }
////                case "3": {
////                    System.out.println("start delete file");
////                    FileManager.deleteFile();
////                    break;
////                }
////                case "4": {
////                    System.out.println("start rename file");
////                    FileManager.renameFile();
////                    break;
////                }
////                case "5": {
////                    System.out.println("show file");
////                    FileManager.showFile();
////                    break;
////                }
////                case "9": {
////                    System.out.println("print menu");
////                    printMenu();
////                    break;
////                }
//                default: {
//                    System.out.println("No such command. Try again");
//                    printMenu();
//                }
//            }
        }
    }

    private void printMenu() {
        System.out.println("File manager menu:");
        System.out.println("0 - exit");
        for (Map.Entry<String, FileManager> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
        //System.out.println("1 - list files");
//        System.out.println("2 - create file");
//        System.out.println("3 - delet file");
//        System.out.println("4 - rename file");
//        System.out.println("5 - show file");
//        System.out.println("9 - print menu");

    }
}
