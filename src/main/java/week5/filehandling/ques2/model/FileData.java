package week5.filehandling.ques2.model;

import lombok.*;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileData {
    private String fileName;
    private int distinctWordCount;
    private Map<String, Integer> wordsWithCount;
}

