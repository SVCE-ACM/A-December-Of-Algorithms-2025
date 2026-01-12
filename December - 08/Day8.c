#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int students[n], sandwiches[n];
    int count0 = 0, count1 = 0;

    for (int i = 0; i < n; i++) {
        scanf("%d", &students[i]);
        if (students[i] == 0)
            count0++;
        else
            count1++;
    }

    for (int i = 0; i < n; i++) {
        scanf("%d", &sandwiches[i]);
    }

    int eaten = 0;

    for (int i = 0; i < n; i++) {
        if (sandwiches[i] == 0) {
            if (count0 == 0)
                break;
            count0--;
        } else {
            if (count1 == 0)
                break;
            count1--;
        }
        eaten++;
    }

    printf("%d", n - eaten);
    return 0;
}
