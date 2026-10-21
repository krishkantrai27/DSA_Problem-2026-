class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0 ;
        int n = nums.length ;
        int sum = 0 ;
        int right = 0 ;
        int ans = Integer.MAX_VALUE ;
        while(right < n ){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(right -left + 1 , ans) ;
                sum -= nums[left];
                left++;
            } 
            right++;
        }
        if(ans == Integer.MAX_VALUE) return 0 ;
        return ans ;
    }
}