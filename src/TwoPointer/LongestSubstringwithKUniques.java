package TwoPointer;

import java.util.HashMap;

public class LongestSubstringwithKUniques {
    public static void main(String[] args) {
        runTest("aabacbebebe", 3, 7); // Expected: 7
        runTest("aaaa", 2, -1); // Expected: -1 (Only 1 unique character)
        runTest("abcabcabc", 2, 2); // Expected: 2 (Maximum substring with 2 unique chars)
        runTest("abcbbbbcccbdddadacb", 2, 10); // Expected: 10 (Longest with 2 unique)
        runTest("abcdefgh", 4, 4); // Expected: 4 (Any 4 unique chars form valid substrings)
        runTest("abaccc", 2, 4); // Expected: 4 ("accc")
        runTest("aabbcc", 3, 6); // Expected: 6 ("aabbcc")
        runTest("xyzxyzxyz", 3, 9); // Expected: 9 (Entire string)
        runTest("ab", 3, -1); // Expected: -1 (Only 2 unique characters, needs 3)
        runTest("", 2, -1); // Expected: -1 (Empty string)
    }

    private static void runTest(String s, int k, int expected) {
        int result = calculateLength(s, k);
        System.out.println("String: \"" + s + "\", k: " + k);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result == expected ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static int calculateLength(String s, int k) {
        int max=0;
        int i=0,j=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==k){
                max=Math.max(max,j-i+1);
            }
            else if(map.size()>k){
                while(map.size()>k){
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                    if(map.get(s.charAt(i))==0)
                        map.remove(s.charAt(i));
                    i++;
                }
                if(map.size()==k){
                    max=Math.max(max,j-i+1);
                }

            }
            j++;
        }
        return  max==0?-1:max;
    }
}
