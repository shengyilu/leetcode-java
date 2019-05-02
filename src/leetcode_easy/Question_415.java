package leetcode_easy;

import java.util.Stack;

public class Question_415 {

    private int c2i(char c) {
        return c - '0';
    }

    public String addStrings(String num1, String num2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int maxLen = (num1.length() > num2.length()) ? num1.length() : num2.length();
        int index = 0;
        while (index < maxLen) {
            if (index < num1.length()) {
                stack1.push(c2i(num1.charAt(index)));
            }

            if (index < num2.length()) {
                stack2.push(c2i(num2.charAt(index)));
            }
            index++;
        }

        Stack<Integer> result = new Stack<>();
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int val1 = 0, val2 = 0;

            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }

            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }

            int sum = val1 + val2 + carry;
            if (sum / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(sum % 10);
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }

    public void solve() {

        System.out.println(addStrings("1", "9"));
    }
}
