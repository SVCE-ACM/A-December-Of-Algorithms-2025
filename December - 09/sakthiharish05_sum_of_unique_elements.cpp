#include <iostream>
#include <vector>
#include <map>

int main() {
    int N;
    if (std::cin >> N) {
        std::map<int, int> counts;
        for(int i=0; i<N; ++i) {
            int val;
            std::cin >> val;
            counts[val]++;
        }
        long long sum = 0;
        for(auto const& [val, count] : counts) {
            if (count == 1) {
                sum += val;
            }
        }
        std::cout << sum << std::endl;
    }
    return 0;
}
