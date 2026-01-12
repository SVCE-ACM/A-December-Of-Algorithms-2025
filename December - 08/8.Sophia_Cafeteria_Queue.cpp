#include <stdio.h>

int main()
{
    int n;
    printf("Enter the no. of students: ");
    scanf("%d", &n);

    int students[n], sandwiches[n];
    int count0 = 0, count1 = 0;

    printf("Enter the students' preferences:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &students[i]);
        if (students[i] == 0)
            count0++;
        else
            count1++;
    }

    printf("Enter the sandwiches:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &sandwiches[i]);
    }

//If there is a circular sandwich on top, and at least one student wants a circular sandwich,
// then someone will eventually eat it, because the queue keeps moving.
    for (int i = 0; i < n; i++)
    {
        if (sandwiches[i] == 0)
        {
            if (count0 == 0)
                break;
            count0--;
        }
        else
        {
            if (count1 == 0)
                break;
            count1--;
        }
    }

    printf("Students who cannot eat: %d\n", count0 + count1);

    return 0;
}

