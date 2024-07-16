package Arrays.Easy;

import java.util.HashMap;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2};
        System.out.println(findMissingNumOptimalUsingXOR(arr));
    }

    // T.C => O(n*n) in worst case
//    S.C => O(1)
    public static int findMissingNumBrute(int[] arr){
        int n = arr.length;
        int missingNum = -1;
        boolean flag = true;
        for(int i=0;i<=n;i++){
            flag = true;
            for(int j=0;j<n;j++){
                if(arr[j]==i){
                    flag = false;
                }
            }
            if(flag){
                missingNum =  i;
                break;
            }
        }
        return missingNum;
    }


//    T.C => O(2n)
//    S.C => O(n) => for storing the elements in the hashMap
    public static int findMissingNumBetter(int[] arr){
        int missingNum = -1;
        int n = arr.length;
//        hashMap for storing the number in the arr;
        HashMap<Integer, Integer> map = new HashMap<>();
//        loop for storing the num in the hasMap
        for(int el:arr){
            if(!map.containsKey(el)){
                map.put(el,1);
            }
        }
//        loop for finding the missing Num
        for(int i=0;i<=n;i++){
            if(!map.containsKey(i)){
                missingNum = i;
                break;
            }
        }

        return missingNum;
    }

//    T.C => O(2n)
//    S.C => O(1)
    public static  int findMissingNumOptimalUsingSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int actualSum = 0;
        for(int el: nums){
            sum += el;
        }
        for(int i=0;i<=n;i++){
            actualSum += i;
        }
        return actualSum - sum;
    }

//    T.C => O(n)
//    S.C => O(1)
    public static  int findMissingNumOptimalUsingXOR(int[] nums){
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<nums.length;i++){
//            in xor1 we are taking xor from 0 to n
            xor1 = xor1 ^ (i+1);
//            in xor2 we are taking xor of all the elements of nums
            xor2 = xor2 ^ nums[i];
        }
        return xor1 ^ xor2;
    }
}
