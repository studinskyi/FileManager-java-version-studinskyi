package com.qa.studinskyi_1lec;

public class Help extends FileManager {
    @Override
    public String getName() {
        // "help - print menu"
        return "print menu";
    }

    @Override
    public void execute() {
        menu.printMenu();
    }
}
