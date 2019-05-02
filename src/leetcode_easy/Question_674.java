package leetcode_easy;

public class Question_674 {


    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int currentLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                currentLen++;
            } else {
                if (maxLen < currentLen) {
                    maxLen = currentLen;
                }
                currentLen = 1;
            }
        }

        if (maxLen < currentLen) {
            maxLen = currentLen;
        }

        return maxLen;
    }

    public void solve() {

        int[] input = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(input));
    }
}
