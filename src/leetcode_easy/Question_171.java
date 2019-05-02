package leetcode_easy;

public class Question_171 {
    public int titleToNumber(String s) {
        int value = 0;
        int pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int number = s.charAt(i) - 'A' + 1;
            value += Math.pow(26, pow) * number;
            pow++;
        }
        return value;
    }

    public void solve() {
        System.out.println(titleToNumber("ZY"));

    }

}
