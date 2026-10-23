
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return "";

        int[] freq = new int[128];

        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int required = n;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < m; right++) {
            char ch = s.charAt(right);

            if (freq[ch] > 0) {
                required--;
            }
            freq[ch]--;

            while (required == 0) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char c = s.charAt(left);
                freq[c]++;

                if (freq[c] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
