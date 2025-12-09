#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>

int main() {
    int n;
    if (std::cin >> n) {
        std::vector<int> ratings(n);
        for(int i=0; i<n; ++i) std::cin >> ratings[i];
        
        std::vector<int> candies(n, 1);
        
        for(int i=1; i<n; ++i) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i=n-2; i>=0; --i) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = std::max(candies[i], candies[i+1] + 1);
            }
        }
        
        long long total = 0;
        for(int c : candies) total += c;
        std::cout << total << std::endl;
    }
    return 0;
}
