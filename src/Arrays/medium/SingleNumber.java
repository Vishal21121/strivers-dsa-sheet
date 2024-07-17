package Arrays.medium;

import java.util.HashMap;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        System.out.println(singleNumberBetter(arr));
    }

//    T.C => O(n*n)
//    S.C => O(1)
    public static int singleNumberBrute(int[] nums){
        int count = 0;
        int num = 0;

        for(int el: nums){
            count = 0;
            for(int innerEl: nums){
                if(el==innerEl){
                    count++;
                }
            }
            if(count==1){
                num = el;
                break;
            }
        }

        return num;
    }

//    T.C => O(2n)
//    S.C => O(n)
    public static int singleNumberBetter(int[] nums){
        int num = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el: nums){
            if(map.containsKey(el)){
                map.put(el,map.get(el)+1);
            }else{
                map.put(el,1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)==1){
                num = key;
                break;
            }
        }
        return num;
    }

//    T.C => O(n)
//    S.C => O(1)
    public static int singleNumberOptimal(int[] nums) {
        int xorVal = 0;
        for(int el: nums){
            xorVal = xorVal ^ el;
        }
        return xorVal;
    }
}
