#include <iostream>
#include <iomanip>
#include <string>
#include <algorithm>

std::string to_binary(int n) {
    if (n == 0) return "0";
    std::string binary = "";
    while (n > 0) {
        binary = (n % 2 == 0 ? "0" : "1") + binary;
        n /= 2;
    }
    return binary;
}

int main() {
    int N;
    if (std::cin >> N) {
        for (int i = 1; i <= N; ++i) {
            std::cout << std::setw(5) << std::dec << i
                      << std::setw(6) << std::oct << i
                      << std::setw(6) << std::hex << std::uppercase << i
                      << std::setw(7) << to_binary(i) << "\n";
        }
    }
    return 0;
}
