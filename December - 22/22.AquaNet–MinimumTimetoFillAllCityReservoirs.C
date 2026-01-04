#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
    int vertex;
    struct Node* next;
} Node;
typedef struct {
    Node** adj;
} Graph;
typedef struct {
    int* data;
    int front, rear;
} Queue;
Queue* createQueue(int n) {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->data = (int*)malloc(n * sizeof(int));
    q->front = q->rear = 0;
    return q;
}
int isEmpty(Queue* q) { return q->front == q->rear; }
void enqueue(Queue* q, int x) { q->data[q->rear++] = x; }
int dequeue(Queue* q) { return q->data[q->front++]; }
Graph* createGraph(int V) {
    Graph* g = (Graph*)malloc(sizeof(Graph));
    g->adj = (Node**)malloc(V * sizeof(Node*));
    for (int i = 0; i < V; i++) g->adj[i] = NULL;
    return g;
}
void addEdge(Graph* g, int u, int v) {
    Node* nodeU = (Node*)malloc(sizeof(Node)); nodeU->vertex = v; nodeU->next = g->adj[u]; g->adj[u] = nodeU;
    Node* nodeV = (Node*)malloc(sizeof(Node)); nodeV->vertex = u; nodeV->next = g->adj[v]; g->adj[v] = nodeV;
}
int main() {
    int V, E;
    printf("Enter the number of reservoirs and pipes: ");
    scanf("%d %d", &V, &E);
    Graph* g = createGraph(V);
    printf("Enter the pipe connections (u v) one per line:\n");
    for (int i = 0; i < E; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        addEdge(g, u, v);
    }
    int* water = (int*)malloc(V * sizeof(int));
    int* visited = (int*)malloc(V * sizeof(int));
    printf("Enter the initial water state for each reservoir (0 or 1):\n");
    for (int i = 0; i < V; i++) {
        scanf("%d", &water[i]);
        visited[i] = water[i];
    }
    Queue* q = createQueue(V);
    for (int i = 0; i < V; i++) if (water[i] == 1) enqueue(q, i);
    int minutes = 0;
    while (!isEmpty(q)) {
        int size = q->rear - q->front;
        int spread = 0;
        for (int i = 0; i < size; i++) {
            int curr = dequeue(q);
            Node* adjNode = g->adj[curr];
            while (adjNode) {
                int nei = adjNode->vertex;
                if (!visited[nei]) {
                    visited[nei] = 1;
                    enqueue(q, nei);
                    spread = 1;
                }
                adjNode = adjNode->next;
            }
        }
        if (spread) minutes++;
    }
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            printf("-1\n");
            return 0;
        }
    }
    printf("%d\n", minutes);
    return 0;
}
