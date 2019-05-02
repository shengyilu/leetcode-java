package EasyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SoociiExamQ1 {

    private Stack<Integer> transformInt(int number) {
        List<Integer> intList = new ArrayList<>();

        while (number > 0) {
            int remain = number % 10;
            intList.add(remain);
            number /= 10;
        }

        Stack<Integer> aStack = new Stack<>();
        for (Integer value : intList) {
            aStack.push(value);
        }

        return aStack;
    }

    public int zipTwoNumber(int a, int b) {
        Stack<Integer> aStack = transformInt(a);
        Stack<Integer> bStack = transformInt(b);

        int lenth = aStack.size() + bStack.size();
        int result = 0;
        for (int i = 0; i < lenth; i++) {
            if (i % 2 == 0) {
                if (aStack.size() > 0) {
                    result = result * 10 + aStack.pop();
                } else if (bStack.size() > 0) {
                    result = result * 10 + bStack.pop();
                }
            } else {
                if (bStack.size() > 0) {
                    result = result * 10 + bStack.pop();
                } else if (aStack.size() > 0) {
                    result = result * 10 + aStack.pop();
                }
            }
        }

        return result;
    }


    public void solve() {

        int a = 1234;
        int b = 567;

        int c = zipTwoNumber(a, b);
        System.out.println(c);
    }
}
