#include <stdio.h>
#include <stdlib.h>

struct node {
    int v;
    struct node* next;
};

struct node* adj[100005];
int visited[100005];
int state[100005];
int queue[100005];
int front, rear;

void add_edge(int u, int v) {
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    temp->v = v;
    temp->next = adj[u];
    adj[u] = temp;
}

int main() {
    int v, e;
    printf("Enter number of reservoirs and pipes: ");
    scanf("%d %d", &v, &e);

    for (int i = 0; i < v; i++) {
        adj[i] = NULL;
        visited[i] = 0;
    }

    printf("Enter the pipes: ");
    for (int i = 0; i < e; i++) {
        int u, w;
        scanf("%d %d", &u, &w);
        add_edge(u, w);
        add_edge(w, u);
    }

    printf("Enter initial water state: ");
    for (int i = 0; i < v; i++) {
        scanf("%d", &state[i]);
    }

    front = rear = 0;
    int time[100005];
    for (int i = 0; i < v; i++) {
        if (state[i] == 1) {
            queue[rear++] = i;
            visited[i] = 1;
            time[i] = 0;
        }
    }

    int max_time = 0;
    while (front < rear) {
        int curr = queue[front++];
        struct node* temp = adj[curr];
        while (temp != NULL) {
            int neigh = temp->v;
            if (!visited[neigh]) {
                visited[neigh] = 1;
                time[neigh] = time[curr] + 1;
                if (time[neigh] > max_time) max_time = time[neigh];
                queue[rear++] = neigh;
            }
            temp = temp->next;
        }
    }

    for (int i = 0; i < v; i++) {
        if (!visited[i]) {
            printf("-1");
            return 0;
        }
    }

    printf("%d", max_time);
    return 0;
}
