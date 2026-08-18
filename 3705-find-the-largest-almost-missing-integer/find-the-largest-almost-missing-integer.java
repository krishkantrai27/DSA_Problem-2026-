class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int large = -1 ;
        for(int i = 0 ; i <= n -k ; i++){
            Set<Integer>set = new HashSet<>();
            for(int j = i ; j < i+k ; j++){
                set.add(nums[j]);
            }
            for(int x : set){
            map.put(x,map.getOrDefault(x , 0 ) + 1);
            }
        }
        
        for(int a : map.keySet()){
            if(map.get(a) == 1){
                large = Math.max(large,a);
            }
        }
        return large ;
    }
}