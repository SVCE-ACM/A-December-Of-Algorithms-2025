#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int students[n], sandwiches[n];

    // input students
    for (int i = 0; i < n; i++) {
        scanf("%d", &students[i]);
    }

    // input sandwiches
    for (int i = 0; i < n; i++) {
        scanf("%d", &sandwiches[i]);
    }

    int count0 = 0, count1 = 0;

    // count student preferences
    for (int i = 0; i < n; i++) {
        if (students[i] == 0)
            count0++;
        else
            count1++;
    }

    int unable = 0;

    // process sandwiches
    for (int i = 0; i < n; i++) {
        if (sandwiches[i] == 0) {
            if (count0 > 0)
                count0--;
            else {
                unable = count1;
                break;
            }
        } else {
            if (count1 > 0)
                count1--;
            else {
                unable = count0;
                break;
            }
        }
    }

    printf("%d\n", unable);

    return 0;
}
