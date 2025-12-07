#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>

struct Turtle {
    int position;
    int speed;
    int index;
};

void parse_array(const std::string& input, std::vector<int>& out, const std::string& key) {
    size_t key_pos = input.find(key);
    if (key_pos == std::string::npos) return;
    size_t bracket_start = input.find('[', key_pos);
    size_t bracket_end = input.find(']', bracket_start);
    if (bracket_start != std::string::npos && bracket_end != std::string::npos) {
        std::string content = input.substr(bracket_start + 1, bracket_end - bracket_start - 1);
        for(char &c : content) if (c == ',') c = ' ';
        std::stringstream ss(content);
        int val;
        while(ss >> val) out.push_back(val);
    }
}

int parse_int(const std::string& input, const std::string& key) {
    size_t pos = input.find(key);
    if (pos == std::string::npos) return -1; 
    size_t start = input.find_first_of("-0123456789", pos + key.length());
    if (start == std::string::npos) return -1;
    return std::stoi(input.substr(start));
}

int main() {
    std::string line;
    std::string all_input = "";
    while (std::getline(std::cin, line)) {
        all_input += line + " ";
    }
    
    int target = parse_int(all_input, "target");
    int n = parse_int(all_input, "n");
    
    size_t n_assign_pos = all_input.find("n =");
    if (n_assign_pos == std::string::npos) n_assign_pos = all_input.find("n=");
    if (n_assign_pos != std::string::npos) {
        size_t start = all_input.find_first_of("-0123456789", n_assign_pos + 1);
        if (start != std::string::npos) n = std::stoi(all_input.substr(start));
    }
    
    std::vector<int> positions;
    std::vector<int> speeds;
    parse_array(all_input, positions, "position");
    parse_array(all_input, speeds, "speed");
    
    if (n == 0) {
        std::cout << "No turtle fleets formed." << std::endl;
        return 0;
    }
    
    std::vector<Turtle> turtles;
    for (int i=0; i<n; ++i) {
        turtles.push_back({positions[i], speeds[i], i});
    }
    
    std::sort(turtles.begin(), turtles.end(), [](const Turtle& a, const Turtle& b) {
        return a.position > b.position;
    });
    
    int fleets = 0;
    double prev_time = -1.0;
    
    for (int i=0; i<n; ++i) {
        double time = (double)(target - turtles[i].position) / turtles[i].speed;
        if (i == 0 || time > prev_time) {
            fleets++;
            prev_time = time;
        } 
    }
    
    std::cout << "The number of turtle fleets is: " << fleets << std::endl;
    
    return 0;
}
