#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int score[n], sweets[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &score[i]);
        sweets[i] = 1;
    }

    for (int i = 1; i < n; i++) {
        if (score[i] > score[i-1]) { 
            sweets[i] = sweets[i-1] + 1;
        }
    }

    for (int i = n-2 ; i >= 0 ; i--) {
        if (score[i] > score[i+1] && sweets[i] <= sweets[i+1]) { 
            sweets[i] = sweets[i+1] + 1;
        }
    }

    int total = 0;
    for (int i = 0 ; i < n ; i++) { 
        total += sweets[i];
    }
    printf("%d", total);
    return 0;
}
