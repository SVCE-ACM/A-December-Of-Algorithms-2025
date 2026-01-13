#include <stdio.h>

int turtleFleets(int target, int n, int turtlePosition[], int turtleSpeed[]) {
    if (n == 0) { 
        return 0;
    }
    
    int time[n];
    for (int i = 0; i < n; i++) {
        time[i] = (int)(target - turtlePosition[i]) / turtleSpeed[i];
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (turtlePosition[j] > turtlePosition[j + 1]) {
                int temppos = turtlePosition[j];
                turtlePosition[j] = turtlePosition[j + 1];
                turtlePosition[j + 1] = temppos;
                int tempTime = time[j];
                time[j] = time[j + 1];
                time[j + 1] = tempTime;
            }
        }
    }

    int fleets = 0, lastTime = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (time[i] > lastTime) {
            fleets++;
            lastTime = time[i];
        }
    }
    return fleets;
}

int main() {
    int target, n;
    scanf("%d %d", &target, &n);
    int turtlePosition[n], turtleSpeed[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &turtlePosition[i]);
    }
    for (int i = 0; i < n; i++) {
        scanf("%d", &turtleSpeed[i]);
    }

    int result = turtleFleets(target, n, turtlePosition, turtleSpeed);
    if (n == 0) { 
        printf("No turtle fleets formed.");
    }
    else { 
        printf("The number of turtle fleets is: %d", result);
    }
    return 0;
}
