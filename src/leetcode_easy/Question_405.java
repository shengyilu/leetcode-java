package leetcode_easy;

import java.util.Stack;

public class Question_405 {


    public String toHex(int num) {

        Stack<Integer> hexStack = new Stack<>();

        do {
            int shiftValue = num & 15;
            hexStack.push(shiftValue);
            num = num >>> 4;
        } while (num > 0);

        StringBuilder sb = new StringBuilder();
        while (!hexStack.isEmpty()) {
            int number = hexStack.pop();
            if (number >= 10) {
                sb.append((char) ('a' + number - 10));
            } else {
                sb.append(number);
            }
        }

        return sb.toString();
    }

    public void solve() {

        int a = -1;

        a = a >>> 4;
        System.out.println(a);

        a = a >>> 4;
        System.out.println(a);

        System.out.println(toHex(a));
    }
}
