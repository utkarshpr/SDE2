package Array.Easy;

public class consecutive1 {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int res_max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                res_max++;
            }else{
                max= Math.max(max, res_max);
                res_max=0;

            }
        }
        max= Math.max(max, res_max);
        return max;
    }
}
