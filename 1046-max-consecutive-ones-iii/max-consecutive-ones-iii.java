class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0 ;
        int n = nums.length ;
        int ans = 0 ;
        int zero = 0 ;
        for(int right = 0 ; right < n ; right++){
           if(nums[right] == 0) zero++;
           while(zero > k){
            if(nums[left] == 0) zero--;
            left++;
           }
           int len = right -left+1 ;
           ans = Math.max(len,ans);
        }
        return ans ;
    }
}