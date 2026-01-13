#include <iostream>
#include <vector>
#include <queue>

int main() {
    int V, E;
    if (std::cin >> V >> E) {
        std::vector<std::vector<int>> adj(V);
        for(int i=0; i<E; ++i) {
            int u, v;
            std::cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        std::queue<int> q;
        std::vector<int> status(V);
        int filled_count = 0;
        for(int i=0; i<V; ++i) {
            std::cin >> status[i];
            if (status[i] == 1) {
                q.push(i);
                filled_count++;
            }
        }
        
        if (filled_count == 0) {
            std::cout << (V == 0 ? 0 : -1) << std::endl;
            return 0;
        }
        
        int minutes = 0;
        while (!q.empty()) {
            if (filled_count == V) break;
            int sz = q.size();
            bool spread = false;
            for(int i=0; i<sz; ++i) {
                int u = q.front();
                q.pop();
                for(int v : adj[u]) {
                    if (status[v] == 0) {
                        status[v] = 1;
                        filled_count++;
                        q.push(v);
                        spread = true;
                    }
                }
            }
            if (spread) minutes++;
        }
        
        if (filled_count == V) std::cout << minutes << std::endl;
        else std::cout << "-1" << std::endl;
    }
    return 0;
}
