package BS.EasyM;

public class CapacitytoShipPackageswithinDDays {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }

    private static int leastWeightCapacity(int[] weights, int d) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(isCalculateDays(mid,weights,d)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static boolean isCalculateDays(int mid, int[] weights, int d) {
        int days = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > mid) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days<=d;
    }
}
