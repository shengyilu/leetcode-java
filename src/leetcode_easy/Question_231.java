package leetcode_easy;

public class Question_231 {

    // Time Limit Exceeded
    public boolean isPowerOfTwo(int n) {
        while (n != 1 && n % 2 == 0) {
            n /= 2;
        }

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        if (((n-1) & n) == 0) {
            return true;
        }
        return false;
    }

    public void solve() {

        System.out.println(isPowerOfTwo2(8));
    }
}
