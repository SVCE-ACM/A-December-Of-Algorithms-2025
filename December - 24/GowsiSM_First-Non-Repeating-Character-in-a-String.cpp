#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    int freq[26] = {0};

    for (char c : s) freq[c - 'a']++;

    for (char c : s) {
        if (freq[c - 'a'] == 1) {
            cout << "The first non-repeating character is: " << c;
            return 0;
        }
    }

    cout << "No non-repeating character found.";
}
