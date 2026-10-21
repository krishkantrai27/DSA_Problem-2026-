class Solution {
    public int characterReplacement(String s, int k) {
       int n = s.length();
       int [] arr = new int[256];
       int left = 0 ;
       int right = 0 ; 
       int res = Integer.MIN_VALUE ;

       while(right < n){
            arr[s.charAt(right)]++;
            int max = maximum(arr);
            int len = right - left +1 ;
            int diff = len - max ;
            //Diff ko skip karna hai
            while(diff > k){
                arr[s.charAt(left)]--;
                left++;
                max = maximum(arr);
                len = right -left + 1 ;
                diff = len - max ;
            }
            len = right - left + 1 ;
            res = Math.max(len,res);
            right++;
       }
       return res ;
    }
    public int maximum(int [] arr){
        int max = Integer.MIN_VALUE ;
        for(int i : arr){
            max = Math.max(i , max);
        }
        return max ;
    }
}