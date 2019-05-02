package leetcode_easy;

import java.util.*;

public class Question_500 {


    public String[] findWords(String[] words) {
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> keyboardMap = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            String row = keyboard[i];
            for (char c : row.toCharArray()) {
                keyboardMap.put(c, i);
            }
        }
        List<String> result = new ArrayList<>();

        for (String word : words) {
            int preRow = -1;
            boolean isSameRow = true;
            for (char c : word.toCharArray()) {
                char x = c;
                if (x >= 'A' && x <= 'Z') {
                    x = (char) (c - 'A' + 'a');
                }
                if (preRow == -1) {
                    preRow = keyboardMap.get(x);
                    continue;
                }
                int currentRow = keyboardMap.get(x);
                if (preRow != currentRow) {
                    isSameRow = false;
                    break;
                }
                preRow = currentRow;

            }
            if (isSameRow) {
                result.add(word);
            }
        }
        String[] ans = new String[result.size()];

        return result.toArray(ans);
    }

    public void solve() {
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        String[] ans = findWords(input);

        System.out.println(Arrays.toString(ans));

    }

}
