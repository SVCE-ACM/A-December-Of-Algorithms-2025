#include <stdio.h>
#include <limits.h>

int main() {
    int n;
    scanf("%d", &n);
    int heights[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &heights[i]);
    }

    for (int i = 0; i < n; i++) {
        int found = 0;
        for (int j = i + 1; j < n; j++) {
            if (heights[j] > heights[i]) {
                heights[i] = heights[j];
                found = 1;
                break;
            }
        }
        if (!found) {
            heights[i] = -1;
        }
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", heights[i]);
    }

    return 0;
}
