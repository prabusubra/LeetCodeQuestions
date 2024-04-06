class Solution {
    public int sumSubarrayMins(int[] arr) {
    int m = 1_000_000_007;
    int[] lse = new int[arr.length];
    int[] rse = new int[arr.length];

    Arrays.fill(lse, -1);
    Arrays.fill(rse, arr.length);

    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < lse.length; i++) {
        //find minimun number index from stack and set it in lse array for ith value.
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }

        if (!stack.isEmpty()){
            lse[i] = stack.peek();
        }

        stack.push(i);
    }

    stack.clear();
    stack.push(arr.length-1);
    for (int i = arr.length-2; i >=0; i--) {
        //find minimun number index from stack and set it in lse array for ith value.
        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            stack.pop();
        }
        if (!stack.isEmpty()){
            rse[i] = stack.peek();
        }

        stack.push(i);
    }
    long sum=0;
    for (int i = 0; i < arr.length; i++) {
        long leftRange = i-lse[i];
        int rightRange = rse[i] - i;
        sum = sum%m + leftRange%m*rightRange%m*arr[i]%m;
    }

    return (int)sum;
    }
}