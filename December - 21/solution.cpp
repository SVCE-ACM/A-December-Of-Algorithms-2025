#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

int main() {
    int n;
    if (std::cin >> n) {
        std::deque<int> q;
        for (int i = 0; i < n; ++i) {
            int val;
            std::cin >> val;
            q.push_back(val);
        }

        std::vector<int> sorted_parcels;
        while (!q.empty()) {
            int min_val = q.front();
            int min_idx = 0; 
            
            for (size_t i = 1; i < q.size(); ++i) {
                if (q[i] < min_val) {
                    min_val = q[i];
                    min_idx = i;
                }
            }
            
            for (int i = 0; i < min_idx; ++i) {
                int front = q.front();
                q.pop_front();
                q.push_back(front);
            }
            
            sorted_parcels.push_back(q.front());
            q.pop_front();
        }
        
        for (size_t i = 0; i < sorted_parcels.size(); ++i) {
            std::cout << sorted_parcels[i] << (i == sorted_parcels.size() - 1 ? "" : " ");
        }
        std::cout << std::endl;
    }
    return 0;
}
