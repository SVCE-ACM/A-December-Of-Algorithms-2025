#include <iostream>
#include <vector>

int main() {
    int N;
    if (std::cin >> N) {
        std::vector<int> nums(N);
        for(int i=0; i<N; ++i) std::cin >> nums[i];
        
        int i = 0;
        while (i < N) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                std::swap(nums[i], nums[correct]);
            } else {
                i++;
            }
        }
        
        int missing = -1;
        int duplicate = -1;
        for (int j = 0; j < N; ++j) {
            if (nums[j] != j + 1) {
                missing = j + 1;
                duplicate = nums[j];
                break;
            }
        }
        
        std::cout << "Missing Number: " << missing << "\n"
                  << "Duplicate Number: " << duplicate << std::endl;
    }
    return 0;
}
