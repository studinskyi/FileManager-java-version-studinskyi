package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public abstract class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    public static String currentCommand;
    public static ArrayList<String> commandParameters = new ArrayList<>();
    public static LinkedHashMap<String, String> executedOperations = new LinkedHashMap<>();
    public static Menu menu = new Menu();

    public FileManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract String getName();

    public abstract void execute();

    public static String requestLine(String textMessage) {
        String answer = "";
        try {
            System.out.println(textMessage);
            answer = reader.readLine();
        } catch (IOException e) {
            answer = "";
        }
        return answer;
    }

    public static void readCommand() throws IOException {
        // преобразование строки в массив подстрок, используя в качестве разделителя пробел " "
        currentCommand = FileManager.requestLine("enter the command:");
        String[] massCommand = parsingCommanLine(currentCommand);
        // обновление списка проанализированных параметров из введенной команды
        FileManager.commandParameters.clear();
        for (String tekStr : massCommand)
            FileManager.commandParameters.add(tekStr);

        // занесение текущей введенной команды в список,
        // для возможности последующего просмотра командой history
        Date d = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        executedOperations.put(formatDate.format(d),currentCommand);
    }

    private static String[] parsingCommanLine(String strCommand) {
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

    public static String readFile(String fullPathToFile) throws IOException {

        String textOfFile = "";
        String line;

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return "";
        }

        try (BufferedReader readerFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
            while ((line = readerFile.readLine()) != null)
                //System.out.println(line);
                textOfFile += line + "\n";

        } catch (IOException e) {
            FileManager.requestLine("error opening file " + fullPathToFile);
        }

        return textOfFile;
        //        File file = new File(fullPathToFile);
        //        StringBuilder fileContents = new StringBuilder((int) file.length());
        //        Scanner scanner = new Scanner(file);
        //        String lineSeparator = System.getProperty("line.separator");
        //
        //        try {
        //            while (scanner.hasNextLine()) {
        //                fileContents.append(scanner.nextLine() + lineSeparator);
        //            }
        //            return fileContents.toString();
        //        } finally {
        //            scanner.close();
        //        }
    }

    public boolean fileExist(String fullPathToFile) {
        // 'Path' used to locate a file in a file system. It will
        // typically represent a system dependent file path.
        Path path = Paths.get(fullPathToFile);

        //  'Files' class consists exclusively of static methods that operate on files,
        // directories, or other types of files.
        if (Files.exists(path)) {
            return true;
        }
        return false;

    }

}
