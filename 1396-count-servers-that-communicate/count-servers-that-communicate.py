class Solution(object):
    def countServers(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])

        idxCol = [0] * n 
        idxRow = [0] * m 

        ''' Preprocessing '''
        for row in range(m):
            for col in range(n):
                if grid[row][col] == 1 :
                    idxRow[row] +=1
                    idxCol[col] +=1
                    
        result = 0 
        for row in range(m):
            for col in range(n):
                if grid[row][col] == 1 and (idxRow[row] > 1 or idxCol[col] > 1) :
                    result+=1 
        
        return result
        
        