class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        
        def canDivide(maxBalls):
            ops = 0
            for balls in nums:
                if balls > maxBalls:
                    ops += (balls - 1)// maxBalls

            return ops <= maxOperations

        # binary search

        left, right = 1, max(nums)

        result = right

        while left <= right:
            mid = (left + right) // 2
            if canDivide(mid):
                result = mid
                right = mid -1
            else:
                left = mid + 1
        
        return result
