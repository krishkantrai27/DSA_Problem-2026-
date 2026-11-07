import heapq

class Solution:
    def assignTasks(self, servers, tasks):
        n = len(servers)
        m = len(tasks)

        free_servers = [(servers[i], i) for i in range(n)]
        heapq.heapify(free_servers)

        busy_servers = []

        result = [0] * m

        for i in range(m):
            while busy_servers and busy_servers[0][0] <= i:
                _, wt, idx = heapq.heappop(busy_servers)
                heapq.heappush(free_servers, (wt, idx))

            if not free_servers:
                fin_time, wt, idx = heapq.heappop(busy_servers)
                result[i] = idx
                heapq.heappush(busy_servers, (fin_time + tasks[i], wt, idx))
            else:
                wt, idx = heapq.heappop(free_servers)
                result[i] = idx
                heapq.heappush(busy_servers, (i + tasks[i], wt, idx))

        return result