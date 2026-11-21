from collections import defaultdict

class Solution:
    def dfs(self, currNode, s, parent):
        c = ord(s[currNode]) - ord('a')

        nearestAncestor = self.last[c]

        self.last[c] = currNode

        for child in self.adj[currNode]:
            self.dfs(child, s, parent)

        self.last[c] = nearestAncestor

        if currNode != 0:
            newParent = parent[currNode]

            if nearestAncestor != -1:
                newParent = nearestAncestor

            parent[currNode] = newParent
            self.resultSize[newParent] += self.resultSize[currNode]

    def findSubtreeSizes(self, parent, s):
        n = len(parent)

        self.adj = defaultdict(list)

        for i in range(1, n):
            u = parent[i]
            self.adj[u].append(i)

        self.resultSize = [1] * n
        self.last = [-1] * 26

        self.dfs(0, s, parent)

        return self.resultSize
