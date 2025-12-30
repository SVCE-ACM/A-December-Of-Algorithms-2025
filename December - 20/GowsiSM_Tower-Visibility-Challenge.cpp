#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int N;
    cout << "Enter number of towers: ";
    cin >> N;

    vector<long long> heights(N);
    cout << "Enter tower heights: ";
    for (int i = 0; i < N; i++) cin >> heights[i];

    vector<long long> result(N, -1);
    stack<long long> st;

    for (int i = N - 1; i >= 0; i--) {
        while (!st.empty() && st.top() <= heights[i]) st.pop();
        if (!st.empty()) result[i] = st.top();
        st.push(heights[i]);
    }

    cout << "Next taller towers: ";
    for (long long x : result) cout << x << " ";
}