#include <iostream>
#include <vector>
#include <numeric>
#include <cmath>
#include <bitset>
#include <string>

int main() {
    int n;
    std::string word;
    std::vector<int> tokens;
    while(std::cin >> word) {
        std::string num = "";
        for(char c : word) if(isdigit(c)) num += c;
        if(!num.empty()) tokens.push_back(std::stoi(num));
    }
    
    if (tokens.empty()) return 0;
    n = tokens[0];
    if (tokens.size() < n + 1) return 0; 
    
    std::vector<int> skills;
    int total_sum = 0;
    for(int i=0; i<n; ++i) {
        skills.push_back(tokens[i+1]);
        total_sum += tokens[i+1];
    }
    
    std::bitset<3001> dp;
    dp[0] = 1;
    
    for (int skill : skills) {
        dp |= (dp << skill);
    }
    
    int min_diff = total_sum;
    for (int s = 0; s <= total_sum / 2; ++s) {
        if (dp[s]) {
            int diff = std::abs(total_sum - 2 * s);
            if (diff < min_diff) {
                min_diff = diff;
            }
        }
    }
    
    std::cout << min_diff << std::endl;
    return 0;
}
