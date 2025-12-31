#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
    int v;
    int w;
} Edge;

typedef struct {
    Edge *edges;
    int count;
} AdjList;

int main() {
    int N, M;
    scanf("%d", &N);
    scanf("%d", &M);

    AdjList *adj = (AdjList *)malloc(N * sizeof(AdjList));
    for (int i = 0; i < N; i++) {
        adj[i].edges = (Edge *)malloc(M * sizeof(Edge));
        adj[i].count = 0;
    }

    for (int i = 0; i < M; i++) {
        int u, v, t;
        scanf("%d %d %d", &u, &v, &t);
        adj[u].edges[adj[u].count++] = (Edge){v, t};
    }

    int S;
    scanf("%d", &S);

    int dist[501];
    int visited[501];

    for (int i = 0; i < N; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }

    dist[S] = 0;

    for (int i = 0; i < N; i++) {
        int u = -1;
        int minDist = INT_MAX;
        for (int j = 0; j < N; j++) {
            if (!visited[j] && dist[j] < minDist) {
                minDist = dist[j];
                u = j;
            }
        }

        if (u == -1) break;

        visited[u] = 1;

        for (int k = 0; k < adj[u].count; k++) {
            int v = adj[u].edges[k].v;
            int w = adj[u].edges[k].w;
            if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INT_MAX) {
            printf("-1");
            return 0;
        }
        if (dist[i] > result) result = dist[i];
    }

    printf("%d", result);
    return 0;
}
