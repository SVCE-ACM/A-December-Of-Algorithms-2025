#include <stdio.h>

int main() {
    int target, n;
    int position[100000], speed[100000];
    double time[100000];

    // Input target and number of turtles
    scanf("%d", &target);
    scanf("%d", &n);

    // If no turtles
    if (n == 0) {
        printf("No turtle fleets formed.");
        return 0;
    }

    // Input positions
    for (int i = 0; i < n; i++) {
        scanf("%d", &position[i]);
    }

    // Input speeds
    for (int i = 0; i < n; i++) {
        scanf("%d", &speed[i]);
    }

    // Calculate time for each turtle
    for (int i = 0; i < n; i++) {
        time[i] = (double)(target - position[i]) / speed[i];
    }

    // Sort by position (descending)
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (position[i] < position[j]) {
                int p = position[i];
                position[i] = position[j];
                position[j] = p;

                double t = time[i];
                time[i] = time[j];
                time[j] = t;
            }
        }
    }

    // Count fleets
    int fleets = 0;
    double maxTime = 0;

    for (int i = 0; i < n; i++) {
        if (time[i] > maxTime) {
            fleets++;
            maxTime = time[i];
        }
    }

    printf("The number of turtle fleets is: %d", fleets);

    return 0;
}
