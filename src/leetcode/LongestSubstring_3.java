package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        boolean[] exist = new boolean[256];
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            System.out.println("s.charAt(j):" + s.charAt(j));
            while(exist[s.charAt(j)]) {
                System.out.println("i:" + i + ", s.charAt(i):" + s.charAt(i));
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public void solve() {
        String test = "pwwkew";

        int len = lengthOfLongestSubstring(test);
        System.out.println("len:" + len);

    }
}
