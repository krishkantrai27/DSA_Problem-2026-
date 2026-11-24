class Solution:
    def maxLength(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            prod = 1
            lcm = 1
            gcd = 0
            for j in range(i, n):
                prod *= nums[j]
                lcm = self.findlcm(lcm, nums[j])
                gcd = self.findgcd(gcd, nums[j])
                
                if prod == lcm * gcd:
                    ans = max(ans, j - i + 1)
        return ans

    # To Find LCM
    def findlcm(self, a: int, b: int) -> int:
        num = a
        while True:
            if num % b == 0:
                return num
            num += a

    # Support To find GCD
    def findgcd(self, a: int, b: int) -> int:
        if b == 0:
            return a
        return self.findgcd(b, a % b)