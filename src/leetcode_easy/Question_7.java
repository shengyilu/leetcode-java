package leetcode_easy;

public class Question_7 {


    public int reverse(int x) {

        int result = 0;

        int positive_last = Integer.MAX_VALUE % 10;
        int negtive_last = Integer.MIN_VALUE % 10;

        while(x != 0) {
            //System.out.println("remainder:" + x%10);
            int remain = x % 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && remain > positive_last))
                return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && remain < negtive_last))
                return 0;

            result = result * 10 + x % 10;
            x = x/10;
            //System.out.println("result:" + result);
        }
        return result;

    }

    public void solve() {
        //reverse(123456);
        System.out.println("result:" + reverse(10000));
    }
}
