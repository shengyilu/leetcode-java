package leetcode_easy;

import java.util.Arrays;

public class Question_821 {

    public int[] shortestToChar(String S, char C) {
        int[] buckets = new int[S.length()];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = Integer.MAX_VALUE;
        }

        int index = 0;

        while (index < S.length()) {
            System.out.println("index" + index);
            if (S.charAt(index) != C) {
                index++;
            } else {
                buckets[index] = 0;

                int leftIndex = index - 1;
                while (leftIndex >= 0) {
                    System.out.println("leftIndex" + leftIndex);
                    if (S.charAt(leftIndex) == C) {
                        break;
                    } else {
                        int diff = Math.abs(index - leftIndex);
                        if (buckets[leftIndex] > diff) {
                            buckets[leftIndex] = diff;
                        }
                    }
                    leftIndex--;
                }

                int rightIndex = index + 1;
                while (rightIndex < S.length()) {
                    if (S.charAt(rightIndex) == C) {
                        index = rightIndex;
                        break;
                    } else {
                        int diff = Math.abs(index - rightIndex);
                        if (buckets[rightIndex] > diff) {
                            buckets[rightIndex] = diff;
                        }
                    }
                    rightIndex++;
                }

                if (rightIndex == S.length()) {
                    break;
                }
            }

        }

        return buckets;
    }

    public void solve() {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(shortestToChar(S, C)));

    }
}
