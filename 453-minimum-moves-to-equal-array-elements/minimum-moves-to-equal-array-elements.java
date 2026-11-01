class Solution {
    public int minMoves(int[] nums) {
        long sum = 0 ;
        int n = nums.length ;
        int min = Integer.MAX_VALUE ;
        for(int i : nums){
            sum += i ;
            min = Math.min(min , i);
        }
        int a = n * min ;
        return (int) sum - a ;
    }
}