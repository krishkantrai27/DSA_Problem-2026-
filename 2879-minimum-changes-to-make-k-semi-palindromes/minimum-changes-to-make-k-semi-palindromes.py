class Solution:

    def getCost(self, i, j):
        length = j - i + 1

        minCost = float('inf')

        for d in range(1, length):

            if length % d != 0:
                continue

            cost = 0

            # For d, we will have d groups
            for group in range(d):

                l = i + group
                r = l + (length // d - 1) * d

                while l < r:

                    if self.str[l] != self.str[r]:
                        cost += 1

                    l += d
                    r -= d

            minCost = min(minCost, cost)

        return minCost

    def minimumChanges(self, s: str, k: int) -> int:
        
        self.n = len(s)
        self.str = s

        n = self.n

        # Step 1: Precompute substring costs
        costMemo = [[float('inf')] * n for _ in range(n)]

        for i in range(n):
            for j in range(i + 1, n):
                costMemo[i][j] = self.getCost(i, j)

        # Step 2: Initialize DP
        memo = [[float('inf')] * (k + 1) for _ in range(n + 1)]

        memo[n][0] = 0

        # Step 3: Bottom-up DP
        for start in range(n, -1, -1):

            for pieces in range(1, k + 1):

                if start + 2 * pieces > n:
                    continue

                result = float('inf')

                for end in range(start + 1, n):

                    remainCost = memo[end + 1][pieces - 1]

                    if remainCost == float('inf'):
                        continue

                    result = min(
                        result,
                        costMemo[start][end] + remainCost
                    )

                memo[start][pieces] = result

        return memo[0][k]
