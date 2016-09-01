package com.qa.studinskyi_1lec;

import java.util.Map;

public class History extends FileManager {
    @Override
    public String getName() {
        // "history - command line history"
        return "command line history";
    }

    @Override
    public void execute() {
        System.out.println("view the command line history");
        for (Map.Entry<String, String> entry : executedOperations.entrySet())
            System.out.println(entry.getKey() + "|" + entry.getValue());
        //        Iterator<Map.Entry<String, String>> iterator = executedOperations.entrySet().iterator();
        //        while (iterator.hasNext())
        //        {
        //            Map.Entry<String, String> pair = iterator.next();
        //            System.out.println(pair.getKey() + " " + pair.getValue());
        //
        //        }
    }
}
