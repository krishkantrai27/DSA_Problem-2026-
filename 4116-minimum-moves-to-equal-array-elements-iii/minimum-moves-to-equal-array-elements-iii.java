class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
        }
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            sum += max - nums[i];
        }
        return sum ;
    }
}