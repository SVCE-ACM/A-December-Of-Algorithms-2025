#include <stdio.h>
int main() {
    int n;
    printf("Enter the number of parcels: ");
    scanf("%d", &n);
    int parcels[n], sorted[n], s = 0;
    printf("Enter the weights of %d parcels: ", n);
    for (int i = 0; i < n; i++)
        scanf("%d", &parcels[i]);
    int rem = n;
    while (rem > 0) {
        int minIndex = 0;
        for (int i = 1; i < rem; i++)
            if (parcels[i] < parcels[minIndex]) minIndex = i;
        while (minIndex > 0) {
            int t = parcels[0];
            for (int i = 0; i < rem - 1; i++) parcels[i] = parcels[i + 1];
            parcels[rem - 1] = t;
            minIndex--;
        }
        sorted[s++] = parcels[0];
        for (int i = 0; i < rem - 1; i++) parcels[i] = parcels[i + 1];
        rem--;
    }
    for (int i = 0; i < s; i++) {
        if (i) printf(" ");
        printf("%d", sorted[i]);
    }
    return 0;
}
