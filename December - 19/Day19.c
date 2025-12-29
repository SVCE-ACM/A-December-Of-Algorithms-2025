#include <stdio.h>

int main() {
    int N;
    int skills[100];
    int dp[10001] = {0};
    int total = 0;

    // Input number of employees
    scanf("%d", &N);

    // Input skill levels
    for (int i = 0; i < N; i++) {
        scanf("%d", &skills[i]);
        total += skills[i];
    }

    // dp[0] is always possible
    dp[0] = 1;

    // Fill dp array
    for (int i = 0; i < N; i++) {
        for (int j = total; j >= skills[i]; j--) {
            if (dp[j - skills[i]] == 1) {
                dp[j] = 1;
            }
        }
    }

    // Find closest sum to total/2
    int minDiff = total;
    for (int i = 0; i <= total / 2; i++) {
        if (dp[i] == 1) {
            int diff = total - 2 * i;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
    }

    // Output result
    printf("%d", minDiff);

    return 0;
}
