#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Enter number of employees: ");
    scanf("%d", &n);

    int skills[35];
    printf("Enter the skills: ");
    int total = 0;
    for (int i = 0; i < n; i++) {
        scanf("%d", &skills[i]);
        total += skills[i];
    }

    int half = total / 2;
    int dp[half + 1];
    for (int i = 0; i <= half; i++) dp[i] = 0;
    dp[0] = 1;

    for (int i = 0; i < n; i++) {
        for (int j = half; j >= skills[i]; j--) {
            if (dp[j - skills[i]]) dp[j] = 1;
        }
    }

    int best = 0;
    for (int i = half; i >= 0; i--) {
        if (dp[i]) {
            best = i;
            break;
        }
    }

    int diff = total - 2 * best;
    printf("%d", diff);

    return 0;
}

