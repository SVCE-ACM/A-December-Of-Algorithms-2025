#include <stdio.h>
#define MAXN 505
#define INF 1000000000
int N, M;
int graph[MAXN][MAXN];
int dist[MAXN];
int visited[MAXN];
int main() {
    printf("Enter number of towers (N): ");
    scanf("%d", &N);
    printf("Enter number of directed links (M): ");
    scanf("%d", &M);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            graph[i][j] = INF;
    printf("Enter each link in format: u v t\n");
    for (int i = 0; i < M; i++) {
        int u, v, t;
        scanf("%d %d %d", &u, &v, &t);
        graph[u][v] = t;
    }
    int S;
    printf("Enter source tower (S): ");
    scanf("%d", &S);
    for (int i = 0; i < N; i++) {
        dist[i] = INF;
        visited[i] = 0;
    }
    dist[S] = 0;
    for (int i = 0; i < N; i++) {
        int u = -1;
        for (int j = 0; j < N; j++) {
            if (!visited[j] && (u == -1 || dist[j] < dist[u]))
                u = j;
        }
        if (dist[u] == INF)
            break;
        visited[u] = 1;
        for (int v = 0; v < N; v++) {
            if (graph[u][v] != INF && dist[v] > dist[u] + graph[u][v])
                dist[v] = dist[u] + graph[u][v];
        }
    }
    int answer = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INF) {
            printf("-1\n");
            return 0;
        }
        if (dist[i] > answer)
            answer = dist[i];
    }
    printf("%d\n", answer);
    return 0;
}
