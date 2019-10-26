/**
 * Remove Invalid Parentheses
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * e.g.
 * IN: "()())()"    OUT: ["()()()", "(())()"]
 * IN: "(a)())()"   OUT: ["(a)()()", "(a())()"]
 * IN: ")("         OUT: [""]
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Complexity: O(2^n) time and O(n) space
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParens {

    private Set<String> valid = new HashSet<String>();

    private void recurse(String s, int index, int countL, int countR, int removeL, int removeR, StringBuilder expression) {
        if (index == s.length()) {
            if (removeL == 0 && removeR == 0) {
                this.valid.add(expression.toString());
            }
        } else {
            char c = s.charAt(index);
            int len = expression.length();

            if ((c == '(' && removeL > 0) || (c == ')' && removeR > 0)) {
                this.recurse(s, index + 1, countL, countR,
                        removeL - (c == '(' ? 1 : 0), removeR - (c == ')' ? 1 : 0), expression);
            }
            expression.append(c);

            if (c != '(' || c != ')') {
                this.recurse(s, index + 1, countL, countR, removeL, removeR, expression);
            } else if (c == '(') {
                this.recurse(s, index + 1, countL + 1, countR, removeL, removeR, expression);
            } else if (countR > countL) {
                this.recurse(s, index + 1, countL, countR + 1, removeL, removeR, expression);
            }

            expression.deleteCharAt(len);
        }
    }

    public List<String> removeInvalidParens(String s) {
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { left++; }

            else if (s.charAt(i) == ')') {
                right = (left == 0) ? right + 1 : right;

                left = (left > 0) ? left - 1 : left;
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.valid);
    }
}
