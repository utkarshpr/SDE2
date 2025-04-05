package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        runTest("aabb", Arrays.asList(
                Arrays.asList("a", "a", "b", "b"),
                Arrays.asList("a", "a", "bb"),
                Arrays.asList("aa", "b", "b"),
                Arrays.asList("aa", "bb")
        ));

        runTest("abc", Arrays.asList(
                Arrays.asList("a", "b", "c")
        ));

        runTest("aaa", Arrays.asList(
                Arrays.asList("a", "a", "a"),
                Arrays.asList("a", "aa"),
                Arrays.asList("aa", "a"),
                Arrays.asList("aaa")
        ));

        runTest("racecar", Arrays.asList(
                Arrays.asList("r", "a", "c", "e", "c", "a", "r"),
                Arrays.asList("r", "a", "cec", "a", "r"),
                Arrays.asList("r", "aceca", "r"),
                Arrays.asList("racecar")
        ));

        runTest("a", Arrays.asList(
                Arrays.asList("a")
        ));

        runTest("", Arrays.asList(
                Arrays.asList()
        ));
    }

    private static void runTest(String s, List<List<String>> expected) {
        List<List<String>> result = partition(s);
        System.out.println("String: \"" + s + "\"");
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(expected) ? "✅ Test Passed!\n" : "❌ Test Failed!\n");
    }

    private static List<List<String>> partition(String s) {
            List<List<String>> ans=new ArrayList<>();
            List<String> ar=new ArrayList<>();
            helperPalindromePartitioning(s,0,ans,ar);
            return ans;
    }

    private static void helperPalindromePartitioning(String s, int i, List<List<String>> ans, List<String> ar) {
        if(i==s.length()){
            ans.add(new ArrayList<>(ar));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                ar.add(s.substring(i,j+1));
                helperPalindromePartitioning(s,j+1,ans,ar);
                ar.remove(ar.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int i, int j, String s) {
        while (i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
