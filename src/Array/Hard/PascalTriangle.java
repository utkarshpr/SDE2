package Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n-1);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>>ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        List<Integer> temp;
                for(int i=1;i<=n;i++){
                    temp=new ArrayList<>();
                    temp.add(1);

                        List<Integer> prev = ans.get(i - 1);
                        for (int j = 1; j < i; j++) {
                            if (!prev.isEmpty()) {
                                temp.add(prev.get(j - 1) + prev.get(j));
                            }
                        }
                        temp.add(1);

                    ans.add(temp);
                }
                ans.remove(0);
                temp=new ArrayList<>();
                temp.add(1);
                ans.add(0,temp);
        return ans;
    }
}
