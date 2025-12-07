#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <numeric>

int main() {
    std::string line;
    if (std::getline(std::cin, line)) {
        std::vector<std::string> ops;
        std::string current_token = "";
        bool inside_quotes = false;
        
        for (char c : line) {
            if (c == '"') {
                if (inside_quotes) {
                    if (!current_token.empty()) {
                        ops.push_back(current_token);
                    }
                    current_token = "";
                    inside_quotes = false;
                } else {
                    inside_quotes = true;
                }
            } else if (inside_quotes) {
                current_token += c;
            }
        }

        std::vector<int> scores;
        
        for (const std::string& op : ops) {
            if (op == "C") {
                if (!scores.empty()) scores.pop_back();
            } else if (op == "D") {
                if (!scores.empty()) {
                    scores.push_back(scores.back() * 2);
                }
            } else if (op == "+") {
                if (scores.size() >= 2) {
                    int val1 = scores[scores.size() - 1];
                    int val2 = scores[scores.size() - 2];
                    scores.push_back(val1 + val2);
                }
            } else {
                try {
                    scores.push_back(std::stoi(op));
                } catch (...) {}
            }
        }
        
        long long total = 0;
        for (int s : scores) total += s;
        std::cout << total << std::endl;
    }
    return 0;
}
