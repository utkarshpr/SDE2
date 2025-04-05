package BS.EasyM;

import java.util.Arrays;

public class AggressiveCow {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);

    }

    private static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stall positions

        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid distance

            if (isPossible(stalls, k, mid)) {
                res = mid; // Store the valid distance
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce search space
            }
        }
        return res;

    }

    public static boolean isPossible(int[] stalls, int k, int mid) {
        int cowsPlaced = 1; // Place first cow in the first stall
        int lastPos = stalls[0]; // Last placed cow's position

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= mid) { // If distance is at least 'mid'
                cowsPlaced++; // Place next cow
                lastPos = stalls[i]; // Update last position
                if (cowsPlaced == k) return true; // All cows placed successfully
            }
        }
        return false;
    }
}
