class Solution(object):
    def minimumSumSubarray(self, nums, l, r):
        n = len(nums)

        # Step 1: Create Prefix Sum Array
        prefixSum = [0] * (n + 1)

        for i in range(n):
            prefixSum[i + 1] = prefixSum[i] + nums[i]

        # Step 2: Store minimum positive sum
        result = float('inf')

        # Step 3: Generate all subarrays
        for i in range(n):

            for j in range(i + l, min(n, i + r) + 1):

                # Step 4: Calculate subarray sum
                sum = prefixSum[j] - prefixSum[i]

                # Step 5: Check positive sum
                if sum > 0:
                    result = min(result, sum)

        # Step 6: Return answer
        return -1 if result == float('inf') else result
        