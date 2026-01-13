#include <iostream>
#include <vector>

int main() {
    int N;
    if (std::cin >> N) {
        std::vector<int> heights(N);
        for(int i=0; i<N; ++i) std::cin >> heights[i];
        
        std::vector<int> peaks;
        for(int i=1; i<N-1; ++i) {
            if (heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
                peaks.push_back(i);
            }
        }
        
        if (peaks.empty()) {
            std::cout << "-1" << std::endl;
        } else {
            for(size_t i=0; i<peaks.size(); ++i) {
                std::cout << peaks[i] << (i == peaks.size()-1 ? "" : " ");
            }
            std::cout << std::endl;
        }
    }
    return 0;
}
