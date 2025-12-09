#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

int main() {
    int N;
    std::string line;
    if (std::getline(std::cin, line)) {
        size_t eq = line.find('=');
        if (eq != std::string::npos) {
            try { N = std::stoi(line.substr(eq + 1)); } catch(...) {}
        } else {
            try { N = std::stoi(line); } catch(...) {}
        }
        
        if (N == 0) {
            std::cout << "The necklace is empty." << std::endl;
            return 0;
        }
        
        std::vector<int> beads;
        if (std::getline(std::cin, line)) {
            eq = line.find('=');
            std::string content = (eq != std::string::npos) ? line.substr(eq + 1) : line;
            std::stringstream ss(content);
            int temp;
            while(ss >> temp) beads.push_back(temp);
        }
        
        std::vector<int> rev = beads;
        std::reverse(rev.begin(), rev.end());
        if (beads == rev) {
            std::cout << "The necklace is mirrored." << std::endl;
        } else {
            std::cout << "The necklace is not mirrored." << std::endl;
        }
    }
    return 0;
}
