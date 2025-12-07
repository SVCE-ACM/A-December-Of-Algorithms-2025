#include <iostream>
#include <vector>
#include <string>

int main() {
    std::string word;
    int n = 0;
    while (std::cin >> word) {
        try {
             std::string num_str = "";
            for (char c : word) {
                if (isdigit(c)) num_str += c;
            }
            if (!num_str.empty()) {
                n = std::stoi(num_str);
                break; 
            }
        } catch (...) {}
    }

    int count = 0;
    if (n > 2) {
        std::vector<bool> is_prime(n, true);
        is_prime[0] = false;
        is_prime[1] = false;
        
        for (int p = 2; p * p < n; p++) {
            if (is_prime[p]) {
                for (int i = p * p; i < n; i += p)
                    is_prime[i] = false;
            }
        }
        
        for (int p = 2; p < n; p++) {
            if (is_prime[p]) count++;
        }
    }

    std::cout << "The count of prime numbers less than " << n << " is: " << count << std::endl;
    return 0;
}
