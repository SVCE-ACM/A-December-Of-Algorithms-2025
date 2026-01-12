#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int main() {
    int N;
    cout << "Enter N: ";
    cin >> N;
    vector<int> arr(N);
    cout << "Enter " << N << " elements: ";
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    int duplicate = -1, missing = -1;
    for (int i = 0; i < N; i++) {
        int index = abs(arr[i]) - 1; 
        if (arr[index] < 0) {
            duplicate = abs(arr[i]); 
        } else {
            arr[index] = -arr[index]; 
        }
    }
    for (int i = 0; i < N; i++) {
        if (arr[i] > 0) {
            missing = i + 1;
            break;
        }
    }
    cout << "Missing Number: " << missing << endl;
    cout << "Duplicate Number: " << duplicate << endl;
    return 0;
}
