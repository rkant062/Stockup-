package Java;

import java.util.*;

public class CourseSchedule {
    private Map<String, List<String>> graph = new HashMap<>();
    private Map<String, Boolean> visited = new HashMap<>();

    // Create the adjacency list from the input edges
    public void createAdjList(List<List<String>> input) {
        for (List<String> edge : input) {
            String a = edge.get(0);
            String b = edge.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        }
    }

    // Depth-First Search (DFS) function
    public void dfs(String u, List<String> s) {
        visited.put(u, true);
        for (String v : graph.getOrDefault(u, new ArrayList<>())) {
            if (!visited.getOrDefault(v, false)) {
                dfs(v, s);
            }
        }
        s.add(u);
    }

    // The solve function performs the overall task
    public String solve(List<List<String>> input) {
        visited.clear();
        graph.clear();
        createAdjList(input);
        List<String> s = new ArrayList<>();

        // Perform DFS for all unvisited nodes
        for (String u : graph.keySet()) {
            if (!visited.getOrDefault(u, false)) {
                dfs(u, s);
            }
        }

        // Reverse the list to get the topological sort order
        Collections.reverse(s);

        // Get the middle node of the topologically sorted list
        int n = s.size();
        int mid = (n % 2 == 0 ? (n / 2 - 1) : (n / 2));
        return s.get(mid);
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("A", "B"));
        input.add(Arrays.asList("B", "C"));
        input.add(Arrays.asList("C", "D"));

        String result = solution.solve(input);
        System.out.println("Middle element in topological order: " + result);
    }
    
}
