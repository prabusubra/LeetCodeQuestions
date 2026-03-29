class Solution {
    public int[][] merge(int[][] intervals) {
     
      Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));


        System.out.println("Result : "+intervals);

        List<int[]> result = new ArrayList<>();

        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals) {
            //System.out.println("Intervals : "+ interval[0] + " -- > " +interval[1]);

            if (result.isEmpty()) {
                result.add(interval);
                continue;
                };

            int currStart = interval[0];

            int[] prevInterval = result.getLast();

            //Non-Overlapping
            if (prevInterval[1] < currStart) {
                result.add(interval);
            } else {
                //overlapping
                //System.out.println("Intervals : "+ interval[1] + " -- > " +prevInterval[1]);

                result.getLast()[1] = Math.max(prevInterval[1], interval[1]);
            }

        }

        return result.toArray(new int[res.size()][res.size()]);

    }
}