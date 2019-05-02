package leetcode_easy;

public class Question_557 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = strs[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                sb.append(chars[j]);
            }
            result.append(sb.toString());
            if (i < strs.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public void solve() {
        String input = "Let's take LeetCode contest";
        System.out.println(reverseWords(input));
    }
}
