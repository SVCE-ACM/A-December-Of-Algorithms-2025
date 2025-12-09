#include <iostream>
#include <vector>
#include <stack>

int main() {
    int N;
    if (std::cin >> N) {
        std::vector<int> heights(N);
        for(int i=0; i<N; ++i) std::cin >> heights[i];
        
        std::vector<int> result(N, -1);
        std::stack<int> s;
        
        for(int i=0; i<N; ++i) {
            while(!s.empty() && heights[s.top()] < heights[i]) {
                result[s.top()] = heights[i];
                s.pop();
            }
            s.push(i);
        }
        
        for(int i=0; i<N; ++i) {
            std::cout << result[i] << (i == N-1 ? "" : " ");
        }
        std::cout << std::endl;
    }
    return 0;
}
