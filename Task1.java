package advanced;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowelsQue = new ArrayDeque<>();
        Deque<String> consonantStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(vowelsQue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).forEach(consonantStack::push);

        List<String> words = List.of("pear", "flour", "pork", "olive");
        List<String> foundWords = new ArrayList<>(List.of("____", "_____", "____", "_____"));

        while (!consonantStack.isEmpty()) {
            String vowel = vowelsQue.poll();
            String consonant = consonantStack.pop();

            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i);
                String emptyWord = foundWords.get(i);

                if (currentWord.contains(vowel)) {
                    int index = currentWord.indexOf(vowel);
                    emptyWord = emptyWord.substring(0, index) + vowel + emptyWord.substring(index + 1);
                    foundWords.set(i, emptyWord);
                }
                if (currentWord.contains(consonant)) {
                    int index = currentWord.indexOf(consonant);
                    emptyWord = emptyWord.substring(0, index) + consonant + emptyWord.substring(index + 1);
                    foundWords.set(i, emptyWord);

                }

            }
            vowelsQue.offer(vowel);
        }
        List<String> result = foundWords.stream().filter(word -> !word.contains("_"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n",result.size());
        result.forEach(System.out::println);

    }
}
