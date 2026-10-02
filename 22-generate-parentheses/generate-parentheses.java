class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>() ;
        int open = 0 ;
        int close = 0 ;
        String a = "";
        return generate (n,open,close ,a ,ans) ;
    }
    public List<String> generate(int n , int open , int close ,String curr , List<String>ans){
        if(curr.length() == 2*n){
            ans.add(curr);
            return ans ;
        }
        if(open < n){
            generate(n , open + 1 , close , curr + "(" , ans);
        }
        if(close < open){
            generate(n , open , close +1 , curr + ")" ,ans);
        }
        return ans ;
    }
}