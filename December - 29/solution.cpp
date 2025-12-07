#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <sstream>
#include <algorithm>

const int INF = 1e9;

struct Edge {
    int to;
    int weight;
};

int main() {
    std::string line;
    std::string all_input = "";
    while (std::getline(std::cin, line)) {
        all_input += line + " ";
    }
    
    int V = 0;
    size_t v_pos = all_input.find("V");
    if (v_pos != std::string::npos) {
        size_t eq = all_input.find("=", v_pos);
        if (eq != std::string::npos) {
            size_t start = all_input.find_first_of("0123456789", eq);
            if (start != std::string::npos) {
                V = std::stoi(all_input.substr(start));
            }
        }
    }
    
    if (V == 0) return 0;
    
    std::vector<std::vector<Edge>> adj(V);
    
    size_t edges_pos = all_input.find("edges");
    if (edges_pos != std::string::npos) {
        size_t bracket = all_input.find("[", edges_pos);
        if (bracket != std::string::npos) {
            std::string content = all_input.substr(bracket + 1);
            for (char &c : content) {
                if (c == ',' || c == '[' || c == ']') c = ' ';
            }
            std::stringstream ss(content);
            int u, v, w;
            while (ss >> u >> v >> w) {
                if (u >= 0 && u < V && v >= 0 && v < V) {
                    adj[u].push_back({v, w});
                    adj[v].push_back({u, w});
                }
            }
        }
    }
    
    int min_cycle = INF;
    
    for (int i = 0; i < V; ++i) {
        std::vector<int> dist(V, INF);
        std::vector<int> parent(V, -1);
        dist[i] = 0;
        
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
        pq.push({0, i});
        
        while (!pq.empty()) {
            int d = pq.top().first;
            int u = pq.top().second;
            pq.pop();
            
            if (d > dist[u]) continue;
            
            for (const auto& edge : adj[u]) {
                if (dist[edge.to] == INF) {
                    dist[edge.to] = dist[u] + edge.weight;
                    parent[edge.to] = u;
                    pq.push({dist[edge.to], edge.to});
                } else if (edge.to != parent[u]) {
                    min_cycle = std::min(min_cycle, dist[u] + dist[edge.to] + edge.weight);
                }
            }
        }
    }
    
    if (min_cycle == INF) {
        std::cout << -1 << std::endl; 
    } else {
        std::cout << min_cycle << std::endl;
    }
    return 0;
}
