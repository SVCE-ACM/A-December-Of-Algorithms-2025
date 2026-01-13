#include <iostream>
#include <vector>
#include <map>

int main() {
    int n;
    long long k;
    if (std::cin >> n >> k) {
        std::map<long long, int> prefix_map;
        prefix_map[0] = -1;
        long long current_sum = 0;
        std::vector<long long> arr(n);
        
        for(int i=0; i<n; ++i) {
             std::cin >> arr[i];
        }

        bool found = false;
        for (int i = 0; i < n; ++i) {
            current_sum += arr[i];
            long long target = current_sum - k;
            if (prefix_map.count(target)) {
                std::cout << prefix_map[target] + 1 << " " << i << std::endl;
                found = true;
                break;
            }
            if (prefix_map.find(current_sum) == prefix_map.end()) {
                prefix_map[current_sum] = i;
            }
        }

        if (!found) {
            std::cout << "-1 -1" << std::endl;
        }
    }
    return 0;
}
