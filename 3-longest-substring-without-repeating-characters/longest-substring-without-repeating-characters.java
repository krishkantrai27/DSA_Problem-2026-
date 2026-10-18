class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0 ;
        int right = 0 ;
        int ans = 0;
        Set<Character> set = new HashSet<>() ;
        while(right < n ){
            char ch = s.charAt(right) ;
            if(!set.contains(ch)){
                set.add(ch);
                ans = Math.max(right - left +1, ans);
                right++;
            }else{
                //Duplicat jb tk aate hai hai tb tk left aage badta rahega
                while(s.charAt(left) != ch){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(ch);
                left++;
            }
        }
        return ans ;
    }
}