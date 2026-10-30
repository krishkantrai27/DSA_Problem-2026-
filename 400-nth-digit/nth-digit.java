class Solution {
    public int findNthDigit(int n) {
        //Group 1 - (1 -> 9)
        //Group 2 - (10 -> 99)
        //Group 3 - (99 -> 999)
        long start = 1 ;
        long cnt = 9 ;
        long digitLen = 1 ;
        // Jitne Group skip ho sake utne skip karo
        while( n > cnt * digitLen){
            n -= cnt * digitLen ;
            digitLen++;
            start *= 10 ;
            cnt  *= 10 ;
        }
        // Abb yaha Actal Number Find karenge jisme vo Exist karega
        long number = start + (n-1) / digitLen ;
        //Abb jo Bhi number milega usko string me convert karke uske position se track karege
        String num = Long.toString(number);
        // Required digit ka index find karo
        int pos = (int)((n - 1) % digitLen);
        // long .charAt nhi aayega isliye int
        // Required digit extract karo
        int ans = num.charAt(pos) - '0';
        return ans ;
    }
}