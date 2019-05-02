package leetcode_easy;

import java.util.HashSet;

public class Question_824 {

    private String wordTransfrom(String word, int index) {
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        char firstLetter = word.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z') {
            firstLetter = (char) (firstLetter - 'A' + 'a');
        }


        StringBuilder sb = new StringBuilder();
        if (!vowelSet.contains(firstLetter)) {
            sb.append(word.substring(1, word.length()));
            sb.append(word.charAt(0));
        } else {
            char[] wordArray = word.toCharArray();
            sb.append(wordArray);
        }

        sb.append("ma");
        for (int i = 0; i < index; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    public String toGoatLatin(String S) {
        String[] splits = S.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String word = wordTransfrom(splits[i], i + 1);
            sb.append(word);
            if (i != splits.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void solve() {
        String input = "The quick brown fox jumped over the lazy dog";

        System.out.println(toGoatLatin(input));


    }
}
