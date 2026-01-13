#include <stdio.h>

int main() {
    int N, freq[10] = {0}, missingNum, duplicateNum;
    scanf("%d", &N);
    int arr[N];
    for ( int i = 0 ; i < N ; i++ ) {
        scanf("%d", &arr[i]);
        freq[arr[i]]++;
    }
    for( int i = 0 ; i < N ; i++ ) {
        if ( freq[arr[i]] > 1 ) {
            duplicateNum = arr[i];
        }
        if ( freq[i] == 0 ) {
            missingNum = i;
        }
    }

    printf("Missing Number: %d\nDuplicate Number: %d\n", missingNum, duplicateNum);
    return 0;
}