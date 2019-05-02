package leetcode_easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question_933 {


    LinkedList<Integer> queue = new LinkedList<>();

    public int ping(int t) {

        queue.add(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }


}
