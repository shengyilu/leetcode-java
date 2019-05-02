package leetcode_easy;

public class Question_389 {

    public char findTheDifference(String s, String t) {
        int[] buckets = new int[26];

        for (char c : s.toCharArray()) {
            buckets[c - 'a']++;
        }

        char addChar = 0;
        for (char c : t.toCharArray()) {
            System.out.println(c);
            if (--buckets[c - 'a'] < 0) {
                addChar = c;
            }
        }
        return addChar;
    }

    public void solve() {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

}

