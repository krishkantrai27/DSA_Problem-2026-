class Solution(object):
    def longestMonotonicSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        plus = 1 
        minus = 1 
        ans = 1 

        for i in range (1 , len(nums)):
            if nums[i-1] > nums[i]:
                plus += 1
            else :
                plus = 1

            if nums[i-1] < nums[i]:
                minus += 1
            else :
                minus = 1
            ans = max(ans,max(plus,minus))

        return ans    