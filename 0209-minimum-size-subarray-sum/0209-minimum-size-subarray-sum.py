class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left, total, = 0, 0

        minLen = float('inf')

        for i in range(len(nums)):
            total += nums[i]
            
            while target <= total:
                currLen = i - left + 1
                minLen = min(minLen, currLen)
                total -= nums[left]
                left += 1

        return 0 if minLen == float('inf') else minLen

