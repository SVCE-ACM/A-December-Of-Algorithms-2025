#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int tree[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }

    int seenNull = 0;

    for (int i = 0; i < n; i++) {
        if (tree[i] == -1) {
            seenNull = 1;
        } else {
            if (seenNull) {
                printf("false\n");
                return 0;
            }
        }
    }

    printf("true\n");
    return 0;
}
