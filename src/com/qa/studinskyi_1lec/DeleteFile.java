package com.qa.studinskyi_1lec;

import java.io.File;
import java.io.IOException;

public class DeleteFile extends FileManager {
    @Override
    public String getName() {
        // "3 - delete file"
        return "delete file";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";
        String answer = "";
        while (true) {
            try {
                System.out.println("Delete file? y\\n ");
                answer = FileManager.reader.readLine();
            } catch (IOException e) {
                answer = "";
            }
            if (!answer.equals("y")) {
                System.out.println("file deletion is canceled");
                break;
            }
            try {
                System.out.println("enter the name of the file to delete:");
                nameFile = FileManager.reader.readLine();
            } catch (IOException e) {
                nameFile = "";
            }

            if (!nameFile.equals("")) {
                fullPathToFile = folderFile + nameFile + ".txt";
                if (fileExist(fullPathToFile)) {
                    //if (f.exists()) {
                    System.out.println("file is deleted: " + fullPathToFile);
                    File f = new File(fullPathToFile);
                    f.delete();
                } else
                    System.out.println("file does not exist, it can not be deleted: " + fullPathToFile);
            }
        }

        //        File dir = new File(folderFile);
        //        File fileForDelet = null;
        //        if (dir.isDirectory()) {
        //            // если объект представляет каталог
        //            for (File item : dir.listFiles()) {
        //                // получаем все вложенные объекты в каталоге
        //                if (!item.isDirectory()) {
        //                    fileForDelet = item;
        //                    break;
        //                }
        //            }
        //        }
    }
}