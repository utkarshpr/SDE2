package Array.Medium;

import java.util.*;

public class nextPermutattion {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");
    }
/*
2154300
i=1 index
2354100
2300154

 */
    private static List<Integer> nextGreaterPermutation(List<Integer> a) {
        int br=-1;
        for(int i=a.size()-2;i>=0;i--){
            if(a.get(i-1)<a.get(i)){
                br=i-1;
                break;
            }
        }
        System.out.println(br);
        if (br == -1){
            Collections.reverse(a);
            return a;
        }

        for(int i=a.size()-1;i>br;i--){
            if(a.get(i)>a.get(br)){
                int temp=a.get(i);
                a.set(i,a.get(br));
                a.set(br,temp);
                break;
            }
        }
        List<Integer> sublist=a.subList(br+1,a.size());
        Collections.reverse(sublist);
        return a;
    }
}
