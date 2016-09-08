package com.qa.studinskyi_1lec;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;


public class DeleteFileTest {

    String puthToFile = "";

    @BeforeTest
    public void setUp() {
        // подготовка тестовых данных
        System.out.println("BeforeTest");
        // инициализация параметров файлового менеджера
        FileManager.setWorkFolder("c:\\test_QA\\");
        FileManager.repeatCommand = false; // не выполнять запрос на создание следующего файла
    }

    @Test(enabled = true)
    public void deleteFilePositiveTest() {
        System.out.println("Test deleteFilePositiveTest() start");
        // инициализация параметров файлового менеджера при создании файла
        String currentCommand = "touch test123";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));

        // попытка создать файл
        CreateFile classCreateFile = new CreateFile();
        classCreateFile.execute();

        // попытка удалить файл
        currentCommand = "rm test123";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));

        // проверка наличия тестового файла перед удалением
        puthToFile = FileManager.folderFile + "test123.txt";
        File file = new File(puthToFile);
        Boolean existBeforeRunnung = file.exists();
        System.out.println("File exist: " + file.exists());
        DeleteFile classDeleteFile = new DeleteFile();
        classDeleteFile.execute();

        System.out.println("File exist: " + file.exists());

        Boolean existAfaterRunnung = file.exists();
        // проверка отсутствия файла
        assertTrue(existBeforeRunnung && !existAfaterRunnung);

        System.out.println("Test deleteFilePositiveTest() end");
    }

    @AfterTest
    public void tearDown() {
        // подчищаем за собой энвайронмент
        System.out.println("AfterMethod");
    }
}
