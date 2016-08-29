package com.qa.studinskyi_1lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager.setFolderFile("c:\\test_QA\\");
        FileManager.setReader(new BufferedReader(new InputStreamReader(System.in)));

        Menu menu = new Menu();
        menu.runMenu();
        FileManager.getReader().close();
        //menu.getReader().close();

        //        МИНИМУМ
        //        Что из Java Core мы не рассмотрели выполняя задачу FileManager - то и рассмотрим на следующем занятии
        //        изучить код FileManager и почитать в интрнете по всем не знакомым словам информацию. Все что не сможете переварить - пишите в личку заранее.
        //                имплементировать deleteFile(), renameFile()
        //        СРЕДНЯЯ СЛОЖНОСТЬ
        //        сделать так что бы программа работала вечно и заканчивала свою работу только, если пользователь выберет 0. выход
        //        сделать так что бы можно было прололжить создавать файл, пока пользоваль не пожелает закончить эту операцию и перейти к следующей. Например, выбрали 1, создали файл, потом программа спрашивает - продолжить создавать файл или нет?
        //        ПОВЫШЕННАЯ СЛОЖНОСТЬ
        //        имплементировать методы findWordOccurrenceInFile(), replaceWordInFile(), showLineNumbersWhereWordWasFound()

        System.out.println("Работа программы файлового менеджера завершена!");
    }
}
