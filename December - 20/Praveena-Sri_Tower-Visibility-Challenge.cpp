#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; 
    cin >> N;
    vector<long long> heights(N);
    for (int i = 0; i < N; i++) {
        cin >> heights[i];
    }
    vector<long long> result(N, -1);
    stack<int> st; 
    for (int i = N - 1; i >= 0; i--) {
        while (!st.empty() && heights[st.top()] <= heights[i]) {
            st.pop();
        }
        if (!st.empty()) {
            result[i] = heights[st.top()];
        }
        st.push(i);
    }
    for (int i = 0; i < N; i++) {
        cout << result[i] << " ";
    }
    cout << "\n";
    return 0;
}
