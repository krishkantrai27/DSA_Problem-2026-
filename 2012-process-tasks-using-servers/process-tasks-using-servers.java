import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // free servers: {wt, idx}, smallest (wt, idx) first
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        // busy servers: {finTime, wt, idx}, smallest (finTime, wt, idx) first
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            freeServers.add(new int[]{servers[i], i});
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            // Busy Servers ---> Free Servers
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                int[] cur = busyServers.poll();
                freeServers.add(new int[]{cur[1], cur[2]});
            }

            if (freeServers.isEmpty()) {
                // nobody free: wait for the earliest finishing server
                int[] cur = busyServers.poll();
                result[i] = cur[2];
                busyServers.add(new int[]{cur[0] + tasks[i], cur[1], cur[2]});
            } else {
                // Free Servers ---> Busy Servers, starts right now at time i
                int[] cur = freeServers.poll();
                result[i] = cur[1];
                busyServers.add(new int[]{i + tasks[i], cur[0], cur[1]});
            }
        }

        return result;
    }
}