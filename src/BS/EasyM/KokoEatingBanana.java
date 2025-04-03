package BS.EasyM;

public class KokoEatingBanana {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Object[][] testCases = {
                {new int[]{7, 15, 6, 3}, 8, 5},                    // Standard case
                {new int[]{100}, 10, 10},                          // Single pile
                {new int[]{1, 1, 1, 1, 1}, 5, 1},                  // All piles one banana
                {new int[]{1000000000}, 1, 1000000000},            // Large pile, 1 hour

                {new int[]{10, 20, 30}, 6, 10},                    // Exactly fits
                {new int[]{100, 200, 300}, 1000, 1},               // Large hours
                {new int[]{}, 5, 1}                                // Edge case: no bananas
        };

        int passed = 0;
        int failed = 0;

        for (Object[] testCase : testCases) {
            int[] bananas = (int[]) testCase[0];
            int h = (int) testCase[1];
            int expected = (int) testCase[2];

            try {
                int result = KokoEatingBanana.minimumRateToEatBananas(bananas, h);
                if (result == expected) {
                    System.out.println("✅ Passed: " + java.util.Arrays.toString(bananas) + " with h = " + h);
                    passed++;
                } else {
                    System.out.println("❌ Failed: Expected " + expected + " but got " + result +
                            " for input: " + java.util.Arrays.toString(bananas) + " with h = " + h);
                    failed++;
                }
            } catch (Exception e) {
                System.out.println("❌ Error while testing " + java.util.Arrays.toString(bananas) + " with h = " + h);
                e.printStackTrace();
                failed++;
            }
        }

        System.out.println("\nTests completed: " + (passed + failed));
        System.out.println("✅ Passed: " + passed);
        System.out.println("❌ Failed: " + failed);
    }

    private static int minimumRateToEatBananas(int[] v, int h) {
        int min=1;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<v.length;i++){
           // min=Math.min(v[i],min);
            max=Math.max(v[i],max);
        }
        while(min<=max){
            int mid=(min+max)/2;
            if(isCalculate(mid,v,h)){
                max=mid-1;
            }
            else{
                min=mid+1;
            }

        }
        return min;
    }

    private static boolean isCalculate(int mid, int[] v, int h) {
        int count=0;
        for(int i:v){
            count+= (int) Math.ceil((double) i/(double) mid);
        }
        return count <=h;
    }
}
