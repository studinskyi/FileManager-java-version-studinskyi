package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    public static ArrayList<String> commandParameters = new ArrayList<>();
    //public static HashMap<String, String> executedOperations;

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

    public static String readFile(String fullPathToFile) throws IOException {

        String textOfFile = "";
        String line;

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return "";
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null)
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
