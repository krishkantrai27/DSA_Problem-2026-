class Solution {
    public String minWindow(String s, String t) {
        //Aise Sabse Chooti window return karni Hai jisme t Char Present Ho 
        int m = s.length();
        int n = t.length();
        if (m < n)
            return "";
        //Frequency ko store karne ke liye
        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int left = 0;
        int right = 0;
        int required = n;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < m) {
            char ch = s.charAt(right);

            if(freq[ch] > 0) required--;

            freq[ch]--;

            while (required == 0) {
                int len = right - left + 1;
                if (minLen > len) {
                    minLen = len;
                    start = left;
                }
                char c = s.charAt(left);
                freq[c]++;
                if (freq[c] > 0) required++;
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE) return "" ;
        return s.substring(start, start + minLen);
    }
}