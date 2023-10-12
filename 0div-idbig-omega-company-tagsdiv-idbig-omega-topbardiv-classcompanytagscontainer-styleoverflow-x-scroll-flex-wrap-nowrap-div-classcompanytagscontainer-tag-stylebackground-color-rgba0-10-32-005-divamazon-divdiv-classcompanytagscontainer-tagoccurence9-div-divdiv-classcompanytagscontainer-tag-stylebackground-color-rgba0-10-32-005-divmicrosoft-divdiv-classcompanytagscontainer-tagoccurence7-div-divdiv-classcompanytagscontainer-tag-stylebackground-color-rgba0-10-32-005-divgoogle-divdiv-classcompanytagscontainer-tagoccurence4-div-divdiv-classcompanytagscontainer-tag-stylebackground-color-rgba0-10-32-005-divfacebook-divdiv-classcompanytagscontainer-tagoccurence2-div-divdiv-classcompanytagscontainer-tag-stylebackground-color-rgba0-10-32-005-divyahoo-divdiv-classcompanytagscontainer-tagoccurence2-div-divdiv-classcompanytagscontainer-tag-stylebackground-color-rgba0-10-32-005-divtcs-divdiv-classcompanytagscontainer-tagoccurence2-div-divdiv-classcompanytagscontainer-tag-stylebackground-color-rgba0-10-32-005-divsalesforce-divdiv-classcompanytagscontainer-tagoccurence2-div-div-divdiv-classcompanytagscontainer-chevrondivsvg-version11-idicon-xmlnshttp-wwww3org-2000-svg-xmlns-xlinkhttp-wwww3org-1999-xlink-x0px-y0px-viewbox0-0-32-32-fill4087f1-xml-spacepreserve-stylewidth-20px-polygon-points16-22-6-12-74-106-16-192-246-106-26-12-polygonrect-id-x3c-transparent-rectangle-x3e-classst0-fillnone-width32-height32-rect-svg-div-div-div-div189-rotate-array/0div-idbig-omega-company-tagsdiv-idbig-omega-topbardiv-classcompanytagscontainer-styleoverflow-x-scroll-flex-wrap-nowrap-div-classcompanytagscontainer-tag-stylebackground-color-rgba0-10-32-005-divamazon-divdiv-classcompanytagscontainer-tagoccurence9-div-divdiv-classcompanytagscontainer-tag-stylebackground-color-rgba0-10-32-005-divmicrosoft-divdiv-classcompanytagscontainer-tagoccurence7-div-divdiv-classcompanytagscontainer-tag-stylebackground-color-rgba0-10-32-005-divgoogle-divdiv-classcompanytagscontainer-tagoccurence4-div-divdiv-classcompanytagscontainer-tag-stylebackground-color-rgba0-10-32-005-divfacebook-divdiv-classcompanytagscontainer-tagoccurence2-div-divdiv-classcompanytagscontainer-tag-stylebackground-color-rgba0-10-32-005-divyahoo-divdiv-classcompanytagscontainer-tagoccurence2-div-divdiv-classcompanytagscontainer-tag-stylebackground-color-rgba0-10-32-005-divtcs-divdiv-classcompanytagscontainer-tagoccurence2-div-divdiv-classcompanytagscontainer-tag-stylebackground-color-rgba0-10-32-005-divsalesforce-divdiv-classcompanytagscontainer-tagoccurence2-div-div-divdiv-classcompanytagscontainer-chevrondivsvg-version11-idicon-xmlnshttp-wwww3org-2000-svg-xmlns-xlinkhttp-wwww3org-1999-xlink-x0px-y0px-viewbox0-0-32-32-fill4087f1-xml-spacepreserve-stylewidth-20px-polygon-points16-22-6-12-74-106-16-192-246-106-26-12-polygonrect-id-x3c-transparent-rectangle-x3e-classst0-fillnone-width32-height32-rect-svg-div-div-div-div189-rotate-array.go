func rotate(nums []int, k int)  {
    k = k%len(nums)
    reverse(nums, 0, len(nums)-1)
    reverse(nums, 0, k-1)
    reverse(nums, k, len(nums)-1)
}

func reverse(nums []int, start int, end int) {
    j := end
    for i:=start; i < j; i++ {
        
        tmp := nums[i]
        
        nums[i] = nums[j]
        
        nums[j] = tmp;
        j--;
    }
    
}