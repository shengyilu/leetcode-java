package leetcode_easy;

public class Question_258 {


    public int addDigits(int num) {
        int total = num;
        while (total >= 10) {
            int sum = 0;
            int target = total;
            while (target > 0) {
                sum += (target % 10);
                target /= 10;
            }
            total = sum;
        }
        return total;
    }

    public void solve() {
        System.out.println(addDigits(38));
    }
}
