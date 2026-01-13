#include <stdio.h>

int main() {
    int students[] = {1,1,1,0,0,1}, sandwiches[] = {1,0,0,0,1,1};
    int studentsLength = sizeof(students) / sizeof(students[0]);

    int countZeros = 0, countOnes = 0;
    for (int i = 0; i < studentsLength; i++) {
        if (students[i] == 0)
            countZeros++;
        else
            countOnes++;
    }

    for (int i = 0; i < studentsLength; i++) {
        if (sandwiches[i] == 0) {
            if (countZeros == 0)
                break;
            countZeros--;
        } else {
            if (countOnes == 0)
                break;
            countOnes--;
        }
    }
    printf("%d", countZeros + countOnes);
    return 0;
}
