#include <stdio.h>
#include <limits.h>

#define MAXN 505

int N, M;
int graph[MAXN][MAXN];
int dist[MAXN];
int visited[MAXN];

int minDistance() {
    int min = INT_MAX, index = -1;
    for (int i = 0; i < N; i++) {
        if (!visited[i] && dist[i] < min) {
            min = dist[i];
            index = i;
        }
    }
    return index;
}

int main() {
    scanf("%d", &N);
    scanf("%d", &M);

    // Initialize graph
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            graph[i][j] = INT_MAX;
        }
    }

    for (int i = 0; i < M; i++) {
        int u, v, t;
        scanf("%d %d %d", &u, &v, &t);
        graph[u][v] = t;
    }

    int S;
    scanf("%d", &S);

    // Initialize distances
    for (int i = 0; i < N; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }
    dist[S] = 0;

    // Dijkstra
    for (int i = 0; i < N; i++) {
        int u = minDistance();
        if (u == -1) break;
        visited[u] = 1;

        for (int v = 0; v < N; v++) {
            if (!visited[v] && graph[u][v] != INT_MAX &&
                dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INT_MAX) {
            printf("-1\n");
            return 0;
        }
        if (dist[i] > answer)
            answer = dist[i];
    }

    printf("%d\n", answer);
    return 0;
}
