#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

int main() {
    int n;
    if (std::cin >> n) {
        std::vector<int> heights(n);
        for (int i = 0; i < n; ++i) {
            std::cin >> heights[i];
        }

        std::vector<int> result(n);
        std::stack<int> s; 
        
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && s.top() <= heights[i]) {
                s.pop();
            }
            if (s.empty()) {
                result[i] = -1;
            } else {
                result[i] = s.top();
            }
            s.push(heights[i]);
        }

        for (int i = 0; i < n; ++i) {
            std::cout << result[i] << (i == n - 1 ? "" : " ");
        }
        std::cout << std::endl;
    }
    return 0;
}
