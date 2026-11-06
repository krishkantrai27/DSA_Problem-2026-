class Solution:
    def countServers(self, n, logs, x, queries):
        m = len(logs)
        # Sort logs by time (index 1)
        logs.sort(key=lambda a: a[1])
        q = len(queries)
        # Store {query_time, original_index}
        timeIndex = [[queries[i], i] for i in range(q)]
        # Sort queries by time
        timeIndex.sort(key=lambda a: a[0])
        # server_id -> count of requests in current window
        mp = {}
        result = [0] * q
        i, j = 0, 0

        for curtime, ind in timeIndex:

            start = curtime - x
            end = curtime

            # Right Expand: Add logs with time <= end
            while j < m and logs[j][1] <= end:

                serverId = logs[j][0]

                mp[serverId] = mp.get(serverId, 0) + 1

                j += 1

            # Left Shrink: Remove logs with time < start
            while i < m and logs[i][1] < start:

                serverId = logs[i][0]

                mp[serverId] -= 1

                if mp[serverId] == 0:
                    del mp[serverId]

                i += 1

            # Count servers that received zero requests
            result[ind] = n - len(mp)

        return result
