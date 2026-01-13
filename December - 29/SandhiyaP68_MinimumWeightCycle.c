#include <stdio.h>

#define INF 1000000000

int min(int a, int b) {
    return a < b ? a : b;
}

int main() {
    int V, E;
    scanf("%d", &V);
    scanf("%d", &E);

    int dist[505][505];

    // Initialize distance matrix
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i == j)
                dist[i][j] = 0;
            else
                dist[i][j] = INF;
        }
    }

    int u, v, w;
    for (int i = 0; i < E; i++) {
        scanf("%d %d %d", &u, &v, &w);
        if (w < dist[u][v]) {
            dist[u][v] = w;
            dist[v][u] = w;
        }
    }

    int answer = INF;

    // Floyd–Warshall with cycle detection
    for (int k = 0; k < V; k++) {

        // Check cycles involving k
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (dist[i][j] != INF &&
                    dist[i][k] != INF &&
                    dist[k][j] != INF) {

                    int cycle = dist[i][j] + dist[i][k] + dist[k][j];
                    answer = min(answer, cycle);
                }
            }
        }

        // Standard Floyd–Warshall update
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    if (answer == INF)
        printf("-1");
    else
        printf("%d", answer);

    return 0;
}
