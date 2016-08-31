package com.qa.studinskyi_1lec;

import java.io.File;

public class ListFiles extends FileManager{
    @Override
    public String getName() {
        // "1 - list files and catalogs";
        return "list files and catalogs";
    }
    @Override
    public void execute() {
        System.out.println("list of files and directories:");
        File dir = new File(folderFile);
        if (dir.isDirectory()) {
            // если объект представляет каталог
            for (File item : dir.listFiles()) {
                // получаем все вложенные объекты в каталоге
                if (item.isDirectory())
                    System.out.println(FileManager.folderFile + item.getName() + "\tкаталог");
                else
                    System.out.println(FileManager.folderFile + item.getName() + "\tфайл");
            }
        }
    }
}



