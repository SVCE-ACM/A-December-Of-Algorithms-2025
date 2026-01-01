#include <stdio.h>
#include <stdlib.h>

// Structure for turtle
struct Turtle {
    int pos;
    int speed;
};

// Comparator to sort by position descending
int cmp(const void* a, const void* b) {
    return ((struct Turtle*)b)->pos - ((struct Turtle*)a)->pos;
}

int main() {
    int target, n;
    printf("Enter target position: ");
    scanf("%d", &target);

    printf("Enter number of turtles: ");
    scanf("%d", &n);

    if(n == 0) {
        printf("No turtle fleets formed.\n");
        return 0;
    }

    struct Turtle turtles[n];
    printf("Enter positions of turtles:\n");
    for(int i=0; i<n; i++) scanf("%d", &turtles[i].pos);

    printf("Enter speeds of turtles:\n");
    for(int i=0; i<n; i++) scanf("%d", &turtles[i].speed);

    // Sort turtles by position descending
    qsort(turtles, n, sizeof(struct Turtle), cmp);

    int fleets = 0;
    double last_time = 0.0;

    for(int i=0; i<n; i++) {
        double time = (double)(target - turtles[i].pos) / turtles[i].speed;
        if(time > last_time) {
            fleets++;
            last_time = time;
        }
        // else: joins the fleet ahead
    }

    printf("The number of turtle fleets is: %d\n", fleets);
    return 0;
}
