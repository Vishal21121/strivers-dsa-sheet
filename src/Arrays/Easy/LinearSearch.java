package Arrays.Easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6,7,8};
        System.out.println(searchInSorted(arr,arr.length,5));
    }
    static int searchInSorted(int arr[], int N, int K)
    {

        for(int i=0;i<N;i++){
            if(arr[i]==K){
                return 1;
            }
        }
        return -1;
    }
}
