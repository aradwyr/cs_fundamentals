/**
 * Sum of Two Integers
 *
 * Calculate the sum of two integers a and b (not allowed to use the operators + and -).
 *
 * Bit operations: AND(&) to mimic carries, XOR(^) to mimic actual addition, left shift operator(<<) to allow carries
 * to be brought one position over to the left
 */

public class SumOfInts {

    public static void main(String[] args) {
        System.out.println(new SumOfInts().calcSum(2, 3));
    }

    public int calcSum(int a, int b) {
        while (b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
