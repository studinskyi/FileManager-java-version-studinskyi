package com.qa.studinskyi_1lec;

public class CurrentDirectory extends FileManager{
    @Override
    public String getName() {
        // "pwd - current directory"
        return "current directory";
    }

    @Override
    public void execute() {
        System.out.println(FileManager.folderFile + " - current directory");
    }
}
