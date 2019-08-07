/**
 * Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * <p>e.g. n = 4, k = 2 combinations are:
 *
 * <p>[ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), k, 1, n - k + 1);
        return result;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int remainingK, int from, int to) {
        if (remainingK == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = from; i <= to; ++i) {
            list.add(i);
            dfs(res, list, remainingK - 1, i + 1, to + 1);
            list.remove(list.size() - 1);
        }
    }
}
