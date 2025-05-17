package DP.String;

import static DP.String.LCSubsequence.lcs;

public class InsertionDeletion {
    static int canYouMake(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int k = lcs(str1, str2);

        return (n - k) + (m - k);
    }

    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }
}
