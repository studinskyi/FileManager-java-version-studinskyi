package com.qa.studinskyi_1lec;

import java.io.File;

public class RenameFile extends FileManager {
    @Override
    public String getName() {
        //"mv - rename file";
        return "rename file";
    }

    @Override
    public void execute() {
        String nameSourceFile = "";
        String nameTargetFile = "";

        String fullPathToSourceFile = "";
        String fullPathToTargetFile = "";

        // проверка наличия введенного параметра имени исходного файла
        if (FileManager.commandParameters.size() > 1) {
            try {
                nameSourceFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameSourceFile = "";
            }
        }

        // проверка наличия введенного параметра нового имени файла
        if (FileManager.commandParameters.size() > 2) {
            try {
                nameTargetFile = FileManager.commandParameters.get(2);
            } catch (Exception e) {
                nameTargetFile = "";
            }
        }

        if (nameSourceFile.equals(""))
            nameSourceFile = FileManager.requestLine("enter the name of the file to rename:");

        if (!nameSourceFile.equals("")) {
            fullPathToSourceFile = folderFile + nameSourceFile + ".txt";
            File fileSource = new File(fullPathToSourceFile);
            //if (fileExist(fullPathToSourceFile)) {
            if (fileSource.exists()) {
                if (nameTargetFile.equals(""))
                    nameTargetFile = FileManager.requestLine("enter the new name of the file:");

                if (!nameTargetFile.equals("")) {
                    fullPathToTargetFile = folderFile + nameTargetFile + ".txt";
                    File fileWithNewName = new File(fullPathToTargetFile);
                    if (!fileWithNewName.exists()) {
                        if (fileSource.renameTo(fileWithNewName))
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
