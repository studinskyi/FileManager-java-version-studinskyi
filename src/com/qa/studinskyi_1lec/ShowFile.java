package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ShowFile extends FileManager {
    @Override
    public String getName() {
        // "cat - show file"
        return "show file (cat \"name file\")";
    }

    @Override
    public void execute() {

        String fullPathToFile = "";
        String nameFile = "";

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 1) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }

        if (nameFile.equals(""))
            nameFile = FileManager.requestLine("input name of file");

        if (!nameFile.equals(""))
            fullPathToFile = folderFile + nameFile + ".txt";

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return;
        }

        System.out.println("opening file: " + fullPathToFile);

        String textFromFile = "";
        try {
            textFromFile = FileManager.readFile(fullPathToFile);
            System.out.println(textFromFile);
        } catch (IOException e) {
            System.out.println("error reading the file contents " + fullPathToFile);
        }

        //        try (BufferedReader reader = new BufferedReader(
        //                new InputStreamReader(
        //                        new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
        //            String line;
        //            while ((line = reader.readLine()) != null) {
        //                System.out.println(line);
        //            }
        //        } catch (IOException e) {
        //            FileManager.requestLine("error opening file " + fullPathToFile);
        //        }

        //===================== 2 вариант
        //        List<String> list = new ArrayList<String>();
        //        String line = "";
        //        Scanner in = new Scanner(new File(fullPathToFile));
        //        while (in.hasNextLine()) {
        //            line = in.nextLine();
        //            list.add(line);
        //            System.out.println(line);
        //        }
        //        //String[] array = list.toArray(new String[0]);
        //============== 3 вариант
        //        BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
        //        String line;
        //        List<String> lines = new ArrayList<String>();
        //        while ((line = reader.readLine()) != null) {
        //            lines.add(line);
        //            System.out.println(line);
        //        }
        //        //        String [] linesAsArray = lines.toArray(new String[lines.size()]);


    }
}
