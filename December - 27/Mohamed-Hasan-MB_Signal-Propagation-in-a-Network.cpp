#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M;
    cin >> N;
    cin >> M;
    vector<vector<pair<int,int>>> adj(N);
    for (int i = 0; i < M; i++) {
        int u, v, t;
        cin >> u >> v >> t;
        adj[u].push_back({v, t});
    }
    int S;
    cin >> S;
    const int INF = 1e9;
    vector<int> dist(N, INF);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
    dist[S] = 0;
    pq.push({0, S});
    while (!pq.empty()) {
        auto [d, u] = pq.top();
        pq.pop();
        if (d > dist[u]) continue;
        for (auto [v, w] : adj[u]) {
            if (dist[v] > d + w) {
                dist[v] = d + w;
                pq.push({dist[v], v});
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INF) {
            cout << -1;
            return 0;
        }
        ans = max(ans, dist[i]);
    }
    cout << ans;
    return 0;
}
