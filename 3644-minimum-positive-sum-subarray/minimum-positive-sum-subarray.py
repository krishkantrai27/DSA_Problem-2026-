class Solution(object):
    def minimumSumSubarray(self, nums, l, r):
        n = len(nums)

        prefixSum = [0] * n

        prefixSum[0] = nums[0]

        for i in range(1, n):
            prefixSum[i] = prefixSum[i - 1] + nums[i]

        result = float('inf')

        for i in range(n):
            for length in range(l, r + 1):

                if i + length > n:
                    break

                j = i + length - 1

                total = prefixSum[j] - (prefixSum[i - 1] if i > 0 else 0)

                if total > 0:
                    result = min(result, total)

        return result if result != float('inf') else -1