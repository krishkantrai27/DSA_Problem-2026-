class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Every possible subarray of size k
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Put all elements of current subarray into set
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count this subarray only once for every unique number
            for (int x : set) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one subarray
        for (int x : map.keySet()) {
            if (map.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}