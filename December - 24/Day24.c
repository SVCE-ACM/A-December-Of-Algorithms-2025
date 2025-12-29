#include <stdio.h>

int main() {
    char str[1000];
    scanf("%s", str);

    int count[26] = {0};

    // Step 1: Count frequency of each character
    for (int i = 0; str[i] != '\0'; i++) {
        count[str[i] - 'a']++;
    }

    // Step 2: Find first non-repeating character
    for (int i = 0; str[i] != '\0'; i++) {
        if (count[str[i] - 'a'] == 1) {
            printf("The first non-repeating character is: %c\n", str[i]);
            return 0;
        }
    }

    // Step 3: If none found
    printf("No non-repeating character found.\n");

    return 0;
}
