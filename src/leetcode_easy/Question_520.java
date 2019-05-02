package leetcode_easy;

public class Question_520 {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        int len = word.length();
        if (len == 1) {
            return true;
        }

        boolean result = true;
        int expectUpperCount = 0;
        if (len > 1) {
            if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
                expectUpperCount = len - 2;
                int count = 0;
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        count++;
                        if (count < expectUpperCount) {
                            result = false;
                        }
                    }
                }
            } else if(Character.isUpperCase(word.charAt(0)) && !Character.isUpperCase(word.charAt(1))) {
                expectUpperCount = 0;
                int count = 0;
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        count++;
                        if (count > expectUpperCount) {
                            result = false;
                            break;
                        }
                    }
                }
            } else {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        count++;
                        if (count > 0) {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }

        return result;

    }

    public void solve() {
        System.out.println(detectCapitalUse("aAd"));
    }
}
