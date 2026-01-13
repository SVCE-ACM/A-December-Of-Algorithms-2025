#include <stdio.h>
#include <stdlib.h>

#define INF 1000000000

struct edge {
    int v, t;
    struct edge* next;
};

struct edge* adj[505];
int dist[505], visited[505];

void add_edge(int u, int v, int t) {
    struct edge* temp = (struct edge*)malloc(sizeof(struct edge));
    temp->v = v;
    temp->t = t;
    temp->next = adj[u];
    adj[u] = temp;
}

int main() {
    int n, m;
    printf("Enter number of towers: ");
    scanf("%d", &n);
    printf("Enter number of links: ");
    scanf("%d", &m);

    for (int i = 0; i < n; i++) {
        adj[i] = NULL;
        dist[i] = INF;
        visited[i] = 0;
    }

    printf("Enter the links: ");
    for (int i = 0; i < m; i++) {
        int u, v, t;
        scanf("%d %d %d", &u, &v, &t);
        add_edge(u, v, t);
    }

    int s;
    printf("Enter source tower: ");
    scanf("%d", &s);

    dist[s] = 0;
    for (int i = 0; i < n; i++) {
        int u = -1;
        for (int j = 0; j < n; j++) {
            if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                u = j;
            }
        }
        if (u == -1 || dist[u] == INF) break;
        visited[u] = 1;
        struct edge* temp = adj[u];
        while (temp != NULL) {
            if (dist[u] + temp->t < dist[temp->v]) {
                dist[temp->v] = dist[u] + temp->t;
            }
            temp = temp->next;
        }
    }

    int max_time = 0;
    for (int i = 0; i < n; i++) {
        if (dist[i] == INF) {
            printf("-1");
            return 0;
        }
        if (dist[i] > max_time) max_time = dist[i];
    }

    printf("%d", max_time);
    return 0;
}
