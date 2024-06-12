package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{5,0,0,4,3,0,1,2,1,0,1,0,0};
//        moveZeroes(arr);
        moveZeroesOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }

//    Brute Force Approach
//    T.C => O(n) + O(x) + O(n-x) ( x is for the non-zero elements)
//    S.C => O(x) which can O(n) in worst case when the array will have all non-zero elements
    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
//        storing all non zero values
        for(int el :nums){
            if(el != 0){
                list.add(el);
            }
        }
//        putting all non-zero values at the front
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
//        filling rest places with 0 values
        for(int i=list.size();i<n;i++){
            nums[i] = 0;
        }
    }

//    Optimal Approach
//    T.C => O(x) + O(n-x) => O(n)
//    S.C => O(1)
    public static void moveZeroesOptimal(int[] nums){
        int j = -1;
        int n = nums.length;
//        find the first zero element
//        T.C => O(x)
        for(int i =0;i<n;i++){
            if(nums[i]==0){
                j = i;
                break;
            }
        }
//        if j==-1 means array has all non-zero elements
        if(j==-1){
            return;
        }
//        iterate and swap non-zero elements with zero elements
//        T.C => O(n-x)
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                swap(nums,i,j);
                j++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
