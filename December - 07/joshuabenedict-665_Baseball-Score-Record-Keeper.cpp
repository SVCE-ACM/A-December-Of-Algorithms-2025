#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<string> ops(n);
    for (int i = 0; i < n; i++) {
        cin >> ops[i];
    }
    vector<int> scores;
    for (auto &op : ops) {
        if (op == "C") {
            if (!scores.empty()) scores.pop_back();
        } else if (op == "D") {
            if (!scores.empty()) scores.push_back(2 * scores.back());
        } else if (op == "+") {
            int size = (int)scores.size();
            if (size >= 2) {
                scores.push_back(scores[size - 1] + scores[size - 2]);
            }
        } else {
            scores.push_back(stoi(op));
        }
    }
    int total = accumulate(scores.begin(), scores.end(), 0);
    cout << total << "\n";
    return 0;
}
