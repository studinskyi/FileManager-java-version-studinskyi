package com.qa.studinskyi_1lec;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class CreateFileTest {

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
    public void сreateFilePositiveTest() {
        System.out.println("Test сreateFilePositiveTest() start");
        // инициализация параметров файлового менеджера при создании файла
        String currentCommand = "touch test123";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        // проверка создания тестового файла и реального результата
        puthToFile = FileManager.folderFile + "test123.txt";
        File file = new File(puthToFile);
        System.out.println("File exist: " + file.exists());
        // попытка создать файл
        CreateFile classCreateFile = new CreateFile();
        classCreateFile.execute();
        System.out.println("File exist: " + file.exists());
        assertTrue(file.exists());

        // удаление созданного при тестировании файла
        currentCommand = "rm test123";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        DeleteFile classDeleteFile = new DeleteFile();
        classDeleteFile.execute();

        System.out.println("Test сreateFilePositiveTest() end");
    }

    @AfterTest
    public void tearDown() {
        // подчищаем за собой энвайронмент
        System.out.println("AfterMethod");
    }


}
