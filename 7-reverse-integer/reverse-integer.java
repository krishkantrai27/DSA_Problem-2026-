class Solution {
    public int reverse(int x) {
        long reversed = 0 ;
        while(x != 0 ){
            long last = x % 10 ;
            reversed = reversed * 10 + last ;
            x = x /10;
        }
        if(Integer.MIN_VALUE > reversed || Integer.MAX_VALUE < reversed){
            return 0;
        }
        return (int) reversed ;
    }
}