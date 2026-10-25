class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n  = s1.length() ;
        int m = s2.length() ;
        if(n > m )return false ;
        //Frequency to store S1 char Frequency
        int [] freq1 = new int[26];
        int [] freq2 = new int[26];
        for(int i = 0 ; i < n ; i++){
            freq1[s1.charAt(i) - 'a']++;
        }
        int i = 0 ; 
        int j = 0 ;
        
        while( j < m){
            freq2[s2.charAt(j) - 'a']++;
            // Jaise hi Window ki Length S1 se badi hui waise hi leftMost element ko remove kar denge 
            if(j - i + 1 > n){
                freq2[s2.charAt(i) - 'a']--;
                i++;        // Left ko iterate kardo
            }
            if(Arrays.equals(freq1,freq2)) return true ;
            j++;
        }
        return false ;

    }
}