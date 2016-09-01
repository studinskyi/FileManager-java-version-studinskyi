package com.qa.studinskyi_1lec;

public class CurrentDirectory extends FileManager {
    @Override
    public String getName() {
        // "pwd - current directory"
        return "current directory";
    }

    @Override
    public void execute() {
        System.out.println(FileManager.folderFile + " - current directory");
        //        String absoluteFilePath = "";
        //        //absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
        //        absoluteFilePath = workingDirectory + File.separator + filename;
        //        System.out.println("Final filepath : " + absoluteFilePath);
    }
}
