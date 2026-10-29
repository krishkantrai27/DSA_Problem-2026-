class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>() ;
        map.put(0,1);
        int ans = 0 ;
        int currSum = 0 ;
        for(int n : nums){
            currSum += n ;
           
           if(map.containsKey(currSum - k)){
                ans += map.get(currSum - k);
           }
           map.put(currSum , map.getOrDefault(currSum , 0) + 1) ;
        }
        return ans;
    }
}