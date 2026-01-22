#include <stdio.h>
#include <stdlib.h>

int main() {
    char s[1000];
    printf("Enter treasure chest string: ");
    scanf("%s", s);

    int treasure = atoi(s);  // convert string to integer
    printf("%d\n", treasure);

    return 0;
}
