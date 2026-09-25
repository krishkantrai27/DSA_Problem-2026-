class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1 ;
        int n = nums.length ;
        int left = 0 ;
        int k = 1 ;
        for(int right = 1 ; right < n ; right++){
            if(nums[left] == nums[right]){
                if(unique != 0){
                    k++;
                    nums[left+1] = nums[right];
                    left++;
                    unique-- ;
                }
                continue;
            }else{
                    k++;
                    nums[left+1] = nums[right];
                    left++;
                    unique = 1 ;
            }
        }
        return k ;
    }
}