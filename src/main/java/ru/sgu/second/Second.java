package main.java.ru.sgu.second;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Second {
    private static final String RESULT_ZIP = "src/main/java/ru/sgu/second/result/result.zip";
    private Scanner scanner = null;
    private String targetDir = null;
    private String targetString = null;
    private FileOutputStream fileOutputStream = null;
    private ZipOutputStream zipOutputStream = null;

    public Second() {
        scanner = new Scanner(System.in);
        System.out.println("Enter dir path");
        targetDir = scanner.nextLine();
        System.out.println("Enter target string");
        targetString = scanner.nextLine();
        try {
            fileOutputStream = new FileOutputStream(RESULT_ZIP);
            zipOutputStream = new ZipOutputStream(fileOutputStream);
        } catch (IOException e) {
            System.out.println("Failed while working with zip file");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Second second = new Second();
        second.solve();
    }

    private void solve() {
        solve(new File(targetDir));
        close();
    }

    private void close() {
        try {
            zipOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("something went wrong while closing output streams");
        }

    }

    private void addEntryToZip(File file) {
        try {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }

            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Something went wrong while adding file " + file.getName() + " to zip");
        }
    }


    private void solve(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) solve(file);
            else {
                if (file.getName().contains(targetString)) {
                    addEntryToZip(file);
                }
            }
        }
    }
}
