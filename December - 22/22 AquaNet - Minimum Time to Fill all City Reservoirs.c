#include <stdio.h>
#include <stdlib.h>

#define MAX 100000

int main() {
    int V, E;
    scanf("%d %d", &V, &E);

    int adj[V][V];   // adjacency matrix
    for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
            adj[i][j] = 0;

    for (int i = 0; i < E; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    int water[V];
    for (int i = 0; i < V; i++)
        scanf("%d", &water[i]);

    int queue[MAX];
    int front = 0, rear = 0;

    int time[V];
    for (int i = 0; i < V; i++)
        time[i] = -1;

    // Multi-source BFS initialization
    for (int i = 0; i < V; i++) {
        if (water[i] == 1) {
            queue[rear++] = i;
            time[i] = 0;
        }
    }

    // BFS
    while (front < rear) {
        int curr = queue[front++];

        for (int i = 0; i < V; i++) {
            if (adj[curr][i] == 1 && time[i] == -1) {
                time[i] = time[curr] + 1;
                queue[rear++] = i;
            }
        }
    }

    int maxTime = 0;
    for (int i = 0; i < V; i++) {
        if (time[i] == -1) {
            printf("-1");
            return 0;
        }
        if (time[i] > maxTime)
            maxTime = time[i];
    }

    printf("%d", maxTime);
    return 0;
}
