package Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int candidates[] = {2,3,6,7}; int target = 7;
        List<List<Integer>> ans =combinationSum(candidates,target);
        System.out.println(ans);
    }
    public static   List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> ad=new ArrayList<>();
        chelper(candidates,target,ans,ad,0);
        return ans;
    }

    private static void chelper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> ad, int i) {
        if(i==candidates.length){
            if (target ==0){
                ans.add(new ArrayList<>(ad));
            }
            return;
        }
        if(candidates[i]<=target){
            ad.add(candidates[i]);
            chelper(candidates,target-candidates[i],ans,ad,i);
            ad.remove(ad.size()-1);
        }
        chelper(candidates,target,ans,ad,i+1);
    }
}
