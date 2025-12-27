#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int n, total = 0;
    stack<int> st;
    cin >> n;
    vector<string> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];

    for (string r : arr) {
        if (r == "C") st.pop();
        else if (r == "D")  st.push(2 * st.top());
        else if (r == "+") {
            int top1 = st.top(); st.pop();
            int top2 = st.top();
            st.push(top1);
            st.push(top1 + top2);
        }
        else st.push(stoi(r));
    }
    while (!st.empty()) {
        total += st.top();
        st.pop();
    }
    cout << total;
}
