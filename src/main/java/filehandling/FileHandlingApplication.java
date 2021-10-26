package filehandling;
import filehandling.exception.InvalidPathException;
import filehandling.model.FileData;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingApplication {
    static FileRecord fileRecord = new FileRecord();
    public static void main(String[] args){
        BufferedReader bufferedReader = null;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Folder Path :");
            File file = new File(sc.nextLine());
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            bufferedReader = fileRecord.getBufferedReader(f);
                            if (bufferedReader != null){
                                FileHandlingApplication.printFileInfo(bufferedReader, f);
                            } else {
                                throw new NullPointerException("Null Pointer Exception");
                            }
                        }
                    }
                }
            } else {
                throw new InvalidPathException("The provided path is invalid");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    static public void printFileInfo(BufferedReader bufferedReader, File file) throws IOException {
        FileData fileData = fileRecord.readRecord(bufferedReader, file);
        System.out.println("File Name : " + fileData.getFileName());
        System.out.println("Distinct word counts : " + fileData.getDistinctWordCount());
        fileRecord.printWordsWithCount();
        System.out.println("--------------------------------------------------------------");
    }
}
