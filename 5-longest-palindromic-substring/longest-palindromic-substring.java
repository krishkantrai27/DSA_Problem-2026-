class Solution {
    public String longestPalindrome(String s) {
        int n = s.length() ;
        String ans = "";
        for(int i = 0 ; i < n ; i++){
            for(int j = i  ; j < n ;j++){
                String sub = (s.substring(i , j +1)) ;
                if(palindrome(sub)){
                    if(sub.length() > ans.length()){
                        ans = sub;
                    }
                }
            }
        }
        return ans ;
    }
    public boolean palindrome(String str){
        int left = 0 ;
        int right = str.length() -1 ;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false ;
            left++;
            right--;
        }
        return true ;
    }
}