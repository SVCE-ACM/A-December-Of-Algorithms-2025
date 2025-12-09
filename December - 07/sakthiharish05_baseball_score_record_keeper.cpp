#include <iostream>
#include <vector>
#include <string>
#include <numeric>
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
            std::vector<int> scores;
            while(std::getline(ss, segment, ',')) {
                 std::string op = "";
                 for(char c : segment) {
                     if (c != '"' && c != '\'' && c != ' ') op += c;
                 }
                 if (op.empty()) continue;
                 
                 if (op == "C") {
                     if (!scores.empty()) scores.pop_back();
                 } else if (op == "D") {
                     if (!scores.empty()) scores.push_back(scores.back() * 2);
                 } else if (op == "+") {
                     if (scores.size() >= 2) {
                         int sz = scores.size();
                         scores.push_back(scores[sz-1] + scores[sz-2]);
                     }
                 } else {
                     try {
                         scores.push_back(std::stoi(op));
                     } catch(...) {}
                 }
            }
            long long sum = 0;
            for(int s : scores) sum += s;
            std::cout << sum << std::endl;
        }
    }
    return 0;
}
