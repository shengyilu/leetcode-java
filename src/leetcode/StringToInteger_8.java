package leetcode;

public class StringToInteger_8 {

    private String extractNumeric(String s) {
        int numericLen = 0;
        int startIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (startIndex == -1) {
                    startIndex = i;
                }
                numericLen++;
            } else {
                if (c == '+' || c == '-') {
                    if (startIndex == -1) {
                        startIndex = i;
                        numericLen++;
                        continue;
                    } else {
                        numericLen++;
                    }
                }

                if (c == ' ') {
                    if (startIndex == -1) {
                        continue;
                    } else {
                        numericLen++;
                    }
                }
            }
        }
        System.out.println("numericLen:" + numericLen);
        if (numericLen == 0) {
            return "";
        }
        return s.substring(startIndex, startIndex + numericLen);
    }


    public int myAtoi(String str) {
        String numberStr = extractNumeric(str);
        System.out.println("numberStr:" + numberStr);
        boolean isNegtive = false;
        int startIndex = 0;
        if (numberStr.length() > 0) {
            if (numberStr.charAt(0) == '+') {
                isNegtive = false;
                startIndex++;
            } else if (numberStr.charAt(0) == '-') {
                isNegtive = true;
                startIndex++;
            }
        }

        int result = 0;
        for (int i = startIndex; i < numberStr.length(); i++) {
            int value = isNegtive ? -1 * (numberStr.charAt(i) - '0') : (numberStr.charAt(i) - '0');
            if (result > Integer.MAX_VALUE / 10 || ((result == Integer.MAX_VALUE / 10) &&  value > 7)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || ((result == Integer.MIN_VALUE / 10) &&  value < -8)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + value;
        }
        return result;
    }

    public void solve() {
        int result = myAtoi("    +- 123");
        System.out.println("result:" + result);
    }



}
