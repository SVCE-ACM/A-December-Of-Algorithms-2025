#include <iostream>
#include <vector>
#include <map>

int main() {
    int n;
    if (std::cin >> n) {
        std::map<int, int> counts;
        std::vector<int> nums(n);
        for(int i=0; i<n; ++i) {
            std::cin >> nums[i];
            counts[nums[i]]++;
        }
        
        long long sum = 0;
        for (auto const& [val, count] : counts) {
            if (count == 1) {
                sum += val;
            }
        }
        std::cout << sum << std::endl;
    }
    return 0;
}
