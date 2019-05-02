package leetcode;

import java.util.Arrays;

public class pow_50 {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }


    public double pow(double x, int n) {
        if (n == 0) return 1;

        double value = pow(x, n/2);

        if (n % 2 == 0) {
            return value * value;
        } else {
            return x * value * value;
        }
    }

    public void solve() {

        System.out.println("result:" + myPow(2, 3));
    }


}
