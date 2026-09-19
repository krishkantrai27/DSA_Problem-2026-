class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                String str = s.substring(i, j + 1);

                if (isPalindrome(str)) {

                    if (str.length() > ans.length()) {
                        ans = str;
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String p) {

        int left = 0;
        int right = p.length() - 1;

        while (left < right) {

            if (p.charAt(left) != p.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}