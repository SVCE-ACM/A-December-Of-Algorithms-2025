#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <map>
#include <queue>
#include <algorithm>
#include <set>

std::map<int, std::vector<int>> adj;
std::set<int> all_nodes;

void parse_tree(std::string s) {
    if (s.empty()) return;
    if (s.front() == '[') s = s.substr(1);
    if (s.back() == ']') s.pop_back();
    
    std::vector<std::string> nodes;
    std::stringstream ss(s);
    std::string seg;
    while(std::getline(ss, seg, ',')) {
        size_t first = seg.find_first_not_of(" ");
        if (first != std::string::npos) {
            size_t last = seg.find_last_not_of(" ");
            nodes.push_back(seg.substr(first, last - first + 1));
        } else nodes.push_back("null");
    }
    
    if (nodes.empty()) return;
    
    if (nodes[0] == "null") return;
    int root_val = std::stoi(nodes[0]);
    all_nodes.insert(root_val);
    
    std::queue<int> q;
    q.push(root_val);
    
    int i = 1;
    while(!q.empty() && i < nodes.size()) {
        int curr = q.front();
        q.pop();
        
        if (i < nodes.size()) {
            if (nodes[i] != "null") {
                int left_val = std::stoi(nodes[i]);
                adj[curr].push_back(left_val);
                adj[left_val].push_back(curr);
                all_nodes.insert(left_val);
                q.push(left_val);
            }
            i++;
        }
        
        if (i < nodes.size()) {
            if (nodes[i] != "null") {
                int right_val = std::stoi(nodes[i]);
                adj[curr].push_back(right_val);
                adj[right_val].push_back(curr);
                all_nodes.insert(right_val);
                q.push(right_val);
            }
            i++;
        }
    }
}

int main() {
    std::string line;
    int target = -1;
    std::string tree_str = "";
    
    while(std::getline(std::cin, line)) {
        if (line.find("Target") != std::string::npos || line.find("target") != std::string::npos) {
             size_t eq = line.find('=');
             if (eq != std::string::npos) {
                 try { target = std::stoi(line.substr(eq+1)); } catch(...) {}
             }
        } else if (line.find('[') != std::string::npos) {
            tree_str = line;
        } else if (!line.empty() && isdigit(line[0])) {
            tree_str += line;
        }
    }
    
    if (target == -1) return 0;
    
    parse_tree(tree_str);
    
    if (all_nodes.find(target) == all_nodes.end()) return 0;
    
    std::queue<int> q;
    q.push(target);
    std::set<int> visited;
    visited.insert(target);
    std::vector<int> current_layer;
    
    std::cout << target << std::endl;
    
    while(!q.empty()) {
        int sz = q.size();
        std::vector<int> next_layer_nodes;
        for(int k=0; k<sz; ++k) {
            int u = q.front();
            q.pop();
            
            for(int v : adj[u]) {
                if (visited.find(v) == visited.end()) {
                    visited.insert(v);
                    next_layer_nodes.push_back(v);
                    q.push(v);
                }
            }
        }
        if (!next_layer_nodes.empty()) {
             for(size_t i=0; i<next_layer_nodes.size(); ++i) {
                std::cout << next_layer_nodes[i] << (i == next_layer_nodes.size()-1 ? "" : ", ");
            }
            std::cout << std::endl;
        }
    }
    
    return 0;
}
