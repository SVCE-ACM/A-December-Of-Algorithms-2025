#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, count = 0;
    cin >> N;
    vector<bool> isPrime(N, true);
    if (N <= 2) {
        cout << "The count of prime numbers less than " << N << " is: 0";
        return 0;
    }

    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i < N; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < N; j += i) {
                isPrime[j] = false;
            }
        }
    }

    for (int i = 2; i < N; i++) {
        if (isPrime[i]) count++;
    }
    cout << "The count of prime numbers less than " << N << " is: " << count;
}
