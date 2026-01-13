#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

const int INF = 1e9;

int main() {
    int N, M;
    if (std::cin >> N >> M) {
        std::vector<std::vector<std::pair<int, int>>> adj(N);
        for(int i=0; i<M; ++i) {
            int u, v, w;
            std::cin >> u >> v >> w;
            if (u >= 0 && u < N) {
                 adj[u].push_back({v, w});
            }
        }
        int S;
        std::cin >> S;
        
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
        std::vector<int> dist(N, INF);
        
        dist[S] = 0;
        pq.push({0, S});
        
        while(!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            
            if (d > dist[u]) continue;
            
            for(auto& edge : adj[u]) {
                int v = edge.first;
                int w = edge.second;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                }
            }
        }
        
        int max_dist = 0;
        bool possible = true;
        for(int i=0; i<N; ++i) {
            if (dist[i] == INF) {
                possible = false;
                break;
            }
            if (dist[i] > max_dist) max_dist = dist[i];
        }
        
        std::cout << (possible ? max_dist : -1) << std::endl;
    }
    return 0;
}
