/**
 * Multiply Strings
 *
 * Given two non-negative integers represented as strings, return the product of the inputs in string form.
 *
 * e.g.
 * IN: num1 = "2", num2 = "3"           OUT: "6"
 * IN: num1 = "123", num2 = "456"       OUT: "56088"
 *
 * Complexity: O(n * m) time where n and m are string lengths of the inputs
 *
 * Logic: num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]
 */

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) { sb.append(p); }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2", "3"));
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
