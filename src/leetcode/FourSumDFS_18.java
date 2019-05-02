package leetcode;

import java.util.*;

public class FourSumDFS_18 {


    private HashMap<Integer, HashMap> solutionTree = new HashMap<>();
    private int[] nums;
    private int[] usedNums;
    private int target = 0;
    private Integer[] buckets = new Integer[4];
    private List<List<Integer>> results = new ArrayList<>();

    private void dfs(int steps) {

        if (steps == 4) {
            int sum = 0;
            for (int i = 0; i < steps; i++) {
                sum += buckets[i];
            }
            if (sum == target) {
                List<Integer> result = new ArrayList<>(Arrays.asList(buckets));
                results.add(result);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (usedNums[i] == 0) {
                //System.out.println(" steps[" + steps+ "]:" +  nums[i]);
                buckets[steps] =  nums[i];
                usedNums[i] = 1 ;
                dfs(steps + 1);
                usedNums[i] = 0;
            }

        }
        //System.out.println("steps:" + steps);

    }

    private boolean addTree(Integer[] buckets, int offset, HashMap<Integer, HashMap> node, boolean isNew) {
        if (offset == buckets.length) {
            return isNew;
        }
        boolean isAdded = false;
        if (!node.containsKey(buckets[offset])) {
            node.put(buckets[offset], new HashMap<Integer, HashMap>());
            isAdded = true;
        }
        HashMap<Integer, HashMap> leaf = node.get(buckets[offset]);
        offset++;
        return addTree(buckets, offset, leaf, isAdded);
    }

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        nums = numbers;
        usedNums = new int[numbers.length];
        this.target = target;
        dfs(0);

        List<List<Integer>> answers = new ArrayList<>();
        for (List<Integer> temp : results) {
            Collections.sort(temp);
            if (addTree(temp.toArray(new Integer[temp.size()]), 0, solutionTree, false)) {
                answers.add(temp);
            }
            //System.out.println("Answer:" + Arrays.toString(temp.toArray()));
        }

        return answers;
    }

    public void solve() {
        //nums = new int[] {1,0,-1,0,-2,2};
        //nums = new int[] {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};

        nums = new int[] {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
        target = 6189;

        long startTime = System.nanoTime();
        List<List<Integer>> answers = fourSum(nums, target);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time:" + duration/1000000);


        for (List<Integer> temp : answers) {
            System.out.println("Answer:" + Arrays.toString(temp.toArray()));
        }
    }
}
