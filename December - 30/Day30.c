

#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int tree[10000];
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }

    int target;
    scanf("%d", &target);

    int visited[10000] = {0};
    int queue[10000];
    int front = 0, rear = 0;

    int start = -1;
    for (int i = 0; i < n; i++) {
        if (tree[i] == target) {
            start = i;
            break;
        }
    }

    queue[rear++] = start;
    visited[start] = 1;

    while (front < rear) {
        int size = rear - front;

        for (int i = 0; i < size; i++) {
            int idx = queue[front++];
            printf("%d ", tree[idx]);

            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int parent = (idx - 1) / 2;

            if (left < n && !visited[left]) {
                visited[left] = 1;
                queue[rear++] = left;
            }
            if (right < n && !visited[right]) {
                visited[right] = 1;
                queue[rear++] = right;
            }
            if (idx != 0 && !visited[parent]) {
                visited[parent] = 1;
                queue[rear++] = parent;
            }
        }
        printf("\n");
    }

    return 0;
}
