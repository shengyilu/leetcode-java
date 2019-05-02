package leetcode;

public class ZigZag_6 {



    public String convert(String s, int numRows) {
        int charsInLvel = numRows + (numRows - 2);
        if (charsInLvel == 0) {
            return s;
        }
        int levels = (s.length() % charsInLvel == 0) ?  (s.length() / charsInLvel) : (s.length() / charsInLvel + 1);
        boolean[] buckets = new boolean[s.length()];

        StringBuffer sb = new StringBuffer();
        int row = 0;
        while (row < numRows) {
            for (int l = 0; l < levels; l++) {
                int index_1 = row + (l*charsInLvel);
                int index_2 = (l*charsInLvel) + charsInLvel - row;
                if (index_1 < s.length()) {
                    if (!buckets[index_1]) {
                        buckets[index_1] = true;
                        sb.append(s.charAt(index_1));
                        System.out.println(index_1 + ", " + s.charAt(index_1));
                    }
                }

                if (index_2 < s.length()) {
                    if (!buckets[index_2]) {
                        buckets[index_2] = true;
                        sb.append(s.charAt(index_2));
                        System.out.println(index_2 + ", " + s.charAt(index_2));
                    }
                }
            }
            row++;
        }

        return sb.toString();
    }

    public void solve() {
        String result = convert("PAYPALISHIRING", 4);
        System.out.println("result:" + result);

        System.out.println(Math.pow(2, 31));

    }

}
