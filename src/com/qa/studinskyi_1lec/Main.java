package com.qa.studinskyi_1lec;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        FileManager.folderFile = "c:\\test_QA\\";
        FileManager.menu.runMenu();
        //        Menu menu = new Menu();
        //        menu.runMenu();
        FileManager.reader.close();

        //        МИНИМУМ
        //        Что из Java Core мы не рассмотрели выполняя задачу FileManager - то и рассмотрим на следующем занятии
        //        изучить код FileManager и почитать в интрнете по всем не знакомым словам информацию. Все что не сможете переварить - пишите в личку заранее.
        //                имплементировать deleteFile(), renameFile()
        //        СРЕДНЯЯ СЛОЖНОСТЬ
        //        сделать так что бы программа работала вечно и заканчивала свою работу только, если пользователь выберет 0. выход
        //        сделать так что бы можно было прололжить создавать файл, пока пользоваль не пожелает закончить эту операцию и перейти к следующей. Например, выбрали 1, создали файл, потом программа спрашивает - продолжить создавать файл или нет?
        //        ПОВЫШЕННАЯ СЛОЖНОСТЬ
        //        имплементировать методы findWordOccurrenceInFile(), replaceWordInFile(), showLineNumbersWhereWordWasFound()
        System.out.println("File manager program completed its work and is closed!");
    }
}
