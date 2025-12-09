#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>

std::vector<int> parse_int_array(std::string line) {
    std::vector<int> res;
    size_t start = line.find('[');
    size_t end = line.find(']');
    if (start != std::string::npos && end != std::string::npos) {
        std::string content = line.substr(start + 1, end - start - 1);
        std::stringstream ss(content);
        std::string segment;
        while(std::getline(ss, segment, ',')) {
            if (!segment.empty()) res.push_back(std::stoi(segment));
        }
    }
    return res;
}

int parse_int(std::string line) {
    size_t eq = line.find('=');
    if (eq != std::string::npos) {
        return std::stoi(line.substr(eq + 1));
    }
    return 0;
}

struct Turtle {
    int pos;
    int speed;
};

int main() {
    int target = 0;
    int n = 0;
    std::vector<int> pos_vec;
    std::vector<int> speed_vec;
    
    std::string line;
    std::getline(std::cin, line); target = parse_int(line);
    std::getline(std::cin, line); n = parse_int(line);
    std::getline(std::cin, line); pos_vec = parse_int_array(line);
    std::getline(std::cin, line); speed_vec = parse_int_array(line);
    
    if (n == 0) {
        std::cout << "No turtle fleets formed." << std::endl;
        return 0;
    }
    
    std::vector<Turtle> turtles;
    for(int i=0; i<n; ++i) {
        turtles.push_back({pos_vec[i], speed_vec[i]});
    }
    
    std::sort(turtles.begin(), turtles.end(), [](const Turtle& a, const Turtle& b) {
        return a.pos > b.pos;
    });
    
    int fleets = 0;
    double current_fleet_time = -1.0;
    
    for(int i=0; i<n; ++i) {
        double time = (double)(target - turtles[i].pos) / turtles[i].speed;
        if (fleets == 0 || time > current_fleet_time) {
            fleets++;
            current_fleet_time = time;
        }
    }
    
    std::cout << "The number of turtle fleets is: " << fleets << std::endl;
    return 0;
}
