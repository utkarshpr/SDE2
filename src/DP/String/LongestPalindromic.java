package DP.String;

import static DP.String.LCSubsequence.lcs;

public class LongestPalindromic {
    public static void main(String args[]) {
        String s = "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }

    static int longestPalindromeSubsequence(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return lcs(s,reversed);
    }
}
