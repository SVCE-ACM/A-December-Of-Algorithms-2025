/*
 * Problem: Minimum Weight Cycle in an Undirected Weighted Graph
 *
 * Approach:
 * ---------
 * Use Modified Floyd–Warshall to detect smallest cycle.
 *
 * Core Idea:
 * For each vertex k:
 *   Before updating shortest paths using k,
 *   try to form cycles using edges (i, k) + (k, j) + existing shortest path i -> j
 *
 * This finds minimum cycle length efficiently.
 *
 * Complexity:
 * Time  : O(V^3)
 * Space : O(V^2)
 */

import java.util.*;

public class Main {

    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] dist = new int[V][V];

        for (int[] row : dist)
            Arrays.fill(row, INF);

        for (int i = 0; i < V; i++)
            dist[i][i] = 0;

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        int ans = INF;

        // Floyd-Warshall enhanced for minimum cycle detection
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = i + 1; j < V; j++) {
                    if (i != k && j != k &&
                            dist[i][k] != INF &&
                            dist[k][j] != INF &&
                            dist[i][j] != INF) {

                        ans = Math.min(ans, dist[i][j] + dist[i][k] + dist[k][j]);
                    }
                }
            }

            // Standard Floyd update
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}
