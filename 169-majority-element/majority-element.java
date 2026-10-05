class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length ;
        int cnt = 1 ;
        int candidate = nums[0] ;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == candidate){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    candidate = nums[i];
                    cnt = 1;
                }
            }
        }
        return candidate;
    }
}