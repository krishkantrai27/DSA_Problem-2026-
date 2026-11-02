class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        nums.sort()
        n = len(nums)
        median = nums[n // 2] 
        sum = 0 
        for n in nums :
            sum += abs(median - n)
        
        return sum