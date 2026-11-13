
from collections import deque
from typing import List

class Solution:
    def countNonDecreasingSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)

        # Prefix Sum
        cumSum = [0] * n
        cumSum[0] = nums[0]

        for i in range(1, n):
            cumSum[i] = nums[i] + cumSum[i - 1]

        # Range Sum Function
        def rangeSum(i, j):
            if i > j:
                return 0

            return cumSum[j] - (cumSum[i - 1] if i > 0 else 0)

        # Next Greater Element (NGR)
        NGR = [n] * n
        st = []

        for i in range(n):
            while st and nums[st[-1]] < nums[i]:
                NGR[st.pop()] = i

            st.append(i)

        # Operations Array
        Operations = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            m = NGR[i]

            segmentOprns = (nums[i] * (m - i)) - rangeSum(i, m - 1)

            Operations[i] = segmentOprns + Operations[m]

        # Sliding Window + Monotonic Deque
        deq = deque()

        result = 0
        i = 0
        j = 0

        while j < n:

            # Maintain decreasing order
            while deq and nums[deq[-1]] < nums[j]:
                deq.pop()

            deq.append(j)

            # Shrink window if required
            while i <= j:
                m = deq[0]

                oprnsCount = (
                    (Operations[i] - Operations[m])
                    + (nums[m] * (j - m + 1))
                    - rangeSum(m, j)
                )

                if oprnsCount <= k:
                    break

                i += 1

                if deq[0] < i:
                    deq.popleft()

            result += (j - i + 1)
            j += 1

        return result