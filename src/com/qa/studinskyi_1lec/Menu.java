package com.qa.studinskyi_1lec;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Menu {

    public Map<String, FileManager> menuItems = new TreeMap<>();

    public Menu() {
        menuItems.put("ls", new ListFiles());
        menuItems.put("touch", new CreateFile());
        menuItems.put("rm", new DeleteFile());
        menuItems.put("mv", new RenameFile());
        menuItems.put("cat", new ShowFile());
        menuItems.put("pwd", new CurrentDirectory());
        menuItems.put("grep", new Grep());
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
        while (true) {
            readCommand();
            if (FileManager.commandParameters.get(0).equals("0")) {
                String answer = FileManager.requestLine("Exit the program now? y\\n");
                if (answer.equals("y")) {
                    System.out.println("Exit from the program");
                    break; // вместо использования команды завершения программы System.exit(0), прерываем цикл опроса команд
                } else continue; // проход на следующий запрос команды
            }
            if (FileManager.commandParameters.get(0).equals("9")) {
                printMenu();
                continue;
            }

            if (!menuItems.containsKey(FileManager.commandParameters.get(0))) {
                System.out.println("No such command. Try again");
                printMenu();
                continue;
            } else {
                menuItems.get(FileManager.commandParameters.get(0)).execute();
            }
        }
    }

    private void readCommand() throws IOException {

        // преобразование строки в массив подстрок, используя в качестве разделителя пробел " "
        String[] massCommand = parsingCommanLine(FileManager.requestLine("enter the command:"));
        //        System.out.println("длина массива " + massCommand.length);
        FileManager.commandParameters.clear();
        for (String tekStr : massCommand)
            FileManager.commandParameters.add(tekStr);
        //            System.out.println(tekStr);

        //System.out.println("Selected command : " + massCommand[0]);
        // передаем номер строку с номером выбранной команды назад в метод runMenu()
        //return massCommand;
    }

    private String[] parsingCommanLine(String strCommand) {
        String oneSpace  = " ";
        String twoSpaces = "  ";
        // свертка пробелов в строке команды, введенной с клавиатуры
        while (strCommand.indexOf(twoSpaces) >= 0) {
            String replace = strCommand.replace(twoSpaces, oneSpace);
            strCommand = replace;
        }
        //        while(strCommand.contains("  ")) {
        //            String replace = strCommand.replace("  ", " ");
        //            strCommand = replace;
        //        }

        // преобразование строки в массив подстрок, используя в качестве разделителя пробел " "
        String[] massStr = strCommand.split(" ");
        return massStr;
    }
}
