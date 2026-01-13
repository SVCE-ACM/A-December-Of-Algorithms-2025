#include <stdio.h>
#include <string.h>

int main() {
    char s[100005];
    printf("Enter the string: ");
    scanf("%s", s);

    int freq[26] = {0};
    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }

    int found = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (freq[s[i] - 'a'] == 1) {
            printf("The first non-repeating character is: %c", s[i]);
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("No non-repeating character found.");
    }

    return 0;
}
