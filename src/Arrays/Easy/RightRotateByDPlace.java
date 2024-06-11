package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class RightRotateByDPlace {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        rotateArrayOptimal(arr, 3);
        System.out.println(arr);
    }

//    Optimal Approach
//    T.C => O(2n)
//    S.C => O(1)
    public static void rotateArrayOptimal(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverseArray(arr,0,n-k-1); // O(n-k)
        reverseArray(arr,n-k,n-1); // O(k)
        reverseArray(arr,0,n-1); // O(n)
    }

    public static void reverseArray(int[] arr, int start, int end){
            while(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
    }
}
