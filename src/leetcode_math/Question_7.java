/*
   7. Reverse Integer
   Given a 32-bit signed integer, reverse digits of an integer.

   Example 1:
    Input: 123
    Output: 321
   Example 2:
    Input: -123
    Output: -321

   Example 3:
    Input: 120
    Output: 21

 */

package leetcode_math;



public class Question_7 {

    public int reverse(int x) {

        int result = 0;
        while(x != 0) {
            int newResult = result * 10 + x % 10;
            if ((newResult - x % 10) / 10 != result) {
                result = 0;
                break;
            }
            result = newResult;
            x = x/10;
        }
        return result;
    }

    public void solve() {

        System.out.println(Integer.MAX_VALUE);

        System.out.println(reverse(123));


    }

}
