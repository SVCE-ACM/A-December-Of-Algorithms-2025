#include <stdio.h>

int main() {
    int n;
    printf("Enter number of students: ");
    scanf("%d", &n);

    int students[n], sandwiches[n];
    int count0 = 0, count1 = 0;

    printf("Enter students' preferences (0 or 1):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &students[i]);
        if (students[i] == 0) count0++;
        else count1++;
    }

    printf("Enter sandwiches stack (0 or 1, top first):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &sandwiches[i]);
    }

    for (int i = 0; i < n; i++) {
        if (sandwiches[i] == 0 && count0 > 0) count0--;
        else if (sandwiches[i] == 1 && count1 > 0) count1--;
        else break; // no student wants this sandwich
    }

    int cannotEat = count0 + count1;
    printf("Number of students who cannot eat: %d\n", cannotEat);

    return 0;
}
