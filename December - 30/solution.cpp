#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <string>
#include <sstream>
#include <algorithm>

void parse_tree(const std::string& input, std::map<int, std::vector<int>>& adj) {
    size_t start = input.find('[');
    size_t end = input.find(']');
    if (start != std::string::npos && end != std::string::npos) {
        std::string content = input.substr(start + 1, end - start - 1);
        std::replace(content.begin(), content.end(), ',', ' ');
        
        std::stringstream ss(content);
        std::vector<std::string> nodes;
        std::string val;
        while(ss >> val) nodes.push_back(val);
        
        if (nodes.empty()) return;
        
        std::queue<int> q;
        try {
            if (nodes[0] != "null") {
                int root = std::stoi(nodes[0]);
                q.push(root);
                
                size_t i = 1;
                while (!q.empty() && i < nodes.size()) {
                    int curr = q.front();
                    q.pop();
                    
                    if (i < nodes.size() && nodes[i] != "null") {
                        int left = std::stoi(nodes[i]);
                        adj[curr].push_back(left);
                        adj[left].push_back(curr);
                        q.push(left);
                    }
                    i++;
                    
                    if (i < nodes.size() && nodes[i] != "null") {
                        int right = std::stoi(nodes[i]);
                        adj[curr].push_back(right);
                        adj[right].push_back(curr);
                        q.push(right);
                    }
                    i++;
                }
            }
        } catch (...) {}
    }
}

int main() {
    std::string line;
    std::string all_input = "";
    while(std::getline(std::cin, line)) {
        all_input += line + " ";
    }
    
    std::map<int, std::vector<int>> adj;
    parse_tree(all_input, adj);
    
    int target = -1;
    size_t target_pos = all_input.find("Target node =");
    if (target_pos == std::string::npos) target_pos = all_input.find("Target node="); 
    if (target_pos == std::string::npos) target_pos = all_input.find("root");
    
    if (target_pos != std::string::npos) {
        size_t start = all_input.find_first_of("0123456789", target_pos + 13);
        if (start != std::string::npos) {
            target = std::stoi(all_input.substr(start));
        }
    }
    
    if (target != -1) {
        std::map<int, int> visited;
        std::map<int, std::vector<int>> levels;
        std::queue<std::pair<int, int>> q;
        
        q.push({target, 0});
        visited[target] = 0;
        
        int max_dist = 0;
        
        while(!q.empty()) {
            int u = q.front().first;
            int d = q.front().second;
            q.pop();
            
            levels[d].push_back(u);
            max_dist = std::max(max_dist, d);
            
            for (int v : adj[u]) {
                if (visited.find(v) == visited.end()) {
                    visited[v] = d + 1;
                    q.push({v, d + 1});
                }
            }
        }
        
        for (int d = 0; d <= max_dist; ++d) {
            std::vector<int>& nodes = levels[d];
            for (size_t i = 0; i < nodes.size(); ++i) {
                std::cout << nodes[i] << (i == nodes.size() - 1 ? "" : ", ");
            }
            std::cout << std::endl;
        }
    }
    
    return 0;
}
