// Question Link: https://www.naukri.com/code360/problems/left-rotate-an-array-by-one_5026278

package Arrays.Easy;

import java.util.Arrays;

public class LeftRotateArrayByOnePlace {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(rotate(arr, arr.length)));
    }

//    Optimal approach
//    T.C => O(n)
//    S.C => O(1) extra space used is O(1) but algorithm uses the array provided inorder to solve the question
    public static int[] rotate(int[] arr, int n) {
        int firstElement = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = firstElement;
        return arr;
    }
}