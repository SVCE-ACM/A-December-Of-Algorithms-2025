#include <stdio.h>
#define MAXV 500
int main() {
    int V, E;
    printf("Enter V (number of vertices): ");
    scanf("%d", &V);
    printf("Enter number of edges: ");
    scanf("%d", &E);
    int edges[MAXV][MAXV] = {0};
    int u, v, w;
    printf("Enter each edge in format: u v w (0-based vertices and weight w):\n");
    for (int i = 0; i < E; i++) {
        scanf("%d %d %d", &u, &v, &w);
        if (edges[u][v] == 0 || w < edges[u][v]) {
            edges[u][v] = w;
            edges[v][u] = w;
        }
    }
    int dist[MAXV][MAXV] = {0};
    for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
            dist[i][j] = edges[i][j];
    int minCycle = 0;
    for (int k = 0; k < V; k++) {
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (i != j && i != k && j != k && edges[i][k] && edges[k][j]) {
                    if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
        for (int i = 0; i < k; i++)
            for (int j = i+1; j < k; j++)
                if (edges[i][k] && edges[k][j] && dist[i][j]) {
                    int cycleWeight = edges[i][k] + edges[k][j] + dist[i][j];
                    if (minCycle == 0 || cycleWeight < minCycle)
                        minCycle = cycleWeight;
                }
    }
    if (minCycle == 0)
        printf("No cycle exists in the graph.");
    else
        printf("Minimum total weight of a cycle: %d\n", minCycle);
    return 0;
}
