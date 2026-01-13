#include <iostream>
#include <vector>
#include <string>
#include <sstream>

int main() {
    std::string line;
    while(std::getline(std::cin, line)) {
        size_t start = line.find('[');
        size_t end = line.find(']');
        if (start != std::string::npos && end != std::string::npos) {
            std::string content = line.substr(start + 1, end - start - 1);
            std::stringstream ss(content);
            std::string segment;
            bool saw_null = false;
            bool is_complete = true;
            
            while(std::getline(ss, segment, ',')) {
                size_t first = segment.find_first_not_of(" ");
                if (first == std::string::npos) continue;
                size_t last = segment.find_last_not_of(" ");
                segment = segment.substr(first, last - first + 1);
                
                if (segment == "null") {
                    saw_null = true;
                } else {
                    if (saw_null) {
                        is_complete = false;
                    }
                }
            }
            std::cout << (is_complete ? "true" : "false") << std::endl;
        }
    }
    return 0;
}
