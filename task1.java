import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.print("Enter '1' to input text manually or '2' to specify a file for word count: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println();

        if (choice == 1) {
            System.out.println("Enter the text for word counting:");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the path to the file you want to count words from:");
            String filePath = scanner.nextLine();

            try {
                inputText = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
                System.exit(1);
            }
        } else {
            System.err.println("Invalid choice. Please enter '1' or '2'.");
            System.exit(1);
        }

        whileloop: while (true) {
            System.out.print(
                    "Please Enter:\n1. -> To know the Total Number of Words.\n2. -> To know the frequency of all input words.\n3. -> To know the frequency of all input words except common words.\n4. -> To Exit : ");
            int action = scanner.nextInt();

            switch (action) {
                case 1: {
                    int totalWordCount = countWords(inputText);
                    System.out.println("--->  Total Word Count: " + totalWordCount);
                    break;
                }
                case 2: {
                    Map<String, Integer> wordFrequency = getWordFrequency(inputText, 2);
                    System.out.println("--->  Total Number of Words: " + wordFrequency.size());
                    System.out.println("Word Frequency:");
                    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                }
                case 3: {
                    Map<String, Integer> wordFrequency = getWordFrequency(inputText, 3);
                    System.out.println("--->  Total Number of Words (except common words): " + wordFrequency.size());
                    System.out.println("The Common Words are : { \"a\", \"and\", \"as\", \"in\", \"is\", \"it\", \"of\", \"that\", \"the\", \"to\", \"with\"}");
                    System.out.println("Word Frequency:");
                    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Thank You for using the program!!!\n.......Program Exiting.......");
                    break whileloop;
                }
                default: {
                    System.out.println("Wrong Input!!!\nEnter Correctly...");
                    break;
                }
            }
        }

        scanner.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s.,!?;:]+");
        return words.length;
    }

    public static Map<String, Integer> getWordFrequency(String text, int n) {
        String[] words = text.split("[\\s.,!?;:]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase(); 
            if (isCommonWord(word) && n == 3) {
                continue;
            } else {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequency;
    }

    public static boolean isCommonWord(String word) {
        String[] commonWords = { "a", "and", "as", "in", "is", "it", "of", "that", "the", "to", "with"};
        return Arrays.asList(commonWords).contains(word.toLowerCase());
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine());
                if (fileScanner.hasNextLine()) {
                    content.append("\n");
                }
            }
        }

        return content.toString();
    }
}