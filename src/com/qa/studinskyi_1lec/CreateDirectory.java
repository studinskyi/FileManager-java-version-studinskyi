package com.qa.studinskyi_1lec;

import java.io.File;

public class CreateDirectory extends FileManager{
    @Override
    public String getName() {
        // "mkdir - create directory"
        return "create directory (mkdir \"name directory\")";
    }

    @Override
    public void execute() {
        String nameDirectory = "";
        String fullPathDirectory = "";
        String FileSeparated = File.separator;

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

        // приведение пути к новому каталогу в нормальное состояние
        fullPathDirectory = folderFile + FileSeparated + nameDirectory + FileSeparated;
        String badSlash =  (!FileSeparated.equals("/"))? "/": "\\";
        while (fullPathDirectory.indexOf(badSlash) >= 0) {
            String replace = fullPathDirectory.replace(badSlash, FileSeparated);
            fullPathDirectory = replace;
        }
        while(fullPathDirectory.contains(FileSeparated+FileSeparated)) {
            String replace = fullPathDirectory.replace(FileSeparated+FileSeparated,FileSeparated);
            fullPathDirectory = replace;
        }
        File fDirectory = new File(fullPathDirectory);
        if(!fDirectory.exists()) {
            //myPath.mkdir();  //выбросит исключение, если родительского каталога нет в файловой системе
            fDirectory.mkdirs();  // создаст и всю цепочку каталгов если их нет.
            // проверка наличия созданной директории
            if(fDirectory.exists())
                System.out.println("directory was created: " + fullPathDirectory);
            else
                System.out.println("directory did not created: " + fullPathDirectory);
        } else
            System.out.println("directory is already exists: " + fullPathDirectory);

    }
}
