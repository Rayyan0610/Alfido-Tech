import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Alfidotask2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the text document: ");
        String filePath = scanner.nextLine();

        System.out.println("Attempting to read file at: " + filePath);

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found.");
            
        }

        try {
            Scanner fileScanner = new Scanner(file);
            Map<String, Integer> wordFrequency = new HashMap<>();
            int totalWords = 0;
            int totalCharacters = 0;

            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                totalWords++;
                totalCharacters += word.length();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            double averageWordLength = totalWords > 0 ? (double) totalCharacters / totalWords : 0;

            System.out.println("Total number of words: " + totalWords);
            System.out.println("Word frequency: " + wordFrequency);
            System.out.println("Average word length: " + averageWordLength);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        scanner.close();
    }
}
