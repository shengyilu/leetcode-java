package leetcode_easy;

import java.util.Arrays;
import java.util.HashSet;

public class Question_804 {


    public int uniqueMorseRepresentations(String[] words) {


        HashSet<String> unique = new HashSet<>();String[] morseCodes =
                {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) {
                int index = 0;
                if (c >= 'a' && c <= 'z') {
                    index = c - 'a';
                } else {
                    index = c - 'A';
                }
                sb.append(morseCodes[index]);
            }
            unique.add(sb.toString());
        }

        return unique.size();
    }

    public void solve() {
        String[] input = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(input));
    }
}