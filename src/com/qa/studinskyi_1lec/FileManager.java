package com.qa.studinskyi_1lec;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


public abstract class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    //public static HashMap<String, String> executedOperations;

    public FileManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract String getName();
    public abstract void execute();




//
//    public static void renameFile() {
//        String nameFile1 = "";
//        try {
//            System.out.println("enter the name of the file to rename:");
//            nameFile1 = FileManager.reader.readLine();
//        } catch (IOException e) {
//            nameFile1 = "";
//        }
//        String fullPathToFile1 = "";
//        if (!nameFile1.equals("")) {
//            fullPathToFile1 = folderFile + nameFile1 + ".txt";
//            File f = new File(fullPathToFile1);
//            if (f.exists()) {
//                String nameFile2 = "";
//                try {
//                    System.out.println("enter the new name of the file:");
//                    nameFile2 = FileManager.reader.readLine();
//                } catch (IOException e) {
//                    nameFile2 = "";
//                }
//                String fullPathToFile2 = "";
//                if (!nameFile2.equals("")) {
//                    fullPathToFile2 = folderFile + nameFile2 + ".txt";
//                    File fileWithNewName = new File(fullPathToFile2);
//                    if (!fileWithNewName.exists()) {
//                        if (f.renameTo(fileWithNewName))
//                            System.out.println("rename file - " + fullPathToFile1 + " на " + fullPathToFile2);
//
//                    } else {
//                        System.out.println("file is already exists: " + fullPathToFile2);
//                    }
//                }
//            } else {
//                System.out.println("file does not exist: " + fullPathToFile1);
//            }
//        }
//
//    }
//
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
//    private String readFile(String fullPathToFile) throws IOException {
//
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
//    }

    //     private boolean fileExist(String fullPathToFile) {
    //        // 'Path' used to locate a file in a file system. It will
    //        // typically represent a system dependent file path.
    //        Path path = Paths.get(fullPathToFile);
    //
    //        //  'Files' class consists exclusively of static methods that operate on files,
    //        // directories, or other types of files.
    //        if (Files.exists(path)) {
    //            return true;
    //        }
    //        return true;
    //
    //    }

}
