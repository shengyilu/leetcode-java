package BasicAlgorithm;

public class QuickSort {


    private void sort(int[] target, int leftMostIndex, int rightMostIndex) {
        if (leftMostIndex >= rightMostIndex) {
            return;
        }
        print(target, leftMostIndex, rightMostIndex);
        // Swap pivot value (left most index) with tail
        swap(target, leftMostIndex, rightMostIndex);

        int movingIndex = leftMostIndex;
        int step = 0;
        while (movingIndex < rightMostIndex) {
            if (movingIndex + step == rightMostIndex) {
                swap(target, movingIndex, rightMostIndex);
                break;
            }
            int tmp = target[movingIndex + step];
            if (tmp <= target[rightMostIndex]) {
                swap(target, movingIndex, movingIndex + step);
                step = 0;
                movingIndex++;
                continue;
            }
            step++;
        }

        print(target, leftMostIndex, rightMostIndex);

        sort(target, leftMostIndex, movingIndex - 1);
        sort(target, movingIndex + 1, rightMostIndex);
    }

    private void swap(int[] target, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int temp = target[leftIndex];
        target[leftIndex] = target[rightIndex];
        target[rightIndex] = temp;
    }

    private void print(int[] target, int leftIndex, int rightIndex) {
        System.out.println("-----------------------------------");
        for (int i = leftIndex; i <= rightIndex; i++) {
            System.out.print(target[i]);
            System.out.print(",");
        }
        System.out.println("");
    }

    public void solve() {
        int[] target = {7, 2, 4, 1, 8 , 3, 9, 7, 6, 22, 11};
        sort(target, 0, target.length - 1);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i]);
            System.out.print(",");
        }
    }
}
