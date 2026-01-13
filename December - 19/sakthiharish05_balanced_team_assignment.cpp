#include <iostream>
#include <vector>
#include <numeric>
#include <cmath>
#include <algorithm>

int main() {
    int N;
    if (std::cin >> N) {
        std::vector<int> skills(N);
        int sum = 0;
        for(int i=0; i<N; ++i) {
            std::cin >> skills[i];
            sum += skills[i];
        }
        
        std::vector<bool> dp(sum + 1, false);
        dp[0] = true;
        
        for(int s : skills) {
            for(int j = sum; j >= s; --j) {
                if(dp[j-s]) dp[j] = true;
            }
        }
        
        int min_diff = sum;
        for(int j=0; j<=sum/2; ++j) {
            if (dp[j]) {
                min_diff = std::min(min_diff, sum - 2 * j);
            }
        }
        std::cout << min_diff << std::endl;
    }
    return 0;
}
