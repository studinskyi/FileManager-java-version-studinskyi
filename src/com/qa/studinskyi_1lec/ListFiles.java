package com.qa.studinskyi_1lec;

import java.io.File;

public class ListFiles extends FileManager{
    @Override
    public String getName() {
        return "1 - list files";
    }

    @Override
    public void execute() {
        System.out.println("просмотр списка файлов");
        File dir = new File(folderFile);
        if (dir.isDirectory()) {
            // если объект представляет каталог
            for (File item : dir.listFiles()) {
                // получаем все вложенные объекты в каталоге
                if (item.isDirectory())
                    System.out.println(item.getName() + "\tкаталог");
                else
                    System.out.println(item.getName() + "\tфайл");
            }
        }
    }
}

//    public static void listFiles() {
//        System.out.println("просмотр списка файлов");
//        File dir = new File(folderFile);
//        if (dir.isDirectory()) {
//            // если объект представляет каталог
//            for (File item : dir.listFiles()) {
//                // получаем все вложенные объекты в каталоге
//                if (item.isDirectory())
//                    System.out.println(item.getName() + "\tкаталог");
//                else
//                    System.out.println(item.getName() + "\tфайл");
//            }
//        }
//    }

//    public static void deleteFile() {
//        //        File dir = new File(folderFile);
//        //        File fileForDelet = null;
//        //        if (dir.isDirectory()) {
//        //            // если объект представляет каталог
//        //            for (File item : dir.listFiles()) {
//        //                // получаем все вложенные объекты в каталоге
//        //                if (!item.isDirectory()) {
//        //                    fileForDelet = item;
//        //                    break;
//        //                }
//        //            }
//        //        }
//        String nameFile = "";
//        try {
//            System.out.println("enter the name of the file to delete:");
//            nameFile = FileManager.reader.readLine();
//        } catch (IOException e) {
//            nameFile = "";
//            //e.printStackTrace();
//        }
//
//        String fullPathToFile = "";
//        if (!nameFile.equals("")) {
//            fullPathToFile = folderFile + nameFile + ".txt";
//            File f = new File(fullPathToFile);
//            if (f.exists()) {
//                System.out.println("file is deleted: " + fullPathToFile);
//                // начало блока обработки возможной ислючительной ситуации
//                f.delete();  // код, который потенциально может вызвать исключение (исключительную ситуацию), если
//            }
//        }
//
//    }

