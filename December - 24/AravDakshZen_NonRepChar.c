#include <stdio.h>

int main() {
    int found = 0, freq[256] = {0};
    char str[100];
    scanf("%s", str);
    for (int i = 0; str[i] != '\0'; i++) {
        freq[(unsigned char)str[i]]++;
    }
    for (int i = 0; str[i] != '\0'; i++) {
        if (freq[(unsigned char)str[i]] == 1) {
            printf("The first non-repeating character is: %c", str[i]);
            found = 1;
            break;
        }
    }
    if (!found) {
        printf("No non-repeating character found.");
    }
    return 0;
}
