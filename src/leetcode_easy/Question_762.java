package leetcode_easy;

import java.util.HashSet;

public class Question_762 {



    private int bitsCount(int i) {
        int count = 0;
        while (i > 0) {
            int lsb = (i & 1);
            if (lsb == 1) {
                count++;
            }
            i = i >> 1;
        }
        return count;
    }

    public int countPrimeSetBits(int L, int R) {

        HashSet<Integer> primeSet = new HashSet<>();
        primeSet.add(2);
        primeSet.add(3);
        primeSet.add(5);
        primeSet.add(7);
        primeSet.add(11);
        primeSet.add(13);
        primeSet.add(17);
        primeSet.add(19);

        int count = 0;
        for (int i = L; i <= R; i++) {
            int ones = bitsCount(i);
            if (primeSet.contains(ones)) {
                count++;
            }
        }
        return count;
    }

    public void solve() {
        System.out.println(countPrimeSetBits(10, 15));;

    }

}
