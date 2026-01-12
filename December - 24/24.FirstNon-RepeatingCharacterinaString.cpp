#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    cout << "Enter a single string containing only lowercase letters (a–z), without spaces: ";
    cin >> s;
    int freq[26] = {0};
    for (char c : s) freq[c - 'a']++;
    for (char c : s) {
        if (freq[c - 'a'] == 1) {
            cout << "The first non-repeating character is: " << c << endl;
            return 0;
        }
    }
    cout << "No non-repeating character found." << endl;
    return 0;
}
