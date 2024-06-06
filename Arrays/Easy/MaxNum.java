// Question link: https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0

import java.util.Arrays;

public class MaxNum {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(maxNumBetter(arr));
    }

    // Brute force Approach
    // T.C => O(nlogn)
    // S.C => O(1)
    public static int maxNum(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    // Optimal Approach
    // T.C => O(n)
    // S.C => O(1)
    public static int maxNumBetter(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int el : arr) {
            if (el > max) {
                max = el;
            }
        }
        return max;
    }
}