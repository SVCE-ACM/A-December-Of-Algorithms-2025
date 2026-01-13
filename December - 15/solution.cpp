#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <queue>

int main() {
    std::string line;
    if (std::getline(std::cin, line)) {
        size_t start = line.find('[');
        size_t end = line.find(']');
        if (start != std::string::npos && end != std::string::npos) {
            std::string content = line.substr(start + 1, end - start - 1);
            std::stringstream ss(content);
            std::string token;
            std::vector<std::string> nodes;
            while (std::getline(ss, token, ',')) {
                 size_t first = token.find_first_not_of(" ");
                 if (first != std::string::npos)
                    token = token.substr(first);
                 size_t last = token.find_last_not_of(" ");
                 if (last != std::string::npos)
                    token = token.substr(0, last + 1);
                 
                nodes.push_back(token);
            }

            if (nodes.empty()) {
                std::cout << "true" << std::endl;
                return 0;
            }

            int count = 0;
            for (const std::string& node : nodes) {
                if (node != "null") count++;
            }

            bool safe = true;
            bool split = false; 
            
            for (const std::string& node : nodes) {
                if (node == "null") {
                    split = true;
                } else {
                    if (split) {
                        safe = false;
                        break;
                    }
                }
            }

            std::cout << (safe ? "true" : "false") << std::endl;
        }
    }
    return 0;
}
