package com.qa.studinskyi_1lec;

import java.io.File;

public class ChangeDirectory extends FileManager {
    @Override
    public String getName() {
        // "cd - change directory"
        return "change directory (cd \"name directory\")";
    }

    @Override
    public void execute() {
        String nameDirectory = "";
        String fullPathDirectory = "";
        String fileSeparator = File.separator;

        // проверка наличия введенного параметра имени директории
        if (FileManager.commandParameters.size() > 0) {
            try {
                for (int i = 1; i < FileManager.commandParameters.size(); i++)
                    nameDirectory += FileManager.commandParameters.get(i);
            } catch (Exception e) {
                nameDirectory = "";
            }
        }
        if (nameDirectory.equals(""))
            nameDirectory = FileManager.requestLine("input name directory");

        if (nameDirectory.equals("..")) {
            File fDirectory = new File(FileManager.folderFile);
            if (fDirectory.exists()) {
                String currenDir = fDirectory.getParent();
                if (currenDir != null) {
                    fDirectory = new File(currenDir);
                    if (fDirectory.exists()) {
                        FileManager.folderFile = currenDir;
                        System.out.println(FileManager.folderFile + " - current directory");
                    }
                }
            } else
                System.out.println("directory does not exist: " + FileManager.folderFile);

        } else {
            // приведение пути к новому каталогу в нормальное состояние
            fullPathDirectory = FileManager.folderFile + fileSeparator + nameDirectory + fileSeparator;
            String badSlash = (!fileSeparator.equals("/")) ? "/" : "\\";
            while (fullPathDirectory.indexOf(badSlash) >= 0) {
                String replace = fullPathDirectory.replace(badSlash, fileSeparator);
                fullPathDirectory = replace;
            }
            while (fullPathDirectory.contains(fileSeparator + fileSeparator)) {
                String replace = fullPathDirectory.replace(fileSeparator + fileSeparator, fileSeparator);
                fullPathDirectory = replace;
            }
            File fDirectory = new File(fullPathDirectory);
            if (fDirectory.exists()) {
                FileManager.folderFile = fullPathDirectory;
                System.out.println(FileManager.folderFile + " - current directory");
            } else
                System.out.println("directory does not exist: " + fullPathDirectory);
        }

    }
}
