package com.pretius.pretius.helper;


import com.pretius.pretius.shell.ShellExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Collections;

public class FileHelper {

    private static final String ENCODING = "UTF-8";

    private static final Path pathHOME = Paths.get("/home/zlp/Pretius/HOME");

    private static final Path pathDEV = Paths.get("/home/zlp/Pretius/DEV");

    private static final Path pathTEST = Paths.get("/home/zlp/Pretius/TEST");

    private static final Path pathCOUNT = Paths.get("/home/zlp/Pretius/count.txt");

    public static Path getPathHOME() {
        return pathHOME;
    }

    public static Path getPathDEV() {
        return pathDEV;
    }

    public static Path getPathTEST() {
        return pathTEST;
    }

    public static void createDirectories() throws IOException {
        if(!Files.exists(pathHOME)) {
            Files.createDirectory(pathHOME);
            System.out.println("Home created");
        }
        else {
            System.out.println("Directory Home already exists");
        }
        if(!Files.exists(pathDEV)) {
            Files.createDirectory(pathDEV);
            System.out.println("Directory DEV created");
        }
        else {
            System.out.println("Directory DEV already exists");
        }
        if(!Files.exists(pathTEST)) {
            Files.createDirectory(pathDEV);
            System.out.println("Directories Test created");
        }
        else {
            System.out.println("Directory path Test already exists");
        }
        System.out.println("Directories created");
    }

    public static void createFiles() throws IOException {
        if(!Files.exists(pathCOUNT)) {
            Files.createFile(pathCOUNT);
            writeLine("0");
            System.out.println("Count file created");
        }
        else {
            System.out.println("Count file already exists");
        }
    }

    private static void writeLine(String line) throws IOException {
        if(!Files.exists(pathCOUNT)) {
            Files.createFile(pathCOUNT);
            System.out.println("Count file created");
        }
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null");
        }
        FileUtils.writeLines(new File(pathCOUNT.toString()), ENCODING, Collections.singleton(line), false);
    }

    private static String readLastLine() throws IOException {
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(new File(pathCOUNT.toString()), Charset.defaultCharset())) {
            return reader.readLine();
        }
    }

    private static void changeHelpFile() throws IOException {
        int readLastLine = Integer.parseInt(readLastLine());
        readLastLine++;
        writeLine(String.valueOf(readLastLine));
    }

    public static void moveFileToAnotherDirectory(String file) throws IOException {

        Calendar calendar = Calendar.getInstance();

        if(file.matches(".+\\.xml")) {
            String filePath = pathHOME.toString()+"/"+file+" ";
            String command = String.format("mv %s  %s", filePath,pathDEV );
            ShellExecutor.executeCommand(command);
            changeHelpFile();
        }

        if(file.matches(".+\\.jar")) {

            if(calendar.get(Calendar.HOUR)%2==0) {
                String filePath = pathHOME.toString()+"/"+file+" ";
                String command = String.format("mv %s  %s", filePath,pathDEV );
                ShellExecutor.executeCommand(command);
                changeHelpFile();
            }
            if(calendar.get(Calendar.HOUR)%2!=0) {
                String filePath = pathHOME.toString()+"/"+file+" ";
                String command = String.format("mv %s  %s", filePath,pathTEST );
                ShellExecutor.executeCommand(command);
                changeHelpFile();
            }
        }
    }
}
