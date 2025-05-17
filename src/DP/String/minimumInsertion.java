package DP.String;

import static DP.String.LongestPalindromic.longestPalindromeSubsequence;

public class minimumInsertion {
    public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
    }

    private static int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromeSubsequence(s);
        return n - k;
    }
}
