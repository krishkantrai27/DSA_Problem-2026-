class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        if cost1 + cost2 <= costBoth:
            return cost1 * need1 + cost2 * need2

        common = min(need1, need2)
        ans = common * costBoth

        if need1 > need2:
            ans += (need1 - common) * min(cost1, costBoth)
        else:
            ans += (need2 - common) * min(cost2, costBoth)

        return ans