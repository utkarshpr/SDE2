package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int ar[] = {1,3,2};
            //int ar[]={7,1,5,3,6,3};
            int br = -1;
            for (int i = ar.length - 2; i >= 0; i--) {
                if (ar[i] < ar[i + 1]) {
                    br = i;
                    break;
                }
            }

            if (br == -1) {
                reverse(ar, 0, ar.length - 1);
                return;
            }

            for (int i = ar.length-1;i>br ;i--) {
                if (ar[br] < ar[i]) {
                    int temp = ar[br];
                    ar[br] = ar[i];
                    ar[i] = temp;
                    break;
                }
            }
            int st = br + 1, end = ar.length - 1;
            while (st <= end) {
                int temp = ar[st];
                ar[st] = ar[end];
                ar[end] = temp;
                st++;
                end--;
            }
        }

        private static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private static void reverse(int[] nums, int start, int end){
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
