class Solution(object):
    def checkString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)

        for i in range(0, n-1):
            if s[i] == 'b' and s[i+1] == 'a' :
                return False 
        
        return True