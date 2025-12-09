#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <string>
#include <sstream>

const long long INF = 1e18;

std::vector<std::tuple<int, int, int>> parse_edges(std::string text) {
    std::vector<std::tuple<int, int, int>> res;
    for(char &c : text) if (!isdigit(c)) c = ' ';
    std::stringstream ss(text);
    int u, v, w;
    while(ss >> u >> v >> w) {
        res.push_back({u, v, w});
    }
    return res;
}

int main() {
    int V;
    std::string line;
    std::vector<int> nums;
    char c;
    bool collecting = false;
    std::string temp;
    while(std::cin.get(c)) {
        if (isdigit(c)) {
            temp += c;
            collecting = true;
        } else {
            if (collecting) {
                nums.push_back(std::stoi(temp));
                temp = "";
                collecting = false;
            }
        }
    }
    if (collecting) nums.push_back(std::stoi(temp));
    
    if (nums.empty()) return 0;
    
    V = nums[0];
    
    std::vector<std::vector<std::pair<int, int>>> adj(V);
    for(size_t i = 1; i + 2 < nums.size(); i += 3) {
        int u = nums[i];
        int v = nums[i+1];
        int w = nums[i+2];
        if (u < V && v < V) {
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }
    }
    
    long long min_cycle = INF;
    
    for(int start_node = 0; start_node < V; ++start_node) {
        std::vector<long long> dist(V, INF);
        std::vector<int> parent(V, -1);
        std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long long, int>>> pq;
        
        dist[start_node] = 0;
        pq.push({0, start_node});
        
        while(!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            
            if (d > dist[u]) continue;
            
            for(auto& edge : adj[u]) {
                int v = edge.first;
                int w = edge.second;
                
                if (dist[v] == INF) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.push({dist[v], v});
                } else if (parent[u] != v) {
                    min_cycle = std::min(min_cycle, dist[u] + dist[v] + w);
                }
            }
        }
    }
    
    if (min_cycle == INF) std::cout << "-1" << std::endl;
    else std::cout << min_cycle << std::endl;
    
    return 0;
}
