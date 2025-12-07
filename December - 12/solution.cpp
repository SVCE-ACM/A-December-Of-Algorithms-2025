#include <iostream>
#include <vector>
#include <cmath>

int main() {
    long long n;
    if (std::cin >> n) {
        long long current_sum = 0;
        long long current_sq_sum = 0;
        long long val;
        
        for (int i = 0; i < n; ++i) {
            std::cin >> val;
            current_sum += val;
            current_sq_sum += val * val;
        }

        long long expected_sum = n * (n + 1) / 2;
        long long expected_sq_sum = n * (n + 1) * (2 * n + 1) / 6;
        
        long long diff_sum = current_sum - expected_sum; 
        long long diff_sq_sum = current_sq_sum - expected_sq_sum; 
        
        long long sum_D_M = diff_sq_sum / diff_sum; 
        
        long long D = (diff_sum + sum_D_M) / 2;
        long long M = sum_D_M - D;
        
        std::cout << M << " " << D << std::endl;
    }
    return 0;
}
