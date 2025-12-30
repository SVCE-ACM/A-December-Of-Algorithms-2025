#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cout << "Enter number of beads: ";
    cin >> N;

    if (N == 0) {
        cout << "The necklace is empty." << endl;
        return 0;
    }
    vector<int> beads(N);
    cout << "Enter bead values: ";
    for (int i = 0; i < N; i++) cin >> beads[i];

    int left = 0, right = N - 1;
    bool isMirrored = true;

    while (left < right) {
        if (beads[left] != beads[right]) {
            isMirrored = false;
            break;
        }
        left++;
        right--;
    }

    if (isMirrored)
        cout << "The necklace is mirrored." << endl;
    else
        cout << "The necklace is not mirrored." << endl;
}
