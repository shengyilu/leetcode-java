package leetcode_easy;

public class Question_917 {

    private boolean isChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public String reverseOnlyLetters(String S) {
        int endIndex = S.length() - 1;
        char[] reversedString = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (isChar(c)) {
                while (!isChar(S.charAt(endIndex))) {
                    endIndex--;
                }
                reversedString[i] = S.charAt(endIndex);
                reversedString[endIndex] = c;
                endIndex--;
            } else {
                reversedString[i] = c;
            }
        }
        return String.valueOf(reversedString);
    }

    public void solve() {
        String input = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(input));
    }

}
