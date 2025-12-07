#include <iostream>
#include <string>
#include <vector>

int main() {
    std::string s;
    if (std::cin >> s) {
        int count[26] = {0};
        for (char c : s) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        
        bool found = false;
        char result;
        for (char c : s) {
            if (c >= 'a' && c <= 'z') {
                if (count[c - 'a'] == 1) {
                    found = true;
                    result = c;
                    break;
                }
            }
        }
        
        if (found) {
            std::cout << "The first non-repeating character is: " << result << std::endl;
        } else {
            std::cout << "No non-repeating character found." << std::endl;
        }
    }
    return 0;
}
