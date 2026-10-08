class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0 ;
        StringBuilder str = new StringBuilder() ;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(cnt != 0) str.append(ch);
                    cnt++;
            }else{
                cnt--;
                if(cnt != 0) str.append(ch);
            }
        }
        return str.toString();
    }
}