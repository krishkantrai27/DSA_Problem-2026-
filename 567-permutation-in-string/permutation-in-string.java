class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length() ;
        int m = s2.length() ;
        if(m < n ) return false ;
        char[] sorteds1 = s1.toCharArray();
        Arrays.sort(sorteds1);
        for(int i = 0 ; i <= m - n ; i++){
            String temp = s2.substring(i,i + n);
            
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            
            if(Arrays.equals(sorteds1,arr)) return true;
        }
        return false;
    } 
}