package codingtask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class ReducibleWords {

    static Set<String> ALL_WORDS = new HashSet<>();
    static Map<String, List<String>> wordPathMap = new HashMap<>();
    public static void main(String[] args) throws IOException {

        readAllWordsFromFile();

        long start = System.currentTimeMillis();
        List<String> validWords = new ArrayList<>();
        for (String currentWord: ALL_WORDS) {
            if(currentWord.length() == 9 && isReducible(currentWord) && wordPathMap.get(currentWord).size() == 9) {
                validWords.add(currentWord);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
        System.out.println(validWords.size());
    }

    static boolean isReducible(String word) {

        if(!ALL_WORDS.contains(word)) {
            return false;
        }

        if(word.length() == 1){
            if(word.equals("a") || word.equals("i")){
                List<String> wordPath = new ArrayList<>();
                wordPath.add(word);
                wordPathMap.put(word, wordPath);
                return true;
            } else {
                wordPathMap.put(word, null);
                return false;
            }
        }

        if(wordPathMap.containsKey(word)) {
            return wordPathMap.get(word) != null;
        }

        for (int i = 0; i < word.length(); i++) {
            String nextPossibleWord = getNextPossibleWord(word, i);
            if(isReducible(nextPossibleWord)) {
                List<String> wordPath = new ArrayList<>();
                wordPath.add(word);
                if(wordPathMap.get(nextPossibleWord) != null) {
                    wordPath.addAll(wordPathMap.get(nextPossibleWord));
                }
                wordPathMap.put(word, wordPath);
                return true;
            }
        }
        wordPathMap.put(word, null);
        return false;
    }

    static String getNextPossibleWord(String currentWord, int index) {
        return currentWord.substring(0, index) + currentWord.substring(index + 1);
    }

    static void readAllWordsFromFile() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                ALL_WORDS.add(line.trim().toLowerCase());
            }
        }
        ALL_WORDS.add("a");
        ALL_WORDS.add("i");
        wordPathMap.put("a", List.of("a"));
        wordPathMap.put("i", List.of("i"));
    }
}