package TwoPointer;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfAnagram {
    public static void main(String[] args) {
        // Test case 1: General case
        testCountAnagram("forxxorfxdofr", "for", 3);

        // Test case 2: Pattern at the start and end
        testCountAnagram("abcdabc", "abc", 2);

        // Test case 3: Pattern spread across string
        testCountAnagram("abcdebacdabca", "abc", 4);

        // Test case 4: Large input string
        testCountAnagram("aaaaaaaaaaaaaa", "aaa", 12);

        // Test case 5: No anagram matches
        testCountAnagram("abcdefg", "xyz", 0);

        // Test case 6: Single character pattern repeating
        testCountAnagram("aaaa", "a", 4);

        // Test case 7: Pattern longer than text
        testCountAnagram("abc", "abcd", 0);

        // Test case 8: Anagrams with repeated characters
        testCountAnagram("bbaabbaabb", "abb", 4);

        // Test case 9: Pattern is the entire string
        testCountAnagram("abcd", "abcd", 1);

        // Test case 10: Random order matches
        testCountAnagram("cbabcacab", "abc", 4);
    }

    private static void testCountAnagram(String txt, String pat, int expected) {
        int result = CountNumberOfAnagram(txt, pat);
        System.out.println("Text: " + txt + ", Pattern: " + pat);
        System.out.println("Expected: " + expected + ", Actual: " + result);
        System.out.println(result == expected ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static int CountNumberOfAnagram(String txt, String pat) {
        int i=0,j=0;
        int count = 0;
        while (j<txt.length()){
            if(j-i+1<pat.length()){
                j++;
            }else if(j-i+1==pat.length()){
                String sub=txt.substring(i,j+1);
                if(isAnaGram(sub,pat)){
                    count++;
                }
                j++;
            }else{
                i++;
                String sub=txt.substring(i,j+1);
                if(isAnaGram(sub,pat)){
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    private static boolean isAnaGram(String sub, String pat) {
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int i=0;i<sub.length();i++){
            hs.put(sub.charAt(i),hs.getOrDefault(sub.charAt(i),0)+1);
        }
        for(int i=0;i<pat.length();i++){
           if(hs.containsKey(pat.charAt(i))){
               hs.put(pat.charAt(i),hs.getOrDefault(pat.charAt(i),0)-1);
               if (hs.get(pat.charAt(i))==0){
                   hs.remove(pat.charAt(i));
               }
           }else
               return false;
        }
        return hs.isEmpty();
    }
}
