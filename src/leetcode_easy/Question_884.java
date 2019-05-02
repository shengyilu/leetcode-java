package leetcode_easy;

//884. Uncommon Words from Two Sentences

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question_884 {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordMap = new HashMap<>();

        String[] aArray = A.split(" ");
        for (String str : aArray) {
            if (!wordMap.containsKey(str)) {
                wordMap.put(str, 1);
            } else {
                int count = wordMap.get(str);
                wordMap.put(str, count + 1);
            }
        }

        String[] bArray = B.split(" ");
        for (String str : bArray) {
            if (!wordMap.containsKey(str)) {
                wordMap.put(str, 1);
            } else {
                int count = wordMap.get(str);
                wordMap.put(str, count + 1);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        String[] uncommonArray = new String[result.size()];
        Iterator it = wordMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((int) pair.getValue() == 1) {
                result.add((String) pair.getKey());
            }
        }

        return result.toArray(uncommonArray);
    }

    public void solve() {

        String A = "this apple is sweet";
        String B = "this apple is sour";

        String[] ans = uncommonFromSentences(A, B);
        for (String str : ans) {
            System.out.println(str);
        }

    }
}
