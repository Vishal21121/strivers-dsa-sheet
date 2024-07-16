package Arrays.Easy;

public class FindMaxConsecutiveOne {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0,1,1,0,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
//    T.C => O(n)
//    S.C => O(1)
//    Easy solution is the optimal solution over here
    public static int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int count = 0;

        for(int el: arr){
            if(el == 1){
                count++;
            }else{
                maxCount = Math.max(count,maxCount);
                count = 0;
            }
        }
        return maxCount;
    }
}
