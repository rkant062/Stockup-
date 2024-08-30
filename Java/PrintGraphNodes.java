package Java;

import java.util.*;

 class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency Lists

     public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Function to print the graph in 2D representation
    void printGraphIn2D(int start) {
        boolean[] visited = new boolean[V];
        printGraphDFS(start, visited, 0, "");
    }

    // Helper function for DFS traversal and printing
    private void printGraphDFS(int node, boolean[] visited, int level, String indent) {
        visited[node] = true;
        
        // Print the current node with the appropriate indentation
        System.out.println(indent + node);

        // Set up the new indentation for child nodes
        String newIndent = indent + (level == 0 ? "   " : "    ");

        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i < adj[node].size(); i++) {
            Integer child = adj[node].get(i);
            if (!visited[child]) {
                if (i == adj[node].size() - 1) {
                    // Last child: use "\"
                    printGraphDFS(child, visited, level + 1, newIndent + "\\-- ");
                } else {
                    // Not the last child: use "/"
                    printGraphDFS(child, visited, level + 1, newIndent + "|-- ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(3);

        g.addEdge(0, 1);
        g.addEdge(0, 2);

        System.out.println("Graph representation in 2D:");
        g.printGraphIn2D(0);
    }
}
