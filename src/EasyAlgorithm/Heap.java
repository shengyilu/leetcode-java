package EasyAlgorithm;

import java.util.Arrays;

public class Heap {
    private int[] data = new int[] {99, 5, 36, 7, 22, 17, 92, 12, 2, 19, 25, 28, 1, 46};
    private int[] minHeap;

    public Heap() {
        createMinHeap();
    }

    private void createMinHeap() {
        minHeap = new int[data.length];

        for (int i = data.length / 2; i >= 1; i --) {
            shiftDown(i);
        }

        System.out.println("Answer:" + Arrays.toString(data));
    }


    // 讓大的數字往下沉到底
    private void shiftDown(int index) {
        System.out.println("index:" + index);

        int t_small;
        boolean isContinued = true;

        while (index * 2 <= data.length && isContinued) {

            if (data[index-1] > data[index * 2 - 1]) {
                t_small = index * 2;
            } else {
                t_small = index;
            }

            if ((index * 2) + 1 <= data.length) {
                if (data[t_small-1] > data[index * 2 + 1 - 1]) {
                    t_small = index * 2 + 1;
                }
            }

            if (t_small != index) {
                swap(index - 1, t_small - 1);
                index = t_small;
            } else {
                isContinued = false;
            }
        }

    }

    private void swap(int parent, int child) {
        int temp = data[parent];
        data[parent] = data[child];
        data[child] = temp;
    }

}
