#include <stdio.h>

int main() {
    int target, n;

    printf("enter target: ");
    scanf("%d", &target);

    printf("enter number of turtles: ");
    scanf("%d", &n);

    if (n == 0) {
        printf("No turtle fleets formed.");
        return 0;
    }

    int position[100000], speed[100000];
    printf("enter positions: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &position[i]);
    }

    printf("enter speeds: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &speed[i]);
    }

    // sort by position descending
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (position[i] < position[j]) {
                int temp = position[i];
                position[i] = position[j];
                position[j] = temp;

                temp = speed[i];
                speed[i] = speed[j];
                speed[j] = temp;
            }
        }
    }

    double last_time = -1;
    int fleets = 0;

    for (int i = 0; i < n; i++) {
        double time = (double)(target - position[i]) / speed[i];

        if (time > last_time) {
            fleets++;
            last_time = time;
        }
    }

    printf("The number of turtle fleets is: %d", fleets);

    return 0;
}
