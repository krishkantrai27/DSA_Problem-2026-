class Solution(object):
    def minMoves(self, nums):
        maximum = max(nums)
        moves = 0 
        for n in nums :
            moves += maximum - n
        return moves
        