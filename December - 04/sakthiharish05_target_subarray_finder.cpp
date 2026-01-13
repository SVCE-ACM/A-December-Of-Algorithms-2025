#include <iostream>
#include <vector>
#include <map>

int main() {
    int N;
    long long K;
    if (std::cin >> N >> K) {
        std::vector<long long> arr(N);
        for(int i=0; i<N; ++i) std::cin >> arr[i];

        std::map<long long, int> prefix_map;
        prefix_map[0] = -1;
        long long current_sum = 0;
        int start = -1, end = -1;
        
        for(int i=0; i<N; ++i) {
            current_sum += arr[i];
            if (prefix_map.count(current_sum - K)) {
                start = prefix_map[current_sum - K] + 1;
                end = i;
                break;
            }
            if (!prefix_map.count(current_sum)) {
                prefix_map[current_sum] = i;
            }
        }
        
        if (start != -1) {
            std::cout << start << " " << end << std::endl;
        } else {
            std::cout << "-1 -1" << std::endl;
        }
    }
    return 0;
}
