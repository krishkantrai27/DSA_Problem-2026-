class Solution:

    def minMoves(self, nums: list[int]) -> int:
        """Observation: n-1 elements ko increment karna = 1 element ko decrement karna.

        Target: Minimum element ko target banana hai.
        Formula: Total Moves = Σ(nums[i] - min)
        """
        minimum = min(nums)
        moves = 0
        for num in nums:
            moves += num - minimum

        return moves