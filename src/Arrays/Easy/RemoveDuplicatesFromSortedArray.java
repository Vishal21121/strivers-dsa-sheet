// Question Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(arr));
    }

    // Optimal Approach
    // T.C => O(n)
    // S.C => O(1)
    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[unique]) {
                unique += 1;
                nums[unique] = nums[i];
            }
        }
        return unique + 1;
    }
}