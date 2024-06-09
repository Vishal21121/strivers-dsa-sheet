// Question Link: https://www.geeksforgeeks.org/problems/second-largest3735/1

import java.util.Arrays;

public class SecondLargestNum {
    public static void main(String[] args) {
        int[] arr = { 5, 5 };
        System.out.println(secondLargestOptimal(arr));
    }

    // Brute force Approach
    // T.C => O(nlogn + n)
    // S.C => O(1)
    public static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int secondMax = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != max) {
                secondMax = arr[i];
                break;
            }
        }
        return secondMax;
    }

    // Better approach
    // T.C => O(2n)
    // S.C => O(1)
    public static int secondLargestBetter(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        // finding max in first pass
        for (int el : arr) {
            if (el > max) {
                max = el;
            }
        }
        // finding the second largest in the second pass by taking max as reference
        for (int el : arr) {
            if (el < max && el > secondMax) {
                secondMax = el;
            }
        }
        return secondMax;
    }

    // Optimal approach
    // T.C => O(n)
    // S.C => O(1)
    public static int secondLargestOptimal(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int el : arr) {
            // if el > max then that element will be max and the current max will become
            // second largest
            if (el > max) {
                secondMax = max;
                max = el;
            }
            // if the element is smaller than max but large than secondLargest
            else if (el < max && el > secondMax) {
                secondMax = el;
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
