class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0 ;
        int curr = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            curr += nums[i] ;
            if(curr == 0 )count++;
        }
        return count ;
    }
}