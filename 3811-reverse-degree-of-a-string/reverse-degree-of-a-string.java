class Solution {
    public int reverseDegree(String s) {
        int ans = 0 ;
        for(int i = 1 ; i <= s.length(); i++){
            int reversed = 26 - (s.charAt(i-1) - 'a');
            ans += reversed * i;
        }
        return ans ;
    }
}