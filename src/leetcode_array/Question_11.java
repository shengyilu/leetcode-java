package leetcode_array;

import leetcode_dfs.Question_98;

public class Question_11 {


    public int maxArea(int[] height) {

        int head = 0;
        int tail = height.length - 1;

        int maxArea = 0;
        while (head < tail) {
            int distance = tail - head;
            maxArea = Math.max(Math.min(height[head], height[tail]) * distance, maxArea);

            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;

    }

    public void solve() {

        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println("MaxArea:" + maxArea(input));


    }

}
