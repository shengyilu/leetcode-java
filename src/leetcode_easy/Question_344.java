package leetcode_easy;

public class Question_344 {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cArray = s.toCharArray();

        for (int i = cArray.length - 1; i >= 0; i--) {
            sb.append(cArray[i]);
        }

        return sb.toString();
    }

    public void solve() {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));

    }
}
