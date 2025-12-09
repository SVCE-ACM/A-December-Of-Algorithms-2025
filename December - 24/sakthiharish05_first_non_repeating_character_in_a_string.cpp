#include <iostream>
#include <string>
#include <map>
#include <vector>

int main() {
    std::string s;
    if (std::cin >> s) {
        std::map<char, int> freq;
        for(char c : s) freq[c]++;
        
        bool found = false;
        for(char c : s) {
            if (freq[c] == 1) {
                std::cout << "The first non-repeating character is: " << c << std::endl;
                found = true;
                break;
            }
        }
        if (!found) {
            std::cout << "No non-repeating character found." << std::endl;
        }
    }
    return 0;
}
