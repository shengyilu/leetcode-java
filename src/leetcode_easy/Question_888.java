package leetcode_easy;

import java.util.*;

public class Question_888 {


    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> aSet = new HashSet();
        int A_size = 0;
        for (int a : A) {
            A_size += a;
            aSet.add(a);
        }
        HashSet<Integer> bSet = new HashSet();
        int B_size = 0;
        for (int b : B) {
            B_size += b;
            bSet.add(b);
        }

        int equal_size = (A_size + B_size) / 2;

        int[] answer = new int[2];

        Iterator it = aSet.iterator();
        while (it.hasNext()) {
             int value = (int) it.next();
             if (A_size - value >= equal_size) {
                 continue;
             }
             int swap_size = equal_size - (A_size - value);
             if (bSet.contains(swap_size)) {
                 if (B_size - swap_size + value == equal_size) {
                     answer[0] = value;
                     answer[1] = swap_size;
                     break;
                 }
             }
        }
        return answer;
    }

    public void solve() {
        int[] A = {1,2,5};
        int[] B = {2,4};
        System.out.println(Arrays.toString(fairCandySwap(A, B)));

    }
}
