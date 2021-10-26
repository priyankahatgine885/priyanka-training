package filehandling;
import filehandling.model.FileData;
import java.io.*;
import java.util.*;

public class FileRecord implements FileOperation{
    private static Set<String> setWord = new HashSet<>();
    private static List<String> wordList = new ArrayList<>();
    private static Map<String, Integer> wordsWithCount = new HashMap<>();
    @Override
    public FileData readRecord(BufferedReader bufferedReader, File file) throws IOException {
        FileData fileData = new FileData();
        String line = null;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            int distinctWordCount = getDistinctWord(line);
            fileData.setDistinctWordCount(distinctWordCount);
            Map<String, Integer> map = getWordsWithCount(line);
            fileData.setWordsWithCount(map);
        }
        String fileName = file.getName();
        fileData.setFileName(fileName);
        return fileData;
    }
    @Override
    public BufferedReader getBufferedReader(File file) throws FileNotFoundException {
        BufferedReader bufferedReader = null;
        try {
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new FileReader(file));
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(ex.getMessage());
        }
        return bufferedReader;
    }
    @Override
    public int getDistinctWord(String line) {
        int length = 0;
        String[] words = line.split("[-{}()\t=+.,*:;?!~\\s]+");
        for (int i = 0; i < words.length; ++i) {
            setWord.add(words[i].toLowerCase());
        }
        length = setWord.size();
        return length;
    }
    @Override
    public Map<String, Integer> getWordsWithCount(String line) {
        String[] words = line.split("[-{}//<>()\t=+.,*:;?!~\\s]+");
        for (int i = 0; i < words.length; ++i) {
            if (wordsWithCount.containsKey(words[i])) {
                wordsWithCount.put(words[i], wordsWithCount.get(words[i]) + 1);
            } else {
                wordsWithCount.put(words[i], 1);
            }
        }
        return wordsWithCount;
    }
    public void printWordsWithCount() {
        for (String key : wordsWithCount.keySet()) {
            Integer value = wordsWithCount.get(key);
            System.out.println("Word Name : " + key + "   " + "Count : " + value);
        }
    }
}
