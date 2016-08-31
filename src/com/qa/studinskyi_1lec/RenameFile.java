package com.qa.studinskyi_1lec;


import java.io.File;
import java.io.IOException;

public class RenameFile extends FileManager {
    @Override
    public String getName() {
        //"4 - rename file";
        return "rename file";
    }

    @Override
    public void execute() {
        String nameSourceFile = "";
        String nameTargetFile = "";

        String fullPathToSourceFile = "";
        String fullPathToTargetFile = "";

        try {
            System.out.println("enter the name of the file to rename:");
            nameSourceFile = FileManager.reader.readLine();
        } catch (IOException e) {
            nameSourceFile = "";
        }

        if (!nameSourceFile.equals("")) {
            fullPathToSourceFile = folderFile + nameSourceFile + ".txt";
            File f = new File(fullPathToSourceFile);
            if (f.exists()) {
                try {
                    System.out.println("enter the new name of the file:");
                    nameTargetFile = FileManager.reader.readLine();
                } catch (IOException e) {
                    nameTargetFile = "";
                }

                if (!nameTargetFile.equals("")) {
                    fullPathToTargetFile = folderFile + nameTargetFile + ".txt";
                    File fileWithNewName = new File(fullPathToTargetFile);
                    if (!fileWithNewName.exists()) {
                        if (f.renameTo(fileWithNewName))
                            System.out.println("rename file - " + fullPathToSourceFile + " на " + fullPathToTargetFile);

                    } else {
                        System.out.println("file is already exists: " + fullPathToTargetFile);
                    }
                }
            } else {
                System.out.println("file does not exist: " + fullPathToSourceFile);
            }
        }

    }
}
