/**
 * Subsets/Power set
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * e.g. nums = [1,2,3] has a solution subset of [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 * Time and Space Complexity: O(n * 2^n)
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subset(nums));
    }

    public List<List<Integer>> subset(int[] inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        generatePowerSet(result, new ArrayList<>(), inputSet,0);
        return result;
    }

    private void generatePowerSet(List<List<Integer>> result , List<Integer> path, int[] inputSet, int index){
        result.add(new ArrayList<>(path));

        for(int i = index; i < inputSet.length; i++){
            path.add(inputSet[i]);
            generatePowerSet(result, path, inputSet, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
