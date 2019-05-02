package leetcode_easy;

public class Question_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutiveOnes = 0;
        int maxConsecutiveOnes = 0;
        for (int value : nums) {
            if (value == 1) {
                consecutiveOnes++;
                if (maxConsecutiveOnes < consecutiveOnes) {
                    maxConsecutiveOnes = consecutiveOnes;
                }
            } else {
                consecutiveOnes = 0;
            }
        }
        return maxConsecutiveOnes;
    }

    public void solve() {

        int[] input = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(input));
    }
}
