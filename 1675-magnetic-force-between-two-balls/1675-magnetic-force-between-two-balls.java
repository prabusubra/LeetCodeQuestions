class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);

        int low = 1, high = position[position.length-1] - position[0], result = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (minMaxDistance(position, m, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean minMaxDistance(int[] position, int m, int distance) {
        int count = 1, last = position[0];

        for (int i = 1; i< position.length; i++) {

            if (position[i] - last >= distance) {
                count += 1;
                last = position[i];
            }

            if (count == m) {
                return true;
            }

        }

        return false;
    }
}