/**
 * Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * e.g.
 * IN: 1        OUT: true               // 2^0 = 1
 * IN: 16       OUT: true               // 2^4 = 16
 * IN: 218      OUT: false
 *
 * Complexity: O(1) time and space
 *
 * Strategy:
 * A power of two in binary representation is one 1-bit, followed by some zeros:
 * 1 in binary = 00000001
 * 2 in binary = 00000010
 * 4 in binary = 00000100
 * 8 in binary = 00001000       etc., etc.
 *
 * A number that's not a power of two will have more than one 1-bit in its binary representation:
 * 3 in binary = 00000011
 * 5 in binary = 00000101
 * 6 in binary = 00000110       etc., etc.
 *
 *
 * (x & (x -1)) sets the rightmost 1-bit of x to zero
 * Say x = 6 or in binary        0 1 1 0
 * x - 1 aka 5 in binary         0 1 0 1
 *                             & --------
 *                               0 1 0 0         // not 0 0 0 0 so input x = 6 not a power of two
 *
 * Say x = 4 or in binary        0 1 0 0
 * x - 1 aka 3 in binary         0 0 1 1
 *                             & --------
 *                               0 0 0 0        // zero so input x = 4 is a power of two
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(16));
        System.out.println(new PowerOfTwo().isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int num) {
        if (num == 0) return false;

        long x = (long) num;                                // to avoid an overflow for the case of -2147483648

        return (x & (x - 1)) == 0;
    }
}


