/**
 * Basic Calculator
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * e.g.
 * IN: " 2-1 + 2 ", OUT: 3
 * IN: "(1+(4+5+2)-3)+(6+8)", OUT: 23
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces
 *
 * Note: You may assume that the given expression is always valid. Do not use the eval built-in library function.
 *
 * Complexity: O(n) time and space
 */

import java.util.Arrays;
import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate(" 5-1 + (6-3) "));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0, result = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { operand = operand * 10 + (int)(ch - '0'); }

            else if (ch == '+') {
                result += sign * operand;
                System.out.println("post-addition: " + result);
                sign = 1;
                operand = 0;
            }

            else if (ch == '-') {
                result += sign * operand;
                System.out.println("post-subtraction: " + result);
                sign = -1;
                operand = 0;
            }

            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                System.out.println("curr stack: " + Arrays.toString(stack.toArray()));
                sign = 1;
                result = 0;
            }

            else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();          // multiply the sign
                result += stack.pop();          // add the prev result
                operand = 0;                    // reset
            }
        }
        return result + (sign * operand);
    }
}
