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
    
    std::vector<int> nums;
    int count = 0;
    while(count < N) {
        int x;
        if(std::cin >> x) {
            nums.push_back(x);
            count++;
        } else {
            std::cin.clear();
            std::string temp;
            std::cin >> temp;
        }
    }
    
    int left = 0;
    int right = N - 1;
    bool from_left = true;
    while (left <= right) {
        if (from_left) {
            std::cout << nums[left++] << (left <= right || !from_left ? " " : "");
        } else {
            std::cout << nums[right--] << (left <= right || from_left ? " " : "");
        }
        from_left = !from_left;
    }
    std::cout << std::endl;
    return 0;
}
