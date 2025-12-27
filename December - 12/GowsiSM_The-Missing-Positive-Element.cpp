#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, missing = -1, duplicate = -1;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    int i = 0;
    while (i < N) {
        int correctIndex = arr[i] - 1;
        if (arr[i] != arr[correctIndex]) swap(arr[i], arr[correctIndex]);
        else i++;
    }

    for (int i = 0; i < N; i++) {
        if (arr[i] != i + 1) {
            missing = i + 1;
            duplicate = arr[i];
            break;
        }
    }
    cout << "Missing Number: " << missing << endl << "Duplicate Number: " << duplicate << endl;

}
