class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return a[0] - b[0] ;
            return a[1] - b[1] ;
        }) ;
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{nums[i] ,i});
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<int[]>list = new ArrayList<>(pq) ;
        list.sort((a,b) -> a[1] - b[1]);
        int [] arr = new int[k];
           for(int i = 0 ; i < k ; i++){
               arr[i] = list.get(i)[0];
            }
        return arr ;
    }
}