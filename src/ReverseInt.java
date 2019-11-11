/**
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note: (aka not able to use 64 bit long-type)
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * e.g.
 * IN: 123          OUT: 321
 * IN: 120          OUT: 21
 * IN: -123         OUT: -321
 *
 * Strategy:
 * Continually pop the last digit off the input and push onto the output variable
 *
 * N.B.
 * INT_MAX is  2147483647
 * INT_MIN is -2147483648
 *
 * Complexity: O(log n) time and O(1) space
 */

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(new ReverseInt().reverseInt(123));
        System.out.println(new ReverseInt().reverseInt(120));
        System.out.println(new ReverseInt().reverseInt(-123));
    }

    public int reverseInt(int num) {
        int res = 0;

        while (num != 0) {
            int pop = num % 10;
            num /= 10;

            // handling int overflow cases
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) { return 0; }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8)) { return 0; }

            res = res * 10 + pop;
        }
        return res;
    }
}

/*
If able to use long:

 public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) { return 0; }
        else { return (int)res; }
    }
 */