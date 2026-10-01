class Solution {
    public int findPermutationDifference(String s, String t) {
        int ans = 0 ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i),i);
        }
        for(int i = 0 ; i < t.length() ; i++){
            int t_idx = i;
            int s_idx = map.get(t.charAt(i)) ;
            ans += Math.abs(t_idx - s_idx);
        }
        return ans ;
    }
}