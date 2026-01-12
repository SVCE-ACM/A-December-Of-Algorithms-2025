#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    if (N <= 2) {
        cout << "The count of prime numbers less than " << N << " is: 0";
        return 0;
    }
    vector<bool> isPrime(N, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i < N; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < N; j += i) {
                isPrime[j] = false;
            }
        }
    }
    int count = 0;
    for (int i = 2; i < N; i++) {
        if (isPrime[i]) count++;
    }
    cout << "The count of prime numbers less than " << N << " is: " << count;
    return 0;
}
