package com.qa.studinskyi_1lec;

import java.io.File;

public class DeleteFile extends FileManager {
    @Override
    public String getName() {
        // "rm - delete file"
        return "delete file (rm \"name file\")";
    }

    @Override
    public void execute() {
        String fullPathToFile = "";
        String nameFile = "";

        // проверка наличия введенного параметра имени файла
        if (FileManager.commandParameters.size() > 0) {
            try {
                nameFile = FileManager.commandParameters.get(1);
            } catch (Exception e) {
                nameFile = "";
            }
        }

        while (true) {
            if (nameFile.equals("") && FileManager.interactivCommand) {
                String answer = FileManager.requestLine("Delete file? y\\n");
                if (!answer.equals("y")) {
                    System.out.println("file deletion is canceled");
                    break;
                }

                //if (FileManager.interactivCommand) // только если включен режим интерактивности процесса выполнения команды
                nameFile = FileManager.requestLine("enter the name of the file to delete:");
            }

            if (!nameFile.equals("")) {
                fullPathToFile = folderFile + nameFile + ".txt"; // + File.separator
                if (fileExist(fullPathToFile)) {
                    //if (f.exists()) {
                    System.out.println("file is deleted: " + fullPathToFile);
                    File f = new File(fullPathToFile);
                    //                    file.setReadOnly();//mark this file as read only, since jdk 1.2
                    //                    if(file.canWrite()){
                    //                        System.out.println("This file is writable");
                    //                    }else{
                    //                        System.out.println("This file is read only");
                    //                    }
                    //                    file.setWritable(true);//revert the operation, mark this file as writable, since jdk 1.6
                    //                    if(file.canWrite()){
                    //                        System.out.println("This file is writable");
                    //                    }else{
                    //                        System.out.println("This file is read only");
                    //                    }
                    if (!f.canWrite()) {
                        try {
                            throw new ExceptionFileIsReadOnly("This file is read only: " + fullPathToFile);
                        } catch (ExceptionFileIsReadOnly e) {
                            e.printStackTrace();
                        }
                    }

                    f.delete();

                    if (fileExist(fullPathToFile)) {
                        try {
                            throw new ExceptionFileNotDeleted("File has not been deleted:" + fullPathToFile);
                        } catch (ExceptionFileNotDeleted e) {
                            e.printStackTrace();
                        }
                    }

                } else
                    System.out.println("file does not exist, it can not be deleted: " + fullPathToFile);
            }
            if (!repeatCommand)
                break;

            nameFile = "";
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