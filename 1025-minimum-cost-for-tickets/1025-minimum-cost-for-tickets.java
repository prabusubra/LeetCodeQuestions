class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Determine the last day of travel
        int lastTravelDay = days[days.length - 1];
        int[] dp = new int[lastTravelDay + 1];

        // Store travel days in a set for quick lookup
        Set<Integer> travelDaySet = new HashSet<>();
        for (int day : days) {
            travelDaySet.add(day);
        }

        // Fill the dp array for each day
        for (int day = 1; day <= lastTravelDay; day++) {
            if (!travelDaySet.contains(day)) {
                // If not traveling, the cost is the same as the previous day
                dp[day] = dp[day - 1];
            } else {
                // Calculate the cost for 1-day, 7-day, and 30-day tickets
                int cost1Day = dp[day - 1] + costs[0];
                int cost7Day = dp[Math.max(0, day - 7)] + costs[1];
                int cost30Day = dp[Math.max(0, day - 30)] + costs[2];

                // Take the minimum of the three options
                dp[day] = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
            }
        }

        // Return the total cost up to the last travel day
        return dp[lastTravelDay];
    }
}