#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

const int INF = 1e9;

struct Edge {
    int to;
    int weight;
};

int main() {
    int n, m;
    if (std::cin >> n >> m) {
        std::vector<std::vector<Edge>> adj(n);
        for (int i = 0; i < m; ++i) {
            int u, v, w;
            std::cin >> u >> v >> w;
            if (u >= 0 && u < n && v >= 0 && v < n) {
                adj[u].push_back({v, w});
            }
        }
        
        int source;
        std::cin >> source;
        
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
        std::vector<int> dist(n, INF);
        
        dist[source] = 0;
        pq.push({0, source});
        
        while (!pq.empty()) {
            int d = pq.top().first;
            int u = pq.top().second;
            pq.pop();
            
            if (d > dist[u]) continue;
            
            for (const auto& edge : adj[u]) {
                if (dist[u] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.weight;
                    pq.push({dist[edge.to], edge.to});
                }
            }
        }
        
        int max_dist = 0;
        for (int i = 0; i < n; ++i) {
            if (dist[i] == INF) {
                std::cout << -1 << std::endl;
                return 0;
            }
            max_dist = std::max(max_dist, dist[i]);
        }
        
        std::cout << max_dist << std::endl;
    }
    return 0;
}
