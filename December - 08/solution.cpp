#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <sstream>

std::vector<int> parse_array(const std::string& input, size_t& pos) {
    std::vector<int> result;
    size_t start = input.find('[', pos);
    if (start == std::string::npos) return result;
    size_t end = input.find(']', start);
    if (end == std::string::npos) return result;
    
    std::string content = input.substr(start + 1, end - start - 1);
    for (char &c : content) if (c == ',') c = ' ';
    
    std::stringstream ss(content);
    int val;
    while (ss >> val) {
        result.push_back(val);
    }
    pos = end + 1;
    return result;
}

int main() {
    std::string line;
    std::string all_input = "";
    while (std::getline(std::cin, line)) {
        all_input += line + " ";
    }
    
    size_t pos = 0;
    std::vector<int> students = parse_array(all_input, pos);
    std::vector<int> sandwiches = parse_array(all_input, pos);

    std::queue<int> q;
    for (int s : students) q.push(s);
    
    int sandwich_idx = 0;
    int consecutive_fails = 0;
    
    while (!q.empty() && sandwich_idx < sandwiches.size()) {
        int student = q.front();
        q.pop();
        
        if (student == sandwiches[sandwich_idx]) {
            sandwich_idx++;
            consecutive_fails = 0;
        } else {
            q.push(student);
            consecutive_fails++;
        }
        
        if (consecutive_fails == q.size()) {
            break;
        }
    }
    
    std::cout << q.size() << std::endl;
    return 0;
}
