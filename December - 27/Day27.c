#include <stdio.h>
#define INF 1000000000

int main() {
    int N, M;
    scanf("%d", &N);
    scanf("%d", &M);

    int graph[100][100];

    // Initialize graph with INF
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            graph[i][j] = INF;
        }
    }

    // Read edges
    for (int i = 0; i < M; i++) {
        int u, v, t;
        scanf("%d %d %d", &u, &v, &t);
        graph[u][v] = t;
    }

    int S;
    scanf("%d", &S);

    int dist[100];
    int visited[100] = {0};

    // Initialize distances
    for (int i = 0; i < N; i++) {
        dist[i] = INF;
    }
    dist[S] = 0;

    // Dijkstra
    for (int i = 0; i < N; i++) {
        int minDist = INF;
        int u = -1;

        // Find unvisited node with minimum distance
        for (int j = 0; j < N; j++) {
            if (!visited[j] && dist[j] < minDist) {
                minDist = dist[j];
                u = j;
            }
        }

        if (u == -1) break;

        visited[u] = 1;

        // Relax edges
        for (int v = 0; v < N; v++) {
            if (!visited[v] && graph[u][v] != INF) {
                if (dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }

    // Find maximum time
    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INF) {
            printf("-1\n");
            return 0;
        }
        if (dist[i] > ans)
            ans = dist[i];
    }

    printf("%d\n", ans);
    return 0;
}
