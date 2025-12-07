#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

int main() {
    std::string line;
    if (std::getline(std::cin, line)) {
        for (char &c : line) {
            if (!isdigit(c)) c = ' ';
        }
        std::stringstream ss(line);
        std::vector<int> stones;
        int val;
        while (ss >> val) {
            stones.push_back(val);
        }

        if (stones.empty()) {
            std::cout << "false" << std::endl;
            return 0;
        }

        int max_reach = 0;
        int n = stones.size();
        bool possible = false;
        
        for (int i = 0; i < n; ++i) {
            if (i > max_reach) break;
            max_reach = std::max(max_reach, i + stones[i]);
            if (max_reach >= n - 1) {
                possible = true;
                break;
            }
        }
        
        std::cout << (possible ? "true" : "false") << std::endl;
    }
    return 0;
}
