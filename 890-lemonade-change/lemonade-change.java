class Solution {
    public boolean lemonadeChange(int[] bills) {
        int paisa5 = 0 ;
        int paisa10 = 0 ;
        for(int n : bills){
            if(n == 5){
                paisa5++;
            }
            else if(n == 10){
                paisa10++;
                if(paisa5 <= 0) return false ;
                paisa5--;

            }else if( n == 20){
                if(paisa10 > 0){
                    paisa10--;
                    if(paisa5 <= 0) return false ;
                    paisa5--;
                }else{
                    if(paisa5 < 3) return false;
                    paisa5 = paisa5 - 3 ;
                }
            }
        }
        return true;
    }
}