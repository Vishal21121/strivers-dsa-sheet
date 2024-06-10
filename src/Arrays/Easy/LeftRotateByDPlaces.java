// Question Link: https://www.naukri.com/code360/problems/rotate-array_1230543?leftPanelTabValue=SUBMISSION

package Arrays.Easy;

import java.util.ArrayList;

public class LeftRotateByDPlaces {
    public static void main(String[] args) {

    }

//    Brute Force Approach
//    T.C => O(n+d)
//    S.C => O(d)
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int n = arr.size();
//        if we rotate the array by the size of the array then we will get the original array hence we find the modulo so that we remove the multiples of the size of the array
        k =  k % n;

//        for putting the first d elements O(d)
        for(int i=0;i<k;i++){
            tempList.add(arr.get(i));
        }

//        for shifting the rest of the elements O(n-d)
        for(int i=k;i<n;i++){
            arr.set(i-k,arr.get(i));
        }

//        for putting the elements of temp list at place O(d)
        for(int i=n-k;i<n;i++){
            arr.set(i,tempList.get(i-(n-k)));
        }
        return arr;
    }

//    Optimal Approach
//    T.C => O(2n)
//    S.C => O(1)
    public static ArrayList<Integer> rotateArrayOptimal(ArrayList<Integer> arr, int k){
        int n = arr.size();
        k = k % n;
        reverseArray(arr,0,k-1); // O(K)
        reverseArray(arr,k,n-1); // O(n-k)
        reverseArray(arr,0,n-1); // O(n)
        return arr;
    }

    public static void reverseArray(ArrayList<Integer> arr, int start, int end){
        while(start<=end){
            int temp = arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,temp);
            start++;
            end--;
        }
    }


}
