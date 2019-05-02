package leetcode_hashtable;

import java.util.*;

public class Question_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String wordKey = String.valueOf(sArray);

            if (anagramMap.containsKey(wordKey)) {
                List<String> bags = anagramMap.get(wordKey);
                bags.add(s);
            } else {
                List<String> bags = new ArrayList<>();
                bags.add(s);
                anagramMap.put(wordKey, bags);
            }
        }

        return new ArrayList<List<String>>(anagramMap.values());
    }

    public void solve() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> results = groupAnagrams(input);
        for (List<String> bags : results) {
            for (String s : bags) {
                System.out.println(s);
            }
            System.out.println("-------");
        }

    }
}
