#include <stdio.h>

int main() {
    int n;
    printf("Enter number of students: ");
    scanf("%d", &n);

    int students[105], sandwiches[105];
    int i;

    printf("Enter student preferences (0 or 1):\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &students[i]);
    }

    printf("Enter sandwiches stack (0 or 1):\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &sandwiches[i]);
    }

    int front = 0, back = n - 1;
    int top = 0;
    int count = 0;

    while (top < n) {
        if (students[front] == sandwiches[top]) {
            top++;
            front = (front + 1) % n;
            count = 0;
        } else {
            int temp = students[front];
            front = (front + 1) % n;
            back = (back + 1) % n;
            students[back] = temp;
            count++;
        }

        if (count == n) {
            break;
        }
    }

    printf("Students unable to eat: %d", n - top);

    return 0;
}
