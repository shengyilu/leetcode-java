package BasicAlgorithm;

public class MergeSort {


    private void sort(int[] target) {
        int length = target.length;
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] leftArray = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = target[i];
        }
        for (int i = 0; i < mid; i++) {
            System.out.print(leftArray[i]);
            System.out.print(",");
        }
        System.out.println("");
        System.out.println("-----");


        int[] rightArray = new int[length-mid];
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = target[i];
        }
        for (int i = 0; i <= rightArray.length - 1; i++) {
            System.out.print(rightArray[i]);
            System.out.print(",");
        }
        System.out.println("");
        System.out.println("-----");

        sort(leftArray);
        sort(rightArray);

        merge(target, leftArray, rightArray);

    }

    private void merge(int[] target, int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int leftStep = 0, rightStep = 0, targetStep = 0;
        while (leftStep < leftLen && rightStep < rightLen) {
            if (left[leftStep] < right[rightStep]) {
                target[targetStep++] = left[leftStep++];
            } else {
                target[targetStep++] = right[rightStep++];
            }
        }

        while (leftStep < leftLen) {
            target[targetStep++] = left[leftStep++];
        }

        while (rightStep < rightLen) {
            target[targetStep++] = right[rightStep++];
        }

        System.out.println("--- Merge ---");
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i]);
            System.out.print(",");
        }
        System.out.println("");
        System.out.println("-----");
    }

    public void solve() {
        int[] target = {7, 2, 4, 1, 8 , 3, 9, 7, 6, 22, 11};
        sort(target);

    }
}
