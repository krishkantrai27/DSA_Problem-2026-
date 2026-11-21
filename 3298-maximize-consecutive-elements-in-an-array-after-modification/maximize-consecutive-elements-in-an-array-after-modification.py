class Solution:
    def findMethod(self, nums, start, target):
        lo, hi = start, self.n

        while lo < hi:
            mid = (lo + hi) // 2

            if nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid

        if lo < self.n and nums[lo] == target:
            return lo

        return -1

    def solve(self, i, inc, nums):
        if self.memo[i][inc] != -1:
            return self.memo[i][inc]

        curr_val = nums[i] + inc
        ans = 1

        # Option 1
        j = self.findMethod(nums, i + 1, curr_val + 1)
        if j != -1:
            ans = max(ans, 1 + self.solve(j, 0, nums))

        # Option 2
        j = self.findMethod(nums, i + 1, curr_val)
        if j != -1:
            ans = max(ans, 1 + self.solve(j, 1, nums))

        self.memo[i][inc] = ans
        return ans

    def maxSelectedElements(self, nums):
        self.n = len(nums)

        nums.sort()

        self.memo = [[-1] * 2 for _ in range(self.n)]

        result = 1

        for i in range(self.n):
            result = max(
                result,
                self.solve(i, 0, nums),
                self.solve(i, 1, nums)
            )

        return result