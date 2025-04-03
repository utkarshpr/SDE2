package BS.EasyM;

public class MinimumdaystomakeMbouquets {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Object[][] testCases = {
                {new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 3, 2, 12},      // Standard case
                {new int[]{13, 14, 15, 16}, 3, 2, -1},                 // No bouquets possible
                {new int[]{5, 1, 2, 3, 4}, 2, 1, 2},                   // Single bouquet
                {new int[]{1, 1, 1, 1, 1}, 2, 2, 1},                   // All flowers bloom same day
               {generateLargeArray(), 10, 5000, 1},                   // Large input
                {new int[]{}, 1, 1, -1},                               // Empty array
                {new int[]{4, 5, 6}, 4, 1, -1},                        // Bouquet size larger than array
                {new int[]{3, 5, 7, 2, 8, 1, 6}, 2, 3, 2}             // Minimum day condition
        };

        int passed = 0;
        int failed = 0;

        for (Object[] testCase : testCases) {
            int[] arr = (int[]) testCase[0];
            int k = (int) testCase[1];
            int m = (int) testCase[2];
            int expected = (int) testCase[3];

            try {
                int result = MinimumdaystomakeMbouquets.roseGarden(arr, k, m);
                if (result == expected) {
                    System.out.println("✅ Passed for input: " + java.util.Arrays.toString(arr) + " with k=" + k + ", m=" + m);
                    passed++;
                } else {
                    System.out.println("❌ Failed for input: " + java.util.Arrays.toString(arr) + " with k=" + k + ", m=" + m);
                    System.out.println("   Expected: " + expected + ", Got: " + result);
                    failed++;
                }
            } catch (Exception e) {
                System.out.println("❌ Error while testing input: " + java.util.Arrays.toString(arr) + " with k=" + k + ", m=" + m);
                e.printStackTrace();
                failed++;
            }
        }

        System.out.println("\nTests completed: " + (passed + failed));
        System.out.println("✅ Passed: " + passed);
        System.out.println("❌ Failed: " + failed);
    }
    // Method to generate a large input array
    private static int[] generateLargeArray() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = 1 + (i % 10);
        }
        return arr;
    }

    private static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        int low=min,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if (isCalculatem(mid,k,m,arr)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static boolean isCalculatem(int mid, int k, int m, int[] arr) {
        int count=0;
        int noof=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }else{
                noof+=(count/k);
                count=0;
            }
        }
        noof+=(count/k);
        return noof>=m;
    }

}
