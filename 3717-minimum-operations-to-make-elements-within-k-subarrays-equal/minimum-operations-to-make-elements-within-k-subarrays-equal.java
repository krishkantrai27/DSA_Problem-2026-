
import java.util.*;

class Solution {

    // Fenwick Tree / Binary Indexed Tree
    static class Fenwick {
        long[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void add(int index, long value) {
            while (index <= n) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long sum(int index) {
            long result = 0;

            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }

            return result;
        }

        // Find index of the kth smallest element
        int kth(long k) {
            int index = 0;

            for (int step = Integer.highestOneBit(n);
                 step > 0; step >>= 1) {

                int next = index + step;

                if (next <= n && tree[next] < k) {
                    index = next;
                    k -= tree[next];
                }
            }

            return index + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int value : sorted) {
            if (m == 0 || sorted[m - 1] != value) {
                sorted[m++] = value;
            }
        }

        int[] values = Arrays.copyOf(sorted, m);

        int[] compressed = new int[n];

        for (int i = 0; i < n; i++) {
            compressed[i] =
                Arrays.binarySearch(values, nums[i]) + 1;
        }

        // Step 2: Two Fenwick Trees
        Fenwick countBIT = new Fenwick(m);
        Fenwick sumBIT = new Fenwick(m);

        // Insert first window
        long windowSum = 0;

        for (int i = 0; i < x; i++) {
            countBIT.add(compressed[i], 1);
            sumBIT.add(compressed[i], nums[i]);
            windowSum += nums[i];
        }

        // Step 3: Calculate cost of every window
        long[] cost = new long[n - x + 1];

        for (int start = 0; start <= n - x; start++) {

            // Lower median
            int medianIndex = countBIT.kth((x + 1L) / 2);

            long median = values[medianIndex - 1];

            // Elements <= median
            long leftCount = countBIT.sum(medianIndex);
            long leftSum = sumBIT.sum(medianIndex);

            // Elements > median
            long rightCount = x - leftCount;
            long rightSum = windowSum - leftSum;

            // Minimum operations to make window equal
            cost[start] =
                median * leftCount - leftSum
                + rightSum - median * rightCount;

            // Slide window
            if (start < n - x) {

                // Remove outgoing element
                countBIT.add(compressed[start], -1);
                sumBIT.add(compressed[start], -nums[start]);
                windowSum -= nums[start];

                // Add incoming element
                int next = start + x;

                countBIT.add(compressed[next], 1);
                sumBIT.add(compressed[next], nums[next]);
                windowSum += nums[next];
            }
        }

        // Step 4: Dynamic Programming
        // prev[i] = minimum cost to select j-1 windows
        // from first i elements

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                curr[i] = curr[i - 1];

                // Option 2: Select window ending at i-1
                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
