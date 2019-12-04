/**
 * Long Pressed Name
 *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long
 * pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
 * with some characters (possibly none) being long pressed.
 *
 * e.g.
 * IN: name = "alex", typed = "aaleex"      OUT: true
 * IN: name = "saeed", typed = "ssaaedd"    OUT: false
 * IN: name = "leelee", typed = "lleeelee"  OUT: true
 * IN: name = "laiden", typed = "laiden"    OUT: true               // It's not necessary to long press any character.
 *
 * Complexity: O(n) time and O(1) space
 */

public class LongPressed {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;

        for (int j = 0; j < typed.length(); j++) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) { i++; }
            else if (i > 0 && typed.charAt(j) != name.charAt(i - 1)) { return false; }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongPressed().isLongPressedName("alex", "aaleex"));
        System.out.println(new LongPressed().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new LongPressed().isLongPressedName("laiden", "laiden"));
    }
}
