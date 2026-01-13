#include <iostream>
#include <vector>
#include <string>
#include <sstream>

int main() {
    std::string line;
    std::string all_input = "";
    while (std::getline(std::cin, line)) {
        all_input += line + " ";
    }
    
    std::vector<int> head;
    size_t bracket_start = all_input.find('[');
    size_t bracket_end = all_input.find(']', bracket_start);
    if (bracket_start != std::string::npos && bracket_end != std::string::npos) {
        std::string content = all_input.substr(bracket_start + 1, bracket_end - bracket_start - 1);
        for(char &c : content) if(c==',') c=' ';
        std::stringstream ss(content);
        int val;
        while(ss >> val) head.push_back(val);
    }
    
    size_t n_pos = all_input.find("n", bracket_end);
    int n = 0;
    if (n_pos != std::string::npos) {
        size_t digit_start = all_input.find_first_of("0123456789", n_pos);
        if (digit_start != std::string::npos) {
            n = std::stoi(all_input.substr(digit_start));
        }
    }
    
    if (n > 0 && n <= head.size()) {
        int index_to_remove = head.size() - n;
        std::vector<int> result;
        for (int i=0; i<head.size(); ++i) {
            if (i != index_to_remove) {
                result.push_back(head[i]);
            }
        }
        
        std::cout << "[";
        for (size_t i = 0; i < result.size(); ++i) {
            std::cout << result[i] << (i == result.size() - 1 ? "" : ",");
        }
        std::cout << "]" << std::endl;
    } else {
        std::cout << "[";
         for (size_t i = 0; i < head.size(); ++i) {
         }
         std::cout << "]" << std::endl; 
    }
    return 0;
}
