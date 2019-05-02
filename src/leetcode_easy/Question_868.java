package leetcode_easy;

public class Question_868 {

    public int binaryGap(int N) {

        int one_count = 0;
        int longest_distance = 0;
        int distance = -1;
        while (N > 0) {
            int lsb = N & 1;
            if (lsb == 1) {
                one_count++;
                distance++;
                if (one_count == 2) {
                    one_count = 1;
                    if (longest_distance < distance) {
                        longest_distance = distance;
                    }
                    distance = 0;
                }
            }

            if (lsb == 0) {
                if (one_count == 1) {
                    distance++;
                }
            }

            N = N >> 1;
        }

        return longest_distance;
    }

    public void solve() {
        System.out.println(binaryGap(8));

    }
}
