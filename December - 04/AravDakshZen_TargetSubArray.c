#include <stdio.h>

int main() {
    int n, target, found = 0;
    scanf("%d %d", &n, &target);
    int arr[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    for(int i = 0 ; i < n ; i++) {
        int sum = 0; 
        for(int j = i ; j < n ; j++) {
            sum += arr[j];
            if(sum == target) {
                printf("%d %d\n", i, j);
                found = 1;
                break;
            }
            if(sum > target) {
                break;
            }
        }
        if(found) {
            break;
        }
    }
    if(!found) {
        printf("-1 -1\n");
    }
    return 0;
}