class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>(); // Tracks color of each ball
        Map<Integer, Integer> colorCount = new HashMap<>(); // Tracks count of each color
        int[] result = new int[queries.length];
        int distinctColors = 0;

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If ball already has a color, reduce its previous color count
            if (ballToColor.containsKey(ball)) {
                int prevColor = ballToColor.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                    distinctColors--;
                }
            }

            // Assign the new color
            ballToColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            // If this color was newly introduced, increase distinctColors count
            if (colorCount.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }

        return result;
    }
}