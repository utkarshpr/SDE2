package TwoPointer;

import java.util.HashMap;

public class longestsubstringwithoutrepeatingcharacters {
    public static void main(String[] args) {
        runTest("abcabcbb", 3); // Expected: 3 ("abc")
        runTest("bbbbb", 1); // Expected: 1 ("b")
        runTest("pwwkew", 3); // Expected: 3 ("wke")
        runTest("abcdefgh", 8); // Expected: 8 ("abcdefgh")
        runTest("dvdf", 3); // Expected: 3 ("vdf")
        runTest("abba", 2); // Expected: 2 ("ab")
        runTest("", 0); // Expected: 0 (Empty string)
        runTest("tmmzuxt", 5); // Expected: 5 ("mzuxt")
        runTest("aaaaabcd", 4); // Expected: 4 ("abcd")
        runTest("anviaj", 5); // Expected: 5 ("nviaj")
    }

    private static void runTest(String s, int expected) {
        int result = calculateLengths(s);
        System.out.println("String: \"" + s + "\"");
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result == expected ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static int calculateLengths(String s) {
        HashMap<Character,Integer> hs=new HashMap<>();
        int min=0;
        int i=0,j=0;
        while(j<=s.length()-1)
        {
            char ch=s.charAt(j);
            hs.merge(ch, 1, Integer::sum);
            if(j-i+1<=hs.size())
            {
                min=Math.max(min, j-i+1);
                j++;
            }
            else {
                while(j-i+1>hs.size())
                {
                    int x=hs.get(s.charAt(i));
                    x--;
                    if(x==0)
                        hs.remove(s.charAt(i));
                    else
                        hs.put(s.charAt(j), x);
                    i++;

                }
                if(j-i+1 == hs.size())
                {
                    min=Math.max(min, j-i+1);
                }
                j++;
            }
        }
        return min;
    }
}
