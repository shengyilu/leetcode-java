package leetcode_easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question_819 {


    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String ban : banned) {
            bannedSet.add(ban);
        }

        int maxRepeatedCount = 0;
        String answer = "";
        Map<String, Integer> bags = new HashMap<>();
        int index = 0;
        while(index < paragraph.length()) {

            StringBuilder sb = new StringBuilder();
            boolean isCut = false;
            while (index < paragraph.length() && !isCut) {
                char c = paragraph.charAt(index);
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                } else if (c >= 'A' && c <= 'Z') {
                    sb.append((char) (c - 'A' + 'a'));
                } else {
                    //System.out.println((int)c);
                    isCut = true;
                }
                index++;
            }
            String word = sb.toString();
            if (word.isEmpty()) {
                continue;
            }
            //System.out.println(word);
            if (bannedSet.contains(word)) {
                continue;
            }
            if (bags.containsKey(word)) {
                int count = bags.get(word);
                bags.put(word, count+1);
                if (maxRepeatedCount < count + 1) {
                    maxRepeatedCount = count + 1;
                    answer = word;
                }
            } else {
                bags.put(word, 1);
                if (maxRepeatedCount == 0) {
                    maxRepeatedCount = 1;
                    answer = word;
                }
            }

        }
        return answer;
    }


    public void solve() {

        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};

        System.out.println(mostCommonWord(paragraph, banned));
    }
}
