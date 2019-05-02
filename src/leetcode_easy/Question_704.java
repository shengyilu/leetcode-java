package leetcode_easy;

public class Question_704 {


    public int search(int[] nums, int target) {
        int len = nums.length;
        int answer = -1;
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int minIndex = 0;
        int maxIndex = len - 1;
        int halfIndex = len / 2;
        while (minIndex <= maxIndex) {
            System.out.println("halfIndex:" + halfIndex + ", minIndex:" + minIndex + ", maxIndex:" + maxIndex);
            if (nums[halfIndex] == target) {
                answer = halfIndex;
                break;
            }

            if (nums[halfIndex] > target) {
                maxIndex = halfIndex;
            } else {
                minIndex = halfIndex;
            }
            int shift = (maxIndex - minIndex) / 2;
            if (shift == 0) {
                if (nums[minIndex] == target) {
                    answer = minIndex;
                    break;
                }
                if (nums[maxIndex] == target) {
                    answer = maxIndex;
                    break;
                }
                break;
            }
            halfIndex = minIndex + shift;

        }
        return answer;
    }

    public void solve() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        System.out.println(search(nums, target));

    }
}
