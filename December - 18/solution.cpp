#include <iostream>
#include <vector>
#include <string>

int main() {
    int n = -1;
    std::vector<int> beads;
    std::string word;
    
    while (std::cin >> word) {
        std::string num_str = "";
        for (char c : word) {
            if (isdigit(c) || c == '-') num_str += c;
        }
        if (!num_str.empty()) {
            try {
                int val = std::stoi(num_str);
                if (n == -1) {
                    n = val;
                } else {
                    beads.push_back(val);
                }
            } catch(...) {}
        }
    }

    if (n == 0) {
        std::cout << "The necklace is empty." << std::endl;
    } else {
        bool mirrored = true;
        for (int i = 0; i < n / 2; ++i) {
            if (beads[i] != beads[n - 1 - i]) {
                mirrored = false;
                break;
            }
        }
        
        if (mirrored) {
            std::cout << "The necklace is mirrored." << std::endl;
        } else {
            std::cout << "The necklace is not mirrored." << std::endl;
        }
    }
    return 0;
}
