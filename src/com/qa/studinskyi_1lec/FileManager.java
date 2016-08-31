package com.qa.studinskyi_1lec;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    //public static HashMap<String, String> executedOperations;

    public FileManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract String getName();

    public abstract void execute();

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
