package leetcode_easy;

 /*
    You're given strings J representing the types of stones that are jewels,
    and S representing the stones you have.  Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.
    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/

import java.util.HashMap;

public class Question_771 {


    public int numJewelsInStones(String J, String S) {

        HashMap<Character, Integer> stoneMap = new HashMap<>();

        for (char s : S.toCharArray()) {
            if (stoneMap.containsKey(s)) {
                int count = stoneMap.get(s);
                stoneMap.put(s, ++count);
            } else {
                stoneMap.put(s, 1);
            }
        }
        int answer = 0;
        for (char j : J.toCharArray()) {
            if (stoneMap.containsKey(j)) {
                answer += stoneMap.get(j);
            }
        }

        return answer;
    }

    public int numJewelsInStones2(String J, String S) {

        int[] f = new int[128];
        for (final char c : J.toCharArray())
            f[c] = 1;
        int ans = 0;
        for (final char c : S.toCharArray())
            ans += f[c];
        return ans;
    }

    public void solve() {
        System.out.println("result:" + numJewelsInStones("dbd", "bbb"));
    }
}
