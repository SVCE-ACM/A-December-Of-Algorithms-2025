#include <iostream>
using namespace std;
int main() {
    cout << "Enter the (N) number of students: ";
    int n;
    cin >> n;
    int scores[20000], sweets[20000];
    cout << "Enter the performance scores of the students (space-separated): ";
    for (int i = 0; i < n; ++i) {
        cin >> scores[i];
        sweets[i] = 1;
    }
    for (int i = 1; i < n; ++i)
        if (scores[i] > scores[i-1]) sweets[i] = sweets[i-1] + 1;
    for (int i = n-2; i >= 0; --i)
        if (scores[i] > scores[i+1] && sweets[i] <= sweets[i+1]) sweets[i] = sweets[i+1] + 1;
    int total = 0;
    for (int i = 0; i < n; ++i) total += sweets[i];
    cout << "Minimum total number of sweets: " << total;
    return 0;
}
