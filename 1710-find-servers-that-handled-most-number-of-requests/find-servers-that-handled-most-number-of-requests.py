
from sortedcontainers import SortedList
import heapq

class Solution:
    def busiestServers(self, k, arrival, load):

        # 1. Store all available servers
        aval = SortedList(range(k))

        # 2. Min Heap: (finishTime, serverId)
        busy = []

        # 3. Count requests handled by each server
        cntServer = [0] * k

        for i in range(len(arrival)):

            time = arrival[i]

            # 4. Release servers whose requests are completed
            while busy and busy[0][0] <= time:
                finishTime, server = heapq.heappop(busy)
                aval.add(server)

            # 5. If no server is available, drop request
            if not aval:
                continue

            # 6. Find starting server
            target = i % k

            # 7. Find next available server using binary search
            idx = aval.bisect_left(target)

            # Circular wrap-around
            if idx == len(aval):
                idx = 0

            targetServer = aval.pop(idx)

            # 8. Assign request to selected server
            finishTime = time + load[i]

            heapq.heappush(busy, (finishTime, targetServer))

            # 9. Increment request count
            cntServer[targetServer] += 1

        # 10. Find maximum requests handled
        maxRequest = max(cntServer)

        # 11. Return all busiest servers
        result = []

        for i in range(k):
            if cntServer[i] == maxRequest:
                result.append(i)

        return result
