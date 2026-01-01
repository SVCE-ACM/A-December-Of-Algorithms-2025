#include <stdio.h>
#include <stdlib.h>

#define MAX 10000

int adj[MAX][3];   // adjacency list (max 3 neighbors: left, right, parent)
int adjSize[MAX];
int visited[MAX];
int queue[MAX];

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int node, left, right;
    int parent[MAX];

    for (int i = 0; i < MAX; i++) {
        adjSize[i] = 0;
        visited[i] = 0;
        parent[i] = -1;
    }

    printf("Enter nodes as: node left_child right_child (-1 if none)\n");

    for (int i = 0; i < n; i++) {
        scanf("%d %d %d", &node, &left, &right);

        if (left != -1) {
            adj[node][adjSize[node]++] = left;
            parent[left] = node;
        }
        if (right != -1) {
            adj[node][adjSize[node]++] = right;
            parent[right] = node;
        }
    }

    // Add parent connections
    for (int i = 0; i < MAX; i++) {
        if (parent[i] != -1) {
            adj[i][adjSize[i]++] = parent[i];
        }
    }

    int target;
    printf("Enter target node: ");
    scanf("%d", &target);

    // -------- BFS (Fire spreading) --------
    int front = 0, rear = 0;
    queue[rear++] = target;
    visited[target] = 1;

    printf("\nBurning sequence:\n");

    while (front < rear) {
        int size = rear - front;

        for (int i = 0; i < size; i++) {
            int curr = queue[front++];
            printf("%d ", curr);

            for (int j = 0; j < adjSize[curr]; j++) {
                int next = adj[curr][j];
                if (!visited[next]) {
                    visited[next] = 1;
                    queue[rear++] = next;
                }
            }
        }
        printf("\n");
    }

    printf("\nPress Enter to exit...");
    getchar();
    getchar();

    return 0;
}
