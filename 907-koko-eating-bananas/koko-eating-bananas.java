class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE ;
        for(int i : piles){
            max = Math.max(max,i);
        }
        int left = 1 ;
        int right = max ;
        while(left < right){
            int mid = left + (right - left) / 2 ;
            // Per Hour main Mid Banana Kha Sakta hu main
            if(countPiles(piles , mid ,h)){
                right = mid ;
            }else{
                left = mid+1 ;
            }
        }
        return left ;
    }
    public boolean countPiles(int [] arr , int l , int h){
        int actualSum = 0 ;
        for(int n : arr){
            actualSum += n / l ;
            if(n % l != 0){
                actualSum++;
            }
        }
        return actualSum <= h ;
    }
}