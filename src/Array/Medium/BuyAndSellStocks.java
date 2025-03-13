package Array.Medium;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);

    }

    private static int maxProfit(int[] arr) {
        int profit=0;
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(i!=0){
                ans=arr[i]-min;
            }
            min=Math.min(min,arr[i]);
            profit=Math.max(profit,ans);
        }
        return profit;
    }
}
