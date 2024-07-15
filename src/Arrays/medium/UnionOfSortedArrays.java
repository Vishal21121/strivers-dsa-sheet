package Arrays.medium;

import java.lang.reflect.Array;
import java.util.*;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,4,4,5,5};
        int arr2[] = new int[]{5,6,6,7};
//        System.out.println(unionMaker(arr1,arr2,arr1.length,arr2.length));
        System.out.println(unionMakerOptimal(arr1,arr2,arr1.length,arr2.length));

    }

//    Brute force approach
//    T.C => O(n * log n) + O(m * log m) + O(n + m)
//    S.C => O(n+m) that is for returning the answer
    public static ArrayList<Integer> unionMaker(int arr1[], int arr2[], int n, int m ){
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();

//        T.C => O(n*log n)
        for(int el: arr1){
//            insertion in set takes O(log n) time complexity
            set.add(el);
        }
//        T.C => O(m* log m)
        for(int el: arr2){
            set.add(el);
        }
//        T.C => O(n+m)
        for(int el:set){
            list.add(el);
        }
        return list;
    }


//    Optimal Approach
//    T.C =>  O(n + m) as we are iterating all the elements of arr1 and arr2
//    S.C => O(n+m) that is for returning the answer
    public static ArrayList<Integer> unionMakerOptimal(int arr1[], int arr2[], int n, int m){
         ArrayList<Integer> list = new ArrayList<>();
         int i=0,j=0;

//         using two pointer approach to solve this problem
//        i is pointing to first index of arr1 and j is pointing to first index of arr2
         while(i<n && j<m){
             if(arr1[i]<=arr2[j]){
//                 we are checking if the last element of the list is not same as the current element of arr1
//                 and for that list should not be empty so if list is empty directly add the value else check                    the above condition
                 if(list.size() == 0 || list.get(list.size()-1) != arr1[i]){
                     list.add(arr1[i]);
                 }
                 i++;
             }else{
                 if(list.size() == 0 || list.get(list.size()-1) != arr2[j]){
                     list.add(arr2[j]);
                 }
                 j++;
             }
         }
//         if j reaches end of the array arr2 and i has not covered all elements of arr1
         while(i<n){
             if(list.get(list.size()-1) != arr1[i]){
                 list.add(arr1[i]);
             }
             i++;
         }
//         if i reaches end of the array arr1 and j has not covered all elements of arr2

        while(j<m){
             if(list.get(list.size()-1) != arr2[j]){
                 list.add(arr2[j]);
             }
             j++;
         }

         return list;
    }

}
