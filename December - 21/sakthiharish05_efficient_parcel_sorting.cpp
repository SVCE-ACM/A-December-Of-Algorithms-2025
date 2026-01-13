#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int N;
    if (std::cin >> N) {
        std::vector<int> weights(N);
        for(int i=0; i<N; ++i) std::cin >> weights[i];
        
        std::sort(weights.begin(), weights.end());
        
        for(int i=0; i<N; ++i) {
            std::cout << weights[i] << (i == N-1 ? "" : " ");
        }
        std::cout << std::endl;
    }
    return 0;
}
