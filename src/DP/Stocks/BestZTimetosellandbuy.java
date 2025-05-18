package DP.Stocks;

public class BestZTimetosellandbuy {
    public static void main(String[] args) {
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maximumProfit(Arr));
    }

    private static int maximumProfit(int[] arr) {
        int min=arr[0],profit=0;
        for(int i=1;i<arr.length;i++){
            int val=arr[i]-min;
            profit=Math.max(profit,val);
            min=Math.min(arr[i],min);

        }
       return (profit);
    }
}
