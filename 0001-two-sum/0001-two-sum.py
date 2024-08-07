class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map1 = {}
        for i in range(len(nums)):
            b = target - nums[i]
            if map1.get(b) != None:
                return [map1.get(b), i]
            else:
                map1[nums[i]] = i
        return