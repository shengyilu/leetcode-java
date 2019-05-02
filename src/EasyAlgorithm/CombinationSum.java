package EasyAlgorithm;

public class CombinationSum {

    int solutionCount = 0;
    int[] usedCards = new int[10];
    int[] slot = new int[9];

    private void dfs(int step) {
        if (step == 9) {
            int left = (100 * slot[0] + 10 * slot[1] + slot[2]) + (100 * slot[3] + 10 * slot[4] + slot[5]);
            int right = 100 * slot[6] + 10 * slot[7] + slot[8];

            if (left == right) {
                solutionCount++;
            }
            return;
        }

        for (int cardNum = 1; cardNum <= 9; cardNum++) {
            if (usedCards[cardNum] == 0) {
                slot[step] = cardNum;
                usedCards[cardNum]++;
                dfs(step+1);
                usedCards[cardNum] = 0;
            }
        }
    }

    public void search() {
        dfs(0);
        System.out.println("Answer:" + solutionCount/2);
    }

}
