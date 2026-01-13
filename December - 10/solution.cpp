#include <iostream>
#include <vector>
#include <string>

int main() {
    std::string token;
    std::vector<int> nums;
    int n = -1;
    
    while (std::cin >> token) {
        try {
            std::string clean_token = "";
            for (char c : token) {
                if (isdigit(c) || c == '-') clean_token += c; 
            }
            if (!clean_token.empty()) {
                int val = std::stoi(clean_token);
                if (n == -1) {
                    n = val;
                } else {
                    nums.push_back(val);
                }
            }
        } catch (...) {
        }
    }

    if (n != -1 && nums.size() == n) {
        int left = 0;
        int right = n - 1;
        bool first = true;
        while (left <= right) {
            if (!first) std::cout << " ";
            std::cout << nums[left];
            first = false;
            left++;
            
            if (left > right) break;
            
            std::cout << " " << nums[right];
            right--;
        }
        std::cout << std::endl;
    }
    return 0;
}
