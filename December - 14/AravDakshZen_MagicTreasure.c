#include <stdio.h>
#include <string.h>

void parseChest(char* string) {
    int i = 0;
    while (string[i] != '\0') {
        if (string[i] == '[' || string[i] == ']' || string[i] == ',' || string[i] == '-' || (string[i] >= '0' && string[i] <= '9')) {
            printf("%c", string[i]);
        }
        i++;
    }
    printf("\n");
}

int main() {
    char string[100];
    if (scanf("%s", string) != 1) return 0;
    parseChest(string);
    return 0;
}