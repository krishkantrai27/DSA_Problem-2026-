class Solution(object):
    def digitSum(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        while len(s) > k:

            result = []
            start = 0

            while start < len(s):

                end = min(start + k, len(s))
                total = 0

                for i in range(start, end):
                    total += int(s[i])

                result.append(str(total))
                start += k

            s = "".join(result)

        return s
