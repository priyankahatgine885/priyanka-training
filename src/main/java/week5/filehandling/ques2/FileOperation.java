package week5.filehandling.ques2;

import week5.filehandling.ques2.model.FileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface FileOperation {
    FileData readRecord(BufferedReader bufferedReader, File file) throws IOException;
    BufferedReader getBufferedReader(File file) throws FileNotFoundException;
    int getDistinctWord(String line);
    Map<String, Integer> getWordsWithCount(String line);
}
