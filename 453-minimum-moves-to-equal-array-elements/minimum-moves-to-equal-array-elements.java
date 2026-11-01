class Solution {
    public int minMoves(int[] nums) {
        int sum = 0 ;
        int n = nums.length ;
        int min = Integer.MAX_VALUE ;
        for(int i : nums){
            sum += i ;
            min = Math.min(min , i);
        }
        int a = n * min ;
        return  sum - a ;
    }
}