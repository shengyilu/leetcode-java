package leetcode_easy;

public class Question_476 {

    public int findComplement(int num) {
        int temp = 1;

        while (temp < num) {
            temp = temp << 1 | 1;
        }
        return temp^num;
    }

    public void solve() {
        System.out.println(findComplement(Integer.MAX_VALUE-1));

    }

}

