#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

int main() {
    int v, e;
    if (std::cin >> v >> e) {
        std::vector<std::vector<int>> adj(v);
        for (int i = 0; i < e; ++i) {
            int u, dest;
            std::cin >> u >> dest;
            if (u >= 0 && u < v && dest >= 0 && dest < v) {
                adj[u].push_back(dest);
                adj[dest].push_back(u);
            }
        }
        
        std::queue<int> q;
        std::vector<int> dist(v, -1);
        
        for (int i = 0; i < v; ++i) {
            int state;
            std::cin >> state;
            if (state == 1) {
                dist[i] = 0;
                q.push(i);
            }
        }
        
        int max_time = 0;
        
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            max_time = std::max(max_time, dist[curr]);
            
            for (int neighbor : adj[curr]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    q.push(neighbor);
                }
            }
        }
        
        bool possible = true;
        for (int i = 0; i < v; ++i) {
            if (dist[i] == -1) {
                possible = false;
                break;
            }
        }
        
        std::cout << (possible ? max_time : -1) << std::endl;
    }
    return 0;
}
