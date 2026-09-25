class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0 ;
        int n = nums.length ;
        int k = 1 ;
        for(int right = 1 ; right < n ; right++){
            if(nums[left] != nums[right]){
                k++;
                left++;
                nums[left] = nums[right];
            }
        }
        return k ;

    }
}