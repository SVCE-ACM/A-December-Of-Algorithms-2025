#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int pos;
    double time;
} Turtle;

int cmp(const void *a, const void *b) {
    Turtle *t1 = (Turtle *)a;
    Turtle *t2 = (Turtle *)b;
    return t2->pos - t1->pos;
}

int main() {
    int target = 10;
    int n = 1;
    int position[] = {3};
    int speed[] = {3};

    if (n == 0) {
        printf("No turtle fleets formed.");
        return 0;
    }

    Turtle *turtles = (Turtle *)malloc(n * sizeof(Turtle));
    for (int i = 0; i < n; i++) {
        turtles[i].pos = position[i];
        turtles[i].time = (double)(target - position[i]) / speed[i];
    }

    qsort(turtles, n, sizeof(Turtle), cmp);

    int fleets = 0;
    double maxTime = 0.0;

    for (int i = 0; i < n; i++) {
        if (turtles[i].time > maxTime) {
            fleets++;
            maxTime = turtles[i].time;
        }
    }

    printf("The number of turtle fleets is: %d", fleets);
    free(turtles);
    return 0;
}
