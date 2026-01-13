#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;

class NestedChest {
public:
    bool isInteger;
    int value;
    vector<NestedChest> list;

    NestedChest() : isInteger(false) {}
    NestedChest(int v) : isInteger(true), value(v) {}

    void add(const NestedChest& ni) {
        list.push_back(ni);
    }
};

NestedChest deserialize(string s) {
    if (s[0] != '[') return NestedChest(stoi(s));

    stack<NestedChest> st;
    int num = 0;
    bool negative = false;

    for (int i = 0; i < s.length(); i++) {
        char c = s[i];

        if (c == '[') st.push(NestedChest());
        else if (c == '-') negative = true;
        else if (isdigit(c)) {
            num = num * 10 + (c - '0');
        }
        else if (c == ',' || c == ']') {
            if (i > 0 && isdigit(s[i - 1])) {
                if (negative) num = -num;
                st.top().add(NestedChest(num));
                num = 0;
                negative = false;
            }

            if (c == ']' && st.size() > 1) {
                NestedChest top = st.top();
                st.pop();
                st.top().add(top);
            }
        }
    }
    return st.top();
}

void printNested(const NestedChest& nc) {
    if (nc.isInteger) {
        cout << nc.value;
        return;
    }

    cout << "[";
    for (int i = 0; i < nc.list.size(); i++) {
        printNested(nc.list[i]);
        if (i != nc.list.size() - 1)
            cout << ",";
    }
    cout << "]";
}

int main() {
    string s;
    cin>>s;
    NestedChest result = deserialize(s);
    cout << "Parsed Output: ";
    printNested(result);
    cout << endl;

}
