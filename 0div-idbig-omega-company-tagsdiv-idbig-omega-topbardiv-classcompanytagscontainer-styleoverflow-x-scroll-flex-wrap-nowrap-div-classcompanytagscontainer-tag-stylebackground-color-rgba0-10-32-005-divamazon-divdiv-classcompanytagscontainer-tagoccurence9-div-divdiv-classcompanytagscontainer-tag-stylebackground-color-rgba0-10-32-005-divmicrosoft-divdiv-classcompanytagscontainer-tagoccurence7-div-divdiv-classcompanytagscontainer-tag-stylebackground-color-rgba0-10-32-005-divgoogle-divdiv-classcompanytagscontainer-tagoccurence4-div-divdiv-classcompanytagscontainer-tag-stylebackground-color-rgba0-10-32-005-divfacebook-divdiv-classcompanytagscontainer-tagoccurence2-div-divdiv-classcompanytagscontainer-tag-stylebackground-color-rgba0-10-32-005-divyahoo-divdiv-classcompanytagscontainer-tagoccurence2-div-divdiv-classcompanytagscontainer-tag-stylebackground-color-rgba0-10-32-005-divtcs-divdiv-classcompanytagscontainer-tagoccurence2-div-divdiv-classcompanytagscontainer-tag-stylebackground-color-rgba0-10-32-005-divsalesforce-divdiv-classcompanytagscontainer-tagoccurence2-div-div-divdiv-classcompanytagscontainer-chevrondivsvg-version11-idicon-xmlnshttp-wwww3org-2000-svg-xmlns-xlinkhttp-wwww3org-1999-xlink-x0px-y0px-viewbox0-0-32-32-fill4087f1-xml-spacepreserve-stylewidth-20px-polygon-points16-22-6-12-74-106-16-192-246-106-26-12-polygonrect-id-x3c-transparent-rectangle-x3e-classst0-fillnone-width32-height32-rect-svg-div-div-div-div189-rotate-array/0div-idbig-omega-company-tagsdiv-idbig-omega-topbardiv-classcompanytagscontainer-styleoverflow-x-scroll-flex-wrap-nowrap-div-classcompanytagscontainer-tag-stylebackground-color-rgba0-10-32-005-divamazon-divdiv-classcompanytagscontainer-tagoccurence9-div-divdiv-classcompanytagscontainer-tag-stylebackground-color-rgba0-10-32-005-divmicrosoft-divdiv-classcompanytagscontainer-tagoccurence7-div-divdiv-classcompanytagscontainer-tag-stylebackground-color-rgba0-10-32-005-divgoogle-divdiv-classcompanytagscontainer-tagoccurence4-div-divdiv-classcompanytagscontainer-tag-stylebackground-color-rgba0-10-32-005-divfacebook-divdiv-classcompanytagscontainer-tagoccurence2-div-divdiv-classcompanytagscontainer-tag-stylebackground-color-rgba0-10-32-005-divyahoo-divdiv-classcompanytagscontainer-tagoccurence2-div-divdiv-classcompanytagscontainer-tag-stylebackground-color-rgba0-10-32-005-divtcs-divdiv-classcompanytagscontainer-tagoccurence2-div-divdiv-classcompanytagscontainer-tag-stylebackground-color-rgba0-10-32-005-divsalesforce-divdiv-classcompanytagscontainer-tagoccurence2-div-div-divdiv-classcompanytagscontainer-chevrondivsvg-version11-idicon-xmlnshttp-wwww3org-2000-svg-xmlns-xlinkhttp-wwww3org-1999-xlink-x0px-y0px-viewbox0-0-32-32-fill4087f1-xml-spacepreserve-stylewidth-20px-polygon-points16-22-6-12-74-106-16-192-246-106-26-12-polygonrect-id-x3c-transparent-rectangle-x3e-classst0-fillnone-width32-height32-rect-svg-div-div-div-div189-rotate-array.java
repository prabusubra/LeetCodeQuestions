class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length > 1){
         k= k % nums.length;
        int len = nums.length;
        int[] arr = new int[len];

        for (int i=0; (i+k) < nums.length;i++){ //4-2 = 2-2
            arr[i+k] = nums[i];
           // System.out.print("\n --> 1 : "+arr[i]);
        }

        for (int i=len-k; i<nums.length;i++){//0+k+1
            arr[(i+k)%len] = nums[i];
           // System.out.print("\n --> 2 : "+arr[i]);
        }


        for (int i=0; i<arr.length;i++){
            nums[i] = arr[i];
            //System.out.print("\n --> 3 : "+arr[i]);
        }
        }
        
    }
        
    
    
}