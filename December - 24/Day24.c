#include <stdio.h>
#include <string.h>

int main() {
    char s[100001];
    scanf("%s", s);

    int freq[26] = {0};
    int len = strlen(s);

    for (int i = 0; i < len; i++) {
        freq[s[i] - 'a']++;
    }

    for (int i = 0; i < len; i++) {
        if (freq[s[i] - 'a'] == 1) {
            printf("The first non-repeating character is: %c", s[i]);
            return 0;
        }
    }

    printf("No non-repeating character found.");
    return 0;
}
