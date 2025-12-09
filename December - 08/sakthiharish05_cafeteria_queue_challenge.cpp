#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <deque>

std::vector<int> parse_array(std::string line) {
    std::vector<int> res;
    size_t start = line.find('[');
    size_t end = line.find(']');
    if (start != std::string::npos && end != std::string::npos) {
        std::string content = line.substr(start + 1, end - start - 1);
        std::stringstream ss(content);
        std::string segment;
        while(std::getline(ss, segment, ',')) {
            if (!segment.empty()) {
                try {
                    res.push_back(std::stoi(segment));
                } catch(...) {}
            }
        }
    }
    return res;
}

int main() {
    std::string line1, line2;
    if (std::getline(std::cin, line1) && std::getline(std::cin, line2)) {
        std::vector<int> students_vec = parse_array(line1);
        std::vector<int> sandwiches_vec = parse_array(line2);
        
        std::deque<int> q;
        for(int s : students_vec) q.push_back(s);
        
        int stack_idx = 0;
        int unable_count = 0;
        while (!q.empty() && stack_idx < sandwiches_vec.size()) {
            if (q.front() == sandwiches_vec[stack_idx]) {
                q.pop_front();
                stack_idx++;
                unable_count = 0;
            } else {
                int s = q.front();
                q.pop_front();
                q.push_back(s);
                unable_count++;
            }
            if (unable_count == q.size()) break;
        }
        std::cout << q.size() << std::endl;
    }
    return 0;
}
