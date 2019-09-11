/**
 * Nth-Tribonacci Number
 *
 * Given n, return the value of Tn.
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Constraints: 0 <= n <= 37 & the answer is guaranteed to fit within a 32-bit integer aka answer <= 2^31 - 1
 *
 * e.g. IN: n = 4, OUT: 4 => Explanation: T4 = 1 + 1 + 2 = 4
 * e.g. IN: n = 25, OUT: 1389537
 *
 * tags: Dynamic programmming
 *
 */

class Tri {
    private int n = 38;
    public int[] nums = new int[n];

    Tri(){
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i < n; ++i){
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
    }
}

public class NthTribonacci {
    public static void main(String[] args){
        System.out.println("Final Solution: " + new NthTribonacci().tribonacci(4));
        System.out.println("Space-optimized only: " + new NthTribonacci().tribonacciInitial(4));
    }

    // Complexity: O(1) time & constant space
    public int tribonacci(int n) {
        Tri t = new Tri();

        return t.nums[n];
    }

    // Complexity: O(n) time & constant space
    public int tribonacciInitial(int n) {
        if (n < 3) return n == 0 ? 0 : 1;

        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

}



