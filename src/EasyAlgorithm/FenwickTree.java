package EasyAlgorithm;

import java.util.Arrays;

public class FenwickTree {

    private int BIT[];               // Binary Indexed Tree = Fenwick Tree
    private int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public FenwickTree() {
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            init(i + 1, nums[i]);
        }
        System.out.println("[Edward] BIT:" + Arrays.toString(BIT));
    }

    private void init(int i, int val) {
        System.out.println("i:" + i);
        while(i < BIT.length) {
            BIT[i] += val;
            i = i + (i & -i);
        }
    }

    public void sum(int index) {

        while (index > 0) {
            System.out.println("[Edward] BIT[" + index +"] = " + BIT[index]);
            int value = BIT[index];
            index = index - (index & -index);

        }

        int test = 0;
        for (int i = 1; i <= 10; i++ ) {
            test += i;
        }
        System.out.println("[Edward] test = " + test);

    }
}
