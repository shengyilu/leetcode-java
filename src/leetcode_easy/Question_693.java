package leetcode_easy;

public class Question_693 {

    public boolean hasAlternatingBits(int n) {
        boolean hasAlternatingBits = true;
        int expect_lsb = ((1 & n) == 1) ? 0 : 1;
        n = n >> 1;
        while (n > 0) {
            int lsb = 1 & n;
            if (expect_lsb != lsb) {
                hasAlternatingBits = false;
                break;
            }
            expect_lsb = ((1 & n) == 1) ? 0 : 1;
            n = n >> 1;
        }


        return hasAlternatingBits;
    }

    public void solve() {
        System.out.println(hasAlternatingBits(10));

    }
}
