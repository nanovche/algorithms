package dhl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueriesTask {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        List<String> q = new ArrayList<>();
        s.add("bob and alice like to text each other");
        s.add("bob does not like to ski but does not like to fall");
        s.add("Alice likes to ski");
        q.add("bob alice");
        q.add("alice");
        q.add("like");
        q.add("no occurrence");
        System.out.println(textQueries(s,q));
    }

    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {

        List<List<Integer>> result = new ArrayList<>();
        for (String query: queries) {
            boolean noneMatches = true;
            int sentenceIndex = 0;
            List<Integer> currentQueryResForAllSentences = new ArrayList<>();
            for (String sentence: sentences) {
                    String queryInSentenceResult = queryInSentence(sentence, query);
                    if(queryInSentenceResult.charAt(0) == '1'){
                        noneMatches = false;
                        addCurrQueryRes(currentQueryResForAllSentences, sentenceIndex, Integer.parseInt(queryInSentenceResult.substring(1)));
                    }
                    sentenceIndex++;
            }

            if(noneMatches) {
                result.add(addQueryNotInAnySentence(new ArrayList<>()));
            } else {
                result.add(currentQueryResForAllSentences);
            }

        }
        return result;
    }
    static void addCurrQueryRes(List<Integer> currQueryRes, int sentenceIndex, int times) {
        for(int i = 1; i <= times; i++) {
            currQueryRes.add(sentenceIndex);
        }
    }
    static List<Integer> addQueryNotInAnySentence(List<Integer> currQueryRes) {
        int a;
        currQueryRes.add(-1);
        return currQueryRes;
    }
    static String queryInSentence(String sentence, String query) {

        boolean contains = true;
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int previousTimes = 0;
        for (String queryWord: query.split(" ")) {

            int timesInSentence = 0;
            for (String sentenceWord: sentence.split(" ")) {
                if(sentenceWord.equals(queryWord)){
                    map.put(queryWord, ++timesInSentence);
                    if(previousTimes == timesInSentence) {
                        break;
                    }
                }
            }

            if(map.get(queryWord) == null) {
                contains = false;
                result.append("0");
                break;
            } else {
                previousTimes = map.get(queryWord);
            }

        }

        if(contains) {
            result.append("1").append(previousTimes);
        }

        return result.toString();
    }

}

