package Test;

import com.qa.studinskyi_1lec.CreateFile;
import com.qa.studinskyi_1lec.DeleteFile;
import com.qa.studinskyi_1lec.FileManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class CreateDirectoryTest {
    String nameDirectory = "";
    String fullPathDirectory = "";
    String FileSeparated = File.separator;

    @BeforeTest
    public void setUp() {
        // подготовка тестовых данных
        System.out.println("BeforeTest");
        // инициализация параметров файлового менеджера
        FileManager.setWorkFolder("c:\\test_QA\\");
        FileManager.repeatCommand = false; // не выполнять запрос на создание следующего файла
        FileManager.interactivCommand = false;
    }

    @Test(enabled = true)
    public void сreateDirectoryPositiveTest() {
        System.out.println("Test сreateDirectoryPositiveTest() start");
        //        // инициализация параметров файлового менеджера при создании файла
        //        String currentCommand = "touch test123.txt"; // команда создания файла test123.txt
        //        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        //        // проверка создания тестового файла и реального результата
        //        puthToFile = FileManager.folderFile + "test123.txt";
        //        File file = new File(puthToFile);
        //        System.out.println("File exist: " + file.exists());
        //        // попытка создать файл
        //        CreateFile classCreateFile = new CreateFile();
        //        classCreateFile.execute();
        //        System.out.println("File exist: " + file.exists());
        //        assertTrue(file.exists());
        //
        //        // удаление созданного при тестировании файла
        //        currentCommand = "rm test123.txt";
        //        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        //        DeleteFile classDeleteFile = new DeleteFile();
        //        classDeleteFile.execute();

        System.out.println("Test сreateDirectoryPositiveTest() end");
    }

    @AfterTest
    public void tearDown() {
        // подчищаем за собой энвайронмент
        System.out.println("AfterMethod");
    }
}
