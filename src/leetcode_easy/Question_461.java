package leetcode_easy;

import java.util.Arrays;

public class Question_461 {

    public int hammingDistance(int x, int y) {
        int hd = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                hd++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }

        return hd;
    }

    public void solve() {

        int x = 4;
        int y = 1;

        System.out.println("x ^ y:" + (x ^ y));

        System.out.println("hammingDistance:" + hammingDistance(x, y));

    }
}
