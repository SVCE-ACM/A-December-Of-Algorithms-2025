#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
    int to;
    int w;
} Edge;

typedef struct {
    Edge *edges;
    int count;
} Adj;

typedef struct {
    int v;
    int dist;
} Node;

int V, E;
Adj *adj;

int dijkstra(int src, int dst, int skip_u, int skip_v) {
    int dist[501];
    int used[501];

    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
        used[i] = 0;
    }

    dist[src] = 0;

    for (int i = 0; i < V; i++) {
        int u = -1;
        int best = INT_MAX;
        for (int j = 0; j < V; j++) {
            if (!used[j] && dist[j] < best) {
                best = dist[j];
                u = j;
            }
        }

        if (u == -1) break;
        used[u] = 1;

        for (int k = 0; k < adj[u].count; k++) {
            int v = adj[u].edges[k].to;
            int w = adj[u].edges[k].w;

            if ((u == skip_u && v == skip_v) || (u == skip_v && v == skip_u))
                continue;

            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    return dist[dst];
}

int main() {
    scanf("%d", &V);
    scanf("%d", &E);

    adj = (Adj *)malloc(V * sizeof(Adj));
    for (int i = 0; i < V; i++) {
        adj[i].edges = (Edge *)malloc(V * sizeof(Edge));
        adj[i].count = 0;
    }

    int *U = (int *)malloc(E * sizeof(int));
    int *W = (int *)malloc(E * sizeof(int));
    int *VV = (int *)malloc(E * sizeof(int));

    for (int i = 0; i < E; i++) {
        int u, v, w;
        scanf("%d %d %d", &u, &v, &w);
        U[i] = u;
        VV[i] = v;
        W[i] = w;

        adj[u].edges[adj[u].count++] = (Edge){v, w};
        adj[v].edges[adj[v].count++] = (Edge){u, w};
    }

    int ans = INT_MAX;

    for (int i = 0; i < E; i++) {
        int u = U[i];
        int v = VV[i];
        int w = W[i];

        int d = dijkstra(u, v, u, v);
        if (d != INT_MAX && d + w < ans) {
            ans = d + w;
        }
    }

    if (ans == INT_MAX) printf("-1");
    else printf("%d", ans);

    return 0;
}
