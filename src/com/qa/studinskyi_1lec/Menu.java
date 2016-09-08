package com.qa.studinskyi_1lec;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.qa.studinskyi_1lec.FileManager.currentCommand;

public class Menu {
    public LinkedHashMap<String, FileManager> menuItems = new LinkedHashMap<>();
   // public Map<String, FileManager> menuItems = new TreeMap<>();

    public Menu() {
        menuItems.put("help", new Help());
        menuItems.put("ls", new ListFiles());
        menuItems.put("cd", new ChangeDirectory());
        menuItems.put("mkdir", new CreateDirectory());
        menuItems.put("touch", new CreateFile());
        menuItems.put("rm", new DeleteFile());
        menuItems.put("mv", new RenameFile());
        menuItems.put("cat", new ShowFile());
        menuItems.put("pwd", new CurrentDirectory());
        menuItems.put("grep", new Grep());
        menuItems.put("sed", new Sed());
        menuItems.put("history", new History());
    }

    public void printMenu() {
        System.out.println("File manager menu:");
        System.out.println("exit - exit from the program");
        for (Map.Entry<String, FileManager> entry : menuItems.entrySet())
            System.out.println(entry.getKey() + " \t- " + entry.getValue().getName());
    }

    public void runMenu() throws IOException {
        printMenu();
        while (true) {
            readCommand();
            if (FileManager.commandParameters.get(0).equals("exit")) {
                String answer = FileManager.requestLine("Exit the program now? y\\n");
                if (answer.equals("y")) {
                    System.out.println("Exit from the program");
                    break; // вместо использования команды завершения программы System.exit(0), прерываем цикл опроса команд
                } else continue; // проход на следующий запрос команды
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
        currentCommand = FileManager.requestLine("enter the command:");
        String[] massCommand = FileManager.parsingCommandLine(currentCommand);
        FileManager.updateCommandOption(massCommand);
        // обновление списка проанализированных параметров из введенной команды
        //        FileManager.commandParameters.clear();
        //        for (String tekStr : massCommand)
        //            FileManager.commandParameters.add(tekStr);

        // занесение текущей введенной команды в список,
        // для возможности последующего просмотра командой history
        Date d = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        FileManager.executedOperations.put(formatDate.format(d), currentCommand);
    }
}
