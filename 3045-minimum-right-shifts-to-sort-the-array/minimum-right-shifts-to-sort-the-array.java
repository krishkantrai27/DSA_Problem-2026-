import java.util.List;

class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int count = 0; // Drop points count karne ke liye
        int dropIndex = -1; // Drop point ka index store karne ke liye

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                count++;
                dropIndex = i;
            }
        }

        // Case 1: Agar koi drop point nahi hai, array pehle se sorted hai
        if (count == 0) {
            return 0;
        }

        // Case 2: Agar ek se zyada drop points hain, sort karna impossible hai
        if (count > 1) {
            return -1;
        }

        // Case 3: Ek drop point hai, toh check karein ki circular rotation valid hai ya nahi
        // Last element pehle element se chhota nahi hona chahiye rotated sorted array mein
        if (nums.get(n - 1) > nums.get(0)) {
            return -1;
        }

        // Required right shifts: n - 1 - dropIndex
        return n - 1 - dropIndex;
    }
}