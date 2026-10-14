class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9){
            return "" ;
        }
        StringBuilder st = new StringBuilder() ;

        int nine = sum / 9 ;
        int remains = sum % 9 ;

        for(int i = 0 ; i < nine ; i++){
            st.append('9');
        }
        if(remains > 0){
            st.append((char) (remains +'0'));
        }
        while(st.length() < num){
            st.append('0');
        }

        return st.toString();
    }
}