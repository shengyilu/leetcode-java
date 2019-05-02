package leetcode_easy;

public class Question_744 {

    public char nextGreatestLetter(char[] letters, char target) {

        char ans = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                ans = letters[i];
                break;
            }
        }
        if (ans == 0) {
            ans = letters[0];
        }
        return ans;
    }

    public void solve() {
        char[] input = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(input, 'j'));

    }
}
