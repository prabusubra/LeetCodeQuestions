class Solution {
    public int findDuplicate(int[] nums) {
        return Arrays.stream(nums).parallel().boxed().collect(Collectors.groupingBy(d -> d, Collectors.counting()))
                .entrySet().stream().filter( d -> d.getValue() >1 ).findFirst().get().getKey().intValue();
    }
}