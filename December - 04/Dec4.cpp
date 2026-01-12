#include <iostream>
#include <vector>
using namespace std;
int main() 
{
    int N;
    long long K;
    cin >> N >> K;
    vector<long long> arr(N);
    for (int i = 0; i < N; i++) 
    {
        cin >> arr[i];
    }
    for (int i = 0; i < N; i++) 
    {
        long long sum = 0;
        for (int j = i; j < N; j++) 
        {
            sum += arr[j];
            if (sum == K) 
            {
                cout << i << " " << j;
                return 0;
            }
        }
    }
    cout << "-1 -1";
    return 0;
}
