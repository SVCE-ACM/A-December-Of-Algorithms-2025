#include <iostream>
#include <vector>
#include <string>

int main() {
    int N;
    if (!(std::cin >> N)) {
        std::cin.clear();
        std::string s;
        while(std::cin >> s) {
            try {
                N = std::stoi(s);
                break;
            } catch(...) {}
        }
    }
    
    if (N <= 2) {
        std::cout << "The count of prime numbers less than " << N << " is: 0" << std::endl;
        return 0;
    }
    
    std::vector<bool> is_prime(N, true);
    is_prime[0] = is_prime[1] = false;
    for (int p = 2; p * p < N; p++) {
        if (is_prime[p]) {
            for (int i = p * p; i < N; i += p)
                is_prime[i] = false;
        }
    }
    
    int count = 0;
    for (int i = 0; i < N; i++) {
        if (is_prime[i]) count++;
    }
    
    std::cout << "The count of prime numbers less than " << N << " is: " << count << std::endl;
    return 0;
}
