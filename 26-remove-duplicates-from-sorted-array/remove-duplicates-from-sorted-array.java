class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length ;
        int left = 0;
        int k = 1;
        int right = 1 ;
        while(right < n){
            if(nums[left] == nums[right]){
                right++;
            }else{
                k++;
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        return k ;
    }
}