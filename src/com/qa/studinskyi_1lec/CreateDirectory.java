package com.qa.studinskyi_1lec;

import java.io.File;

public class CreateDirectory extends FileManager {
    @Override
    public String getName() {
        // "mkdir - create directory"
        return "create directory (mkdir \"name directory\")";
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
        if (!fDirectory.exists()) {
            //myPath.mkdir();  //выбросит исключение, если родительского каталога нет в файловой системе
            fDirectory.mkdirs();  // создаст и всю цепочку каталгов если их нет.
            // проверка наличия созданной директории
            if (!fDirectory.exists()) {
                try {
                    // System.out.println("Directory did not created: " + fullPathDirectory);
                    throw new ExceptionDirectoryNotCreated("File was not created:" + fullPathDirectory);
                } catch (ExceptionDirectoryNotCreated e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("Directory was created: " + fullPathDirectory);

        } else
            System.out.println("Directory is already exists: " + fullPathDirectory);

    }
}
