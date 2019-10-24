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

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0, result = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { operand = operand * 10 + (int)(ch -'0'); }

            else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            }

            else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            }

            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                operand = 0;
            }

            else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
