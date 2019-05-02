package leetcode_easy;

import java.util.Arrays;

public class Question_709 {

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c - 'A' + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void solve() {
        System.out.println(toLowerCase("LOVELY"));
    }
}
