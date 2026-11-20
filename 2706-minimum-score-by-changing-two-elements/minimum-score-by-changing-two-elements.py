class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        n = len(nums)

        nums.sort()

        ans = float('inf')

        for i in range(3):
            ans = min(ans, nums[n - 1 - i] - nums[2 - i])

        return ans  