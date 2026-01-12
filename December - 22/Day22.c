#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int *data;
    int front, rear;
} Queue;

int main() {
    int V, E;
    scanf("%d %d", &V, &E);

    int *adjCount = (int *)calloc(V, sizeof(int));
    int **adj = (int **)malloc(V * sizeof(int *));
    int u, v;

    int *edgesU = (int *)malloc(E * sizeof(int));
    int *edgesV = (int *)malloc(E * sizeof(int));

    for (int i = 0; i < E; i++) {
        scanf("%d %d", &u, &v);
        edgesU[i] = u;
        edgesV[i] = v;
        adjCount[u]++;
        adjCount[v]++;
    }

    for (int i = 0; i < V; i++) {
        adj[i] = (int *)malloc(adjCount[i] * sizeof(int));
        adjCount[i] = 0;
    }

    for (int i = 0; i < E; i++) {
        u = edgesU[i];
        v = edgesV[i];
        adj[u][adjCount[u]++] = v;
        adj[v][adjCount[v]++] = u;
    }

    int *state = (int *)malloc(V * sizeof(int));
    for (int i = 0; i < V; i++) {
        scanf("%d", &state[i]);
    }

    int *dist = (int *)malloc(V * sizeof(int));
    for (int i = 0; i < V; i++) dist[i] = -1;

    Queue q;
    q.data = (int *)malloc(V * sizeof(int));
    q.front = q.rear = 0;

    for (int i = 0; i < V; i++) {
        if (state[i] == 1) {
            dist[i] = 0;
            q.data[q.rear++] = i;
        }
    }

    while (q.front < q.rear) {
        int cur = q.data[q.front++];
        for (int i = 0; i < adjCount[cur]; i++) {
            int next = adj[cur][i];
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.data[q.rear++] = next;
            }
        }
    }

    int maxTime = 0;
    for (int i = 0; i < V; i++) {
        if (dist[i] == -1) {
            printf("-1");
            return 0;
        }
        if (dist[i] > maxTime) maxTime = dist[i];
    }

    printf("%d", maxTime);
    return 0;
}
