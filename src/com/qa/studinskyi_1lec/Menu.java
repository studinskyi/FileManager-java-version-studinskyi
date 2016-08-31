package com.qa.studinskyi_1lec;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Menu {

    public Map<String, FileManager> menuItems = new TreeMap<>();

    public Menu() {
        menuItems.put("1", new ListFiles());
        menuItems.put("2", new CreateFile());
        menuItems.put("3", new DeleteFile());
        menuItems.put("4", new RenameFile());
        menuItems.put("5", new ShowFile());
    }
    private void printMenu() {
        System.out.println("File manager menu:");
        System.out.println("0 - exit");
        for (Map.Entry<String, FileManager> entry : menuItems.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        System.out.println("9 - print menu");
    }

    public void runMenu() throws IOException {
        printMenu();
        String answer = ""; // строка для выбранного варианта из меню
        while (true) {
            answer = readCommand();
            if (answer.equals("0")) {
                try {
                    System.out.println("Exit the program now? y\\n ");
                    answer = FileManager.reader.readLine();
                } catch (IOException e) {
                    answer = "";
                }
                if (answer.equals("y")) {
                    System.out.println("Exit from the program");
                    // вместо использования команды завершения программы System.exit(0), прерываем цикл опроса команд
                    break;
                } else continue;
            }
            if (answer.equals("9")) {
                printMenu();
                continue;
            }

            if (!menuItems.containsKey(answer)) {
                System.out.println("No such command. Try again");
                printMenu();
                continue;
            } else {
                menuItems.get(answer).execute();
            }

        }
    }

    private String readCommand() throws IOException {
        System.out.println("current directory: " + FileManager.folderFile);
        String command = null;
        try {
            command = FileManager.reader.readLine();
        } catch (IOException e) {
            command = "";
        }
        System.out.println("Selected command : " + command);
        // передаем номер строку с номером выбранной команды назад в метод runMenu()
        return command;
    }
}
