#include <iostream>
#include <vector>
#include <queue>
using namespace std;

const long long INF = 1e18;

int main() {
    int V, E;
    cin >> V>> E;

    vector<vector<pair<int, int>>> adj(V);
    vector<tuple<int, int, int>> edges;

    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
        edges.push_back({u, v, w});
    }

    long long answer = INF;

    for (auto &[u, v, w] : edges) {
        vector<long long> dist(V, INF);
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<>> pq;

        dist[u] = 0;
        pq.push({0, u});

        while (!pq.empty()) {
            auto [d, node] = pq.top();
            pq.pop();

            if (d > dist[node]) continue;

            for (auto &[next, weight] : adj[node]) {
                if ((node == u && next == v && weight == w) ||
                    (node == v && next == u && weight == w))
                    continue;

                if (dist[next] > d + weight) {
                    dist[next] = d + weight;
                    pq.push({dist[next], next});
                }
            }
        }

        if (dist[v] != INF) answer = min(answer, dist[v] + w);
    }

    if (answer == INF) cout << -1 << endl;
    else cout << answer << endl;

}
