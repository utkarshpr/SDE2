package DP.String;

import java.util.Arrays;

public class WildCard {
    static boolean wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return wildcardMatchingUtil(S1, S2, n , m , dp);
    }

    private static boolean wildcardMatchingUtil(String s1, String s2, int n, int m, int[][] dp) {
        if(n==0 && m==0)
            return  true;
        if(m>0 && n==0)
            return  false;
        if(m==0 )
            return   isAllStars(s1,n);
        if(s1.charAt(n-1)==s2.charAt(m-1)|| s1.charAt(n-1)=='?'){
            return wildcardMatchingUtil(s1,s2,n-1,m-1,dp);
        }
        else if(s1.charAt(n-1)=='*'){
                return wildcardMatchingUtil(s1,s2,n,m-1,dp)||
                        wildcardMatchingUtil(s1,s2,n-1,m,dp);
        }else{
            return  false;
        }
    }


    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j < i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String S1 = "ab*cd";
        String S2 = "abcd";

        if (wildcardMatching(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}
