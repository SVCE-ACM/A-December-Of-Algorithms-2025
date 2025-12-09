#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

int main() {
    std::string line;
    while (std::getline(std::cin, line)) {
        size_t start = line.find('[');
        size_t end = line.find(']');
        if (start != std::string::npos && end != std::string::npos) {
            std::string content = line.substr(start + 1, end - start - 1);
            std::stringstream ss(content);
            std::string segment;
            std::vector<int> stones;
            while (std::getline(ss, segment, ',')) {
                if (!segment.empty()) {
                    try {
                        stones.push_back(std::stoi(segment));
                    } catch (...) {}
                }
            }
            if (stones.empty()) {
                continue;
            }
            int max_reach = 0;
            int n = stones.size();
            bool possible = false;
            for (int i = 0; i < n; ++i) {
                if (i > max_reach) break;
                max_reach = std::max(max_reach, i + stones[i]);
            }
            if (max_reach >= n - 1) possible = true;
            std::cout << (possible ? "true" : "false") << std::endl;
        }
    }
    return 0;
}
