package leetcode_easy;

public class Question_371 {

    public int getSum(int a, int b) {
        System.out.println("a: " + Integer.toBinaryString(a));
        System.out.println("b: " + Integer.toBinaryString(b));
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }

    public void printBinary(int a) {
        System.out.println(Integer.toBinaryString(a));
    }

    public void solve() {
        System.out.println(getSum(-2, 3));

        //System.out.println(Integer.toBinaryString(-2));
    }
}
