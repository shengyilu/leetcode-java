package leetcode_easy;

public class Question_70 {


    public int climbStairs(int n) {

        int count = 0;
        if (n % 2 == 1) {
            count++;
            n -= 1;
        }
        if (n > 0) {
            count += (n / 2 + 1);
        }
        return count;
    }

    public void solve() {
        System.out.println(climbStairs(3));

    }
}
