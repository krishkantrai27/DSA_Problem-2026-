class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length ;
        int resSum = 0 ;
        int maxDiff = Integer.MAX_VALUE ;
        for(int i =0 ; i < n -2 ; i++){
            int left = i +1 ;
            int right = n -1 ;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right] ;
                int diff = Math.abs(target - sum);
                if(sum == target){
                    return sum ;
                }else if (sum > target){
                    if(maxDiff > diff){
                        maxDiff = diff ;
                        resSum = sum;
                    }
                    right--;
                }else{
                    if(maxDiff > diff){
                        maxDiff = diff ;
                        resSum = sum;
                    }
                    left++;
                }
            }
        }
        return resSum ;
    }
}