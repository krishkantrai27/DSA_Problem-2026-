
import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            // Release all servers that are free
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] s = busy.poll();
                available.offer(new int[]{s[1], s[2]});
            }

            // If no server is available, jump to next free time
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] s = busy.poll();
                    available.offer(new int[]{s[1], s[2]});
                }
            }

            // Assign task to the best available server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            // Store server with its next free time
            busy.offer(new int[]{
                (int)(time + tasks[j]), weight, index
            });
        }

        return ans;
    }
}
