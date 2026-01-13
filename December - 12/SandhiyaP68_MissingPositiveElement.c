#include <stdio.h>

int main() {
    int n;
    printf("enter n: ");
    scanf("%d", &n);

    int arr[100000];
    int i;

    printf("enter the elements: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int correctindex;
    i = 0;

    while (i < n) {
        correctindex = arr[i] - 1;

        if (arr[i] != arr[correctindex]) {
            int temp = arr[i];
            arr[i] = arr[correctindex];
            arr[correctindex] = temp;
        } else {
            i++;
        }
    }

    int missing = -1, duplicate = -1;

    for (i = 0; i < n; i++) {
        if (arr[i] != i + 1) {
            missing = i + 1;
            duplicate = arr[i];
            break;
        }
    }

    printf("missing number: %d\n", missing);
    printf("duplicate number: %d", duplicate);

    return 0;
}
