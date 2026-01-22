#include <stdio.h>
#include <string.h>

int main() {
    char str[1000];
    int count[26] = {0};   // for lowercase letters a–z

    // Input
    printf("Enter the string: ");
    scanf("%s", str);

    // Count frequency of each character
    for (int i = 0; str[i] != '\0'; i++) {
        count[str[i] - 'a']++;
    }

    // Find first non-repeating character
    for (int i = 0; str[i] != '\0'; i++) {
        if (count[str[i] - 'a'] == 1) {
            printf("The first non-repeating character is: %c", str[i]);
            return 0;
        }
    }

    // If no non-repeating character
    printf("No non-repeating character found.");

    return 0;
}
