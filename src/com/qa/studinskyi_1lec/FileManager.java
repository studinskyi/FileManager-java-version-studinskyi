package com.qa.studinskyi_1lec;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FileManager {
    public static String folderFile;
    public static BufferedReader reader;
    public static String currentCommand;
    public static ArrayList<String> commandParameters = new ArrayList<>();
    public static LinkedHashMap<String, String> executedOperations = new LinkedHashMap<>();
    public static Menu menu = new Menu();
    public static boolean repeatCommand = true; // необходимость выполнения
    public static boolean interactivCommand = true; // режим интерактивности процесса выполнения команды (то есть будет запрашивать ввод имени файла или каталога при их отсутствии в переданных параметрах)

    public FileManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract String getName();

    public abstract void execute();

    public static String requestLine(String textMessage) {
        String answer = "";
        String oneSpace = " ";
        String twoSpaces = "  ";
        String strRepl = "";

        try {
            System.out.println(textMessage);
            answer = reader.readLine();
        } catch (IOException e) {
            answer = "";
        }

        // удаление символа кавычек и апострофа из введенной с клавиатуры строки
        while (answer.indexOf("\"") >= 0 || answer.indexOf("\'") >= 0) {
            strRepl = answer.replace("\"","");
            answer = strRepl.replace("\'","");
            //answer = replace;
        }
        // свертка пробелов в строке команды, введенной с клавиатуры
        while (answer.indexOf(twoSpaces) >= 0) {
            strRepl = answer.replace(twoSpaces, oneSpace);
            answer = strRepl;
        }

        return answer;
    }

    public static void setWorkFolder(String fullPathDirectory) {
        if (fullPathDirectory.equals(""))
            fullPathDirectory = "c:\\test_QA\\";

        File fDirectory = new File(fullPathDirectory);
        if (!fDirectory.exists()) {
            //myPath.mkdir();  //выбросит исключение, если родительского каталога нет в файловой системе
            fDirectory.mkdirs();  // создаст и всю цепочку каталгов если их нет.
            // проверка наличия созданной директории
            if (fDirectory.exists())
                FileManager.folderFile = fullPathDirectory;
                //System.out.println("directory was created: " + fullPathDirectory);
            else
                fullPathDirectory = "c:\\";
            //System.out.println("directory did not created: " + fullPathDirectory);
        } else
            FileManager.folderFile = fullPathDirectory; // каталог уже существует
        //System.out.println("directory is already exists: " + fullPathDirectory);

        System.out.println(FileManager.folderFile + " - current directory");
        FileManager.folderFile = folderFile;
    }

    public static String readFile(String fullPathToFile) throws IOException {

        String textOfFile = "";
        String line = "";
        String lineSeparator = System.getProperty("line.separator");

        File file = new File(fullPathToFile);
        if (!file.exists()) {
            System.out.println("file does not exist: " + fullPathToFile);
            return "";
        }

        try (BufferedReader readerFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(fullPathToFile), StandardCharsets.UTF_8))) {
            while ((line = readerFile.readLine()) != null)
                //textOfFile += line + "\n";
                textOfFile += line + lineSeparator;

        } catch (IOException e) {
            FileManager.requestLine("error opening file " + fullPathToFile);
        }

        return textOfFile;
        //        try {
        //            BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
        //            String strLine = "";
        //            while ((strLine = reader.readLine()) != null)
        //                lines.add(strLine);
        //            reader.close();
        //        } catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        //===================== 2 вариант
        //        File file = new File(fullPathToFile);
        //        StringBuilder fileContents = new StringBuilder((int) file.length());
        //        Scanner scanner = new Scanner(file);
        //        String lineSeparator = System.getProperty("line.separator");
        //
        //        try {
        //            while (scanner.hasNextLine()) {
        //                fileContents.append(scanner.nextLine() + lineSeparator);
        //            }
        //            return fileContents.toString();
        //        } finally {
        //            scanner.close();
        //        }

        //===================== 3 вариант
        //        List<String> list = new ArrayList<String>();
        //        String line = "";
        //        Scanner in = new Scanner(new File(fullPathToFile));
        //        while (in.hasNextLine()) {
        //            line = in.nextLine();
        //            list.add(line);
        //            System.out.println(line);
        //        }
        //        //String[] array = list.toArray(new String[0]);
        //============== 4 вариант
        //        BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
        //        String line;
        //        List<String> lines = new ArrayList<String>();
        //        while ((line = reader.readLine()) != null) {
        //            lines.add(line);
        //            System.out.println(line);
        //        }
        //        //        String [] linesAsArray = lines.toArray(new String[lines.size()]);
    }

    public static int findWordOccurrenceInFile(String fullPathToFile, String word) {
        int count = 0;
        String fileContent = "";

        if (fileExist(fullPathToFile)) {
            //if (f.exists()) {
            Pattern pattern = Pattern.compile(word);
            try {
                fileContent = readFile(fullPathToFile);
            } catch (IOException e) {
                System.out.println("text of the file has not been read: " + fullPathToFile);
            }
            Matcher matcher = pattern.matcher(fileContent);
            int pos = 0;
            while (matcher.find(pos)) {
                count++;
                pos = matcher.start() + 1;
            }
        } else
            System.out.println("file does not exist: " + fullPathToFile);

        return count;
    }

    public static String[] parsingCommandLine(String strCommand) {
        String oneSpace = " ";
        String twoSpaces = "  ";
        String strRepl = "";

        while (strCommand.indexOf("\"") >= 0 || strCommand.indexOf("\'") >= 0) {
            strRepl = strCommand.replace("\"","");
            strCommand = strRepl.replace("\'","");
            //answer = replace;
        }
        // свертка пробелов в строке команды, введенной с клавиатуры
        while (strCommand.indexOf(twoSpaces) >= 0) {
            strRepl = strCommand.replace(twoSpaces, oneSpace);
            strCommand = strRepl;
        }
        //        while(strCommand.contains("  ")) {
        //            String replace = strCommand.replace("  ", " ");
        //            strCommand = replace;
        //        }
        // преобразование строки в массив подстрок, используя в качестве разделителя пробел " "
        // удаление символа кавычек и апострофа из введенной с клавиатуры строки

        String[] massStr = strCommand.split(" ");
        return massStr;
    }

    public static void updateCommandOption(String[] massCommand) {
        // обновление списка проанализированных параметров из введенной команды
        FileManager.commandParameters.clear();
        for (String tekStr : massCommand)
            FileManager.commandParameters.add(tekStr);
    }


    public static void replaceWordInFile(String fullPathToFile, String wordSource, String wordTarget) {
        String textToFile = "";

        if (fileExist(fullPathToFile)) {
            //if (f.exists()) {
            Pattern pattern = Pattern.compile(wordSource);
            String fileContent = "";
            try {
                fileContent = readFile(fullPathToFile);
            } catch (IOException e) {
                System.out.println("text of the file has not been read: " + fullPathToFile);
            }
            Matcher matcher = pattern.matcher(fileContent);
            textToFile = matcher.replaceAll(wordTarget);
            //replaceAll(String regex, String replacement)
            //        Matcher m = Pattern.compile("http://(.*?)/|$").matcher(url);
            //        if (m.find()) {
            //            String domain = m.group(0);
            //            stats.put(domain, stats.containsKey(domain) ? stats.get(domain) + 1 : 1);
            //        } else {
            //            System.out.println("Cant extract domain from " + url);
            //        }

            // int pos = 0;
            //            while (matcher.find(pos)) {
            //                count++;
            //                pos = matcher.start() + 1;
            //            }
            try {
                OutputStream outStream = new FileOutputStream(fullPathToFile);
                outStream.write(textToFile.getBytes());
                outStream.close();
            } catch (IOException e) {
                System.out.println("did not replace substring \"" + wordSource + "\" in file: " + fullPathToFile);
            }
            System.out.println(textToFile);
        } else
            System.out.println("file does not exist: " + fullPathToFile);
    }

    public static void showLineNumbersWhereWordWasFound(String fullPathToFile, String wordSource) {
        String fileContent = "";

        if (fileExist(fullPathToFile)) {
            try {
                fileContent = readFile(fullPathToFile);
            } catch (IOException e) {
                System.out.println("text of the file has not been read: " + fullPathToFile);
            }
            String lineSeparator = System.getProperty("line.separator");
            String[] linesOfText = fileContent.split("\n");
            //String[] linesOfText = fileContent.split(lineSeparator);
            for (String str : linesOfText) {
                if (str.contains(wordSource))
                    System.out.println(str);
            }

            //            while (strCommand.indexOf(twoSpaces) >= 0) {
            //                String replace = strCommand.replace(twoSpaces, oneSpace);
            //                strCommand = replace;
            //            }
            //            //        while(strCommand.contains("  ")) {
            //            //            String replace = strCommand.replace("  ", " ");
            //            //            strCommand = replace;
            //            //        }
            //            // преобразование строки в массив подстрок, используя в качестве разделителя пробел " "
            //            String[] massStr = strCommand.split(" ");

        } else
            System.out.println("file does not exist: " + fullPathToFile);
    }

    public static boolean fileExist(String fullPathToFile) {
        // 'Path' used to locate a file in a file system. It will
        // typically represent a system dependent file path.
        Path path = Paths.get(fullPathToFile);

        //  'Files' class consists exclusively of static methods that operate on files,
        // directories, or other types of files.
        if (Files.exists(path)) {
            return true;
        }
        return false;

    }

}
