class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        // Character mappings ke liye arrays (ASCII characters ke liye size 256)
        int[] mapS2T = new int[256];
        int[] mapT2S = new int[256];
        
        // Arrays ko -1 se initialize karte hain kyunki ASCII 0 valid index hai
        for (int i = 0; i < 256; i++) {
            mapS2T[i] = -1;
            mapT2S[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Agar pehle se mapping hai aur wo match nahi karti
            if (mapS2T[charS] != -1 && mapS2T[charS] != charT) {
                return false;
            }
            if (mapT2S[charT] != -1 && mapT2S[charT] != charS) {
                return false;
            }
            
            // Nayi mapping save karo
            mapS2T[charS] = charT;
            mapT2S[charT] = charS;
        }
        
        return true;
    }
}