class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Yeh pointer track karega ki agla non-zero element kahan aana chahiye
        
        for (int i = 0; i < nums.length; i++) {
            // Agar current element non-zero hai
            if (nums[i] != 0) {
                // Non-zero element ko jth position wale element ke sath swap kar do
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // j ko aage badha do
            }
        }
    }
}