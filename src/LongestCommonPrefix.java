/**
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * e.g. IN: ["flower","flow","flight"]  OUT: "fl"
 *
 * Note:
 * If there is no common prefix, return an empty string ""
 *
 * All given inputs are in lowercase letters a-z
 */

public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] arr = {"flower","flow","flight"};
        String[] arr2 = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr));
    }

    public String longestCommonPrefix(String[] s){
        if (s.length == 0) return "";

        String pre = s[0];

        for (int i = 1; i < s.length; i++){
            while (!s[i].startsWith(pre)){                       //Alt. while condition: s[i].indexOf(pre) != 0
                pre = pre.substring(0, pre.length()-1);
            }
        }
        return pre;
    }
}

//  i   | s[i]  | pre
//++++++|+++++++|++++++++
//  1   | flow  | flowe
//  1   | flow  | flow
//  2   | flight| flo
//  2   | flight| fl