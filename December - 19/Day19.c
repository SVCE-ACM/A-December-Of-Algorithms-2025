#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    scanf("%d", &N);

    int skills[30];
    int total = 0;
    for (int i = 0; i < N; i++) {
        scanf("%d", &skills[i]);
        total += skills[i];
    }

    int target = total / 2;
    int dp[target + 1];
    for (int i = 0; i <= target; i++) dp[i] = 0;

    dp[0] = 1;

    for (int i = 0; i < N; i++) {
        for (int j = target; j >= skills[i]; j--) {
            if (dp[j - skills[i]]) {
                dp[j] = 1;
            }
        }
    }

    int best = 0;
    for (int i = target; i >= 0; i--) {
        if (dp[i]) {
            best = i;
            break;
        }
    }

    int diff = total - 2 * best;
    printf("%d", abs(diff));

    return 0;
}
