package Test;

import com.qa.studinskyi_1lec.CreateFile;
import com.qa.studinskyi_1lec.DeleteFile;
import com.qa.studinskyi_1lec.FileManager;
import com.qa.studinskyi_1lec.RenameFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class RenameFileTest {

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
    public void renameFilePositiveTest() {
        System.out.println("Test renameFilePositiveTest() start");
        // инициализация параметров файлового менеджера при создании файла
        // попытка создать файл test123
        String currentCommand = "touch test123";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        CreateFile classCreateFile = new CreateFile();
        classCreateFile.execute();

        // попытка удалить файл test3344
        currentCommand = "rm test3344";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));
        DeleteFile classDeleteFile = new DeleteFile();
        classDeleteFile.execute();

        // попытка переименовать файл
        currentCommand = "mv test123 test3344";
        FileManager.updateCommandOption(FileManager.parsingCommandLine(currentCommand));

        // проверка наличия тестового файла перед удалением
        puthToFile = FileManager.folderFile + "test123.txt";
        File file = new File(puthToFile);
        Boolean existBeforeRunnung = file.exists();
        System.out.println("File exist: " + file.exists());
        RenameFile classRenameFile = new RenameFile();
        classRenameFile.execute();

        // проверка наличия переименованного файла перед удалением
        puthToFile = FileManager.folderFile + "test3344.txt";
        file = new File(puthToFile);
        System.out.println("Rename file exist: " + file.exists());

        // проверка наличия переименованного файла
        assertTrue(file.exists());

        System.out.println("Test deleteFilePositiveTest() end");
    }

    @AfterTest
    public void tearDown() {
        // подчищаем за собой энвайронмент
        System.out.println("AfterMethod");
    }
}
