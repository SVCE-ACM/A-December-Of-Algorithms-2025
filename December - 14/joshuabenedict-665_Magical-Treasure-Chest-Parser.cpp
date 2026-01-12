#include <bits/stdc++.h>
using namespace std;

class NestedChest {
public:
    bool isInt;
    int val;
    vector<NestedChest> list;
    NestedChest() {
        isInt = false;
    }
    NestedChest(int x) {
        isInt = true;
        val = x;
    }
};
class Solution {
public:
    NestedChest deserialize(string s) {
        if (s[0] != '[') {
            return NestedChest(stoi(s));
        }

        stack<NestedChest> st;
        int n = s.size();

        for (int i = 0; i < n; i++) {
            if (s[i] == '[') {
                st.push(NestedChest());
            }
            else if (s[i] == '-' || isdigit(s[i])) {
                int sign = 1;
                if (s[i] == '-') {
                    sign = -1;
                    i++;
                }
                int num = 0;
                while (i < n && isdigit(s[i])) {
                    num = num * 10 + (s[i] - '0');
                    i++;
                }
                num *= sign;
                st.top().list.push_back(NestedChest(num));
                i--; 
            }
            else if (s[i] == ']') {
                NestedChest curr = st.top();
                st.pop();

                if (st.empty()) return curr;
                st.top().list.push_back(curr);
            }
        }
        return NestedChest(); 
    }
};
void printChest(const NestedChest& chest) {
    if (chest.isInt) {
        cout << chest.val;
        return;
    }
    cout << "[";
    for (int i = 0; i < chest.list.size(); i++) {
        printChest(chest.list[i]);
        if (i + 1 < chest.list.size()) cout << ",";
    }
    cout << "]";
}

int main() {
    string s;
    cin >> s;
    Solution sol;
    NestedChest result = sol.deserialize(s);
    printChest(result);
    return 0;
}
