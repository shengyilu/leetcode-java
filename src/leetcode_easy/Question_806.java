package leetcode_easy;

public class Question_806 {

    public int[] numberOfLines(int[] widths, String S) {

        int line = 1;
        int totalLenth = 0;
        for (char c : S.toCharArray()) {
            int i = c - 'a';
            totalLenth += widths[i];
            if (totalLenth > 100) {
                line++;
                totalLenth = widths[i];
            }
        }
        return new int[]{line, totalLenth};
    }

    public void solve() {
        int[] width = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";

        int[] ans = numberOfLines(width, S);
        System.out.println("ans[0]:" + ans[0] + ", ans[1]:" + ans[1]);

    }
}
