class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int position = 0 ;
        int cnt = 0 ;
        for(int i =0 ; i < nums.length ; i++){
            if(nums[i] < 0){
                position += nums[i];
                if(position == 0) cnt++ ;
            }else{
                position += nums[i];
                if(position == 0) cnt++ ;
            }
        }
        return cnt ;
    }
}