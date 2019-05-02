package leetcode;

/*
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */

import java.util.Arrays;
import java.util.List;

public class PalindromicSubstring_5 {

    private int searchPalindromic(String s, int left, int right) {

        int len = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        len = (right-1) - (left + 1) + 1;
        return len;
    }

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenOdd = searchPalindromic(s, i, i);
            int lenEven = searchPalindromic(s, i, i+1);
            int subLen = Math.max(lenEven, lenOdd);
            if (maxLen < subLen) {
                maxLen = subLen;
                System.out.println("i:" + i + ", maxLen:" + maxLen);
                start = i - (maxLen - 1) / 2;
                end = start + maxLen;
            }
        }
        String sub = s.substring(start, end);

        return sub;
    }

    public void solve() {

        String result = longestPalindrome("cbbd");

        System.out.println("result:" + result);
    }
}
