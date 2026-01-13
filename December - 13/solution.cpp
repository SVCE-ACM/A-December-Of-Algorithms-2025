#include <iostream>
#include <vector>

int main() {
    int n;
    if (std::cin >> n) {
        std::vector<int> heights(n);
        for (int i = 0; i < n; ++i) {
            std::cin >> heights[i];
        }

        std::vector<int> peaks;
        for (int i = 1; i < n - 1; ++i) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peaks.push_back(i);
            }
        }

        if (peaks.empty()) {
            std::cout << "-1" << std::endl;
        } else {
            for (size_t i = 0; i < peaks.size(); ++i) {
                std::cout << peaks[i] << (i == peaks.size() - 1 ? "" : " ");
            }
            std::cout << std::endl;
        }
    }
    return 0;
}
