package leetcode_easy;

public class Question_9 {


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int reversedNumber = 0;

        while (x/10 > reversedNumber) {
            int value = x % 10;
            reversedNumber = reversedNumber * 10 + value;
            x /= 10;
        }

        System.out.println("x:" + x + ", reversedNumber:" + reversedNumber);

        return reversedNumber == x || (reversedNumber == x/10 && x/10 > 0);
    }

    public void solve() {

        System.out.println("Result:" + isPalindrome(21120));
    }

}
