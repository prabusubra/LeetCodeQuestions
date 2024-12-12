class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(graph, 0, curr, result);

        return result;

    }

    private static void backtrack(int[][] graph, int node, List<Integer> curr, List<List<Integer>> res)  {
        curr.add(node);

        //base
        if (node == graph.length - 1 ) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int neig: graph[node]) {
                backtrack(graph, neig, curr, res);
            }
        }
        
        curr.remove(curr.size()-1);

    }
}