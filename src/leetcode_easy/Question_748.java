package leetcode_easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question_748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] buckets = new int[26];
        String targetStr = licensePlate.toLowerCase();
        for (char c : targetStr.toCharArray()) {
            if (Character.isLetter(c)) {
                buckets[c - 'a']++;
            }
        }

        String ans = "";
        int shortestLength = Integer.MAX_VALUE;
        for (String str : words) {
            if (compare(str, buckets)) {
                if (shortestLength > str.length()) {
                    shortestLength = str.length();
                    ans = str;
                }
            }
        }

        return ans;
    }

    private boolean compare(String str, int[] buckets) {
        int[] charBags = new int[26];
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                charBags[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charBags[i] < buckets[i]) {
                return false;
            }
        }
        return true;
    }

    public void solve() {

        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};


        System.out.println(shortestCompletingWord(licensePlate, words));
    }
}
