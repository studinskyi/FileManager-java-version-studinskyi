package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ShowFile extends FileManager {
    @Override
    public String getName() {
        // "5 - show file"
        return "show file";
    }

    @Override
    public void execute() {

        String nameFile = "";
        try {
            System.out.println("input name of file ");
            nameFile = FileManager.reader.readLine();
        } catch (IOException e) {
            nameFile = "";
        }
        String fullPathToFile = "";
        if (!nameFile.equals(""))
            fullPathToFile = folderFile + nameFile + ".txt";

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return;
        }

        //=============== 3 вариант
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
        }
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
        //============== 1 вараинт

        //        BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
        //        String line;
        //        List<String> lines = new ArrayList<String>();
        //        while ((line = reader.readLine()) != null) {
        //            lines.add(line);
        //            System.out.println(line);
        //        }
        //        //        //если нужен массив то список можно запросто преобрпзовать
        //        //        String [] linesAsArray = lines.toArray(new String[lines.size()]);
        //        ///======================

        //        StringBuilder fileContents = new StringBuilder((int) file.length());
        //        Scanner scanner = new Scanner(file);
        //        String lineSeparator = System.getProperty("line.separator");
        //        String currenLine = "";
        //        try {
        //            while (scanner.hasNextLine()) {
        //                currenLine = scanner.nextLine();
        //                fileContents.append(currenLine + lineSeparator);
        //                System.out.println(currenLine.toString());
        //            }
        //            //return fileContents.toString();
        //        } finally {
        //            scanner.close();
        //        }
        return;

    }
}


//    public static void showFile() throws IOException {
//        String nameFile = "";
//        try {
//            System.out.println("input name of file ");
//            nameFile = FileManager.reader.readLine();
//        } catch (IOException e) {
//            nameFile = "";
//        }
//        String fullPathToFile = "";
//        if (!nameFile.equals(""))
//            fullPathToFile = folderFile + nameFile + ".txt";
//
//        File file = new File(fullPathToFile);
//        if (!file.exists()) {
//            System.out.println("file does not exist: " + fullPathToFile);
//            return;
//        }
//
//        //=============== 3 вариант
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(
//                        new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            // log error
//        }
//        //===================== 2 вариант
//        //        List<String> list = new ArrayList<String>();
//        //        String line = "";
//        //        Scanner in = new Scanner(new File(fullPathToFile));
//        //        while (in.hasNextLine()) {
//        //            line = in.nextLine();
//        //            list.add(line);
//        //            System.out.println(line);
//        //        }
//        //        //String[] array = list.toArray(new String[0]);
//        //============== 1 вараинт
//
//        //        BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
//        //        String line;
//        //        List<String> lines = new ArrayList<String>();
//        //        while ((line = reader.readLine()) != null) {
//        //            lines.add(line);
//        //            System.out.println(line);
//        //        }
//        //        //        //если нужен массив то список можно запросто преобрпзовать
//        //        //        String [] linesAsArray = lines.toArray(new String[lines.size()]);
//        //        ///======================
//
//        //        StringBuilder fileContents = new StringBuilder((int) file.length());
//        //        Scanner scanner = new Scanner(file);
//        //        String lineSeparator = System.getProperty("line.separator");
//        //        String currenLine = "";
//        //        try {
//        //            while (scanner.hasNextLine()) {
//        //                currenLine = scanner.nextLine();
//        //                fileContents.append(currenLine + lineSeparator);
//        //                System.out.println(currenLine.toString());
//        //            }
//        //            //return fileContents.toString();
//        //        } finally {
//        //            scanner.close();
//        //        }
//        return;
//    }
//