#include <stdio.h>

int main() {
    int stones[10000], stones_length = 0, maxJump = 0;
    char c;
    while ( scanf( "%d", &stones[stones_length] ) == 1 ) {
        stones_length++;
        c = getchar();
        if (c == '\n') 
            break;
    }
    for ( int i = 0 ; i <= maxJump && i < stones_length; i++ ) {
        if ( i + stones[i] > maxJump )
            maxJump = i + stones[i];

        if ( maxJump >= stones_length - 1) {
            printf("true\n");
            return 0;
        }
    }
    printf("false\n");
    return 0;
}