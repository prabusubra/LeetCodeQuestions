func twoSum(nums []int, target int) []int {
    
    tmpmap := make(map[int]int)
    
    for i:= 0; i < len(nums); i++ {
        b := target - nums[i]
        value, exist := tmpmap[b]
        if exist {
            return [] int{value, i}
        } else {
            tmpmap[nums[i]] = i
        }
    }
    return nil
    
}