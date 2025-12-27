#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; 
    cin >> n;
    vector<int> students(n), sandwiches(n);
    for (int i = 0; i < n; i++) cin >> students[i];
    for (int i = 0; i < n; i++) cin >> sandwiches[i];

    queue<int> q;
    for (int s : students) q.push(s);

    int index = 0; 
    int rotations = 0;

    while (!q.empty() && index < n) {
        if (q.front() == sandwiches[index]) {
            q.pop(); 
            index++;
            rotations = 0; 
        } else {
            int frontStudent = q.front();
            q.pop();
            q.push(frontStudent);
            rotations++;
            if (rotations == (int)q.size()) break;
        }
    }
    cout << q.size() << "\n";

    return 0;
}
