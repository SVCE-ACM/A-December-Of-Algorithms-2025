#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

std::vector<int> parse_array(std::string s) {
    std::vector<int> res;
    size_t start = s.find('[');
    size_t end = s.find(']');
    if (start != std::string::npos && end != std::string::npos) {
        std::string content = s.substr(start + 1, end - start - 1);
        std::stringstream ss(content);
        std::string segment;
        while(std::getline(ss, segment, ',')) {
            if (!segment.empty()) {
                try { res.push_back(std::stoi(segment)); } catch(...) {}
            }
        }
    }
    return res;
}

int main() {
    std::string line;
    if (std::getline(std::cin, line)) {
        std::vector<int> head = parse_array(line);
        size_t n_pos = line.find("n =");
        int n = 0;
        if (n_pos != std::string::npos) {
             try {
                n = std::stoi(line.substr(n_pos + 3));
             } catch (...) {}
        }
        
        if (n > 0 && n <= head.size()) {
            int remove_idx = head.size() - n;
            head.erase(head.begin() + remove_idx);
        }
        
        std::cout << "[";
        for(size_t i=0; i<head.size(); ++i) {
            std::cout << head[i] << (i == head.size() - 1 ? "" : ",");
        }
        std::cout << "]" << std::endl;
    }
    return 0;
}
