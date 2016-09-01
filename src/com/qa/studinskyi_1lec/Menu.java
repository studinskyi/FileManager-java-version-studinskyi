package com.qa.studinskyi_1lec;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Menu {

    public LinkedHashMap<String, FileManager> menuItems = new LinkedHashMap<>();
   // public Map<String, FileManager> menuItems = new TreeMap<>();

    public Menu() {
        menuItems.put("ls", new ListFiles());
        menuItems.put("touch", new CreateFile());
        menuItems.put("rm", new DeleteFile());
        menuItems.put("mv", new RenameFile());
        menuItems.put("cat", new ShowFile());
        menuItems.put("pwd", new CurrentDirectory());
        menuItems.put("grep", new Grep());
        menuItems.put("sed", new Sed());
        menuItems.put("history", new History());
        menuItems.put("help", new Help());
    }

    public void printMenu() {
        System.out.println("File manager menu:");
        System.out.println("exit - exit from the program");
        for (Map.Entry<String, FileManager> entry : menuItems.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        //System.out.println("help - print menu");
    }

    public void runMenu() throws IOException {
        printMenu();
        while (true) {
            FileManager.readCommand();
            if (FileManager.commandParameters.get(0).equals("exit")) {
                String answer = FileManager.requestLine("Exit the program now? y\\n");
                if (answer.equals("y")) {
                    System.out.println("Exit from the program");
                    break; // вместо использования команды завершения программы System.exit(0), прерываем цикл опроса команд
                } else continue; // проход на следующий запрос команды
            }
            //            if (FileManager.commandParameters.get(0).equals("help")) {
            //                printMenu();
            //                continue;
            //            }

            if (!menuItems.containsKey(FileManager.commandParameters.get(0))) {
                System.out.println("No such command. Try again");
                printMenu();
                continue;
            } else {
                menuItems.get(FileManager.commandParameters.get(0)).execute();
            }
        }
    }
}
