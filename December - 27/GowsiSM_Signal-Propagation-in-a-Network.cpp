#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    int N, M, S;
    cin >> N >> M;
    vector<vector<pair<int,int>>> adj(N);

    for (int i = 0; i < M; i++) {
        int u, v, t;
        cin >> u >> v >> t;
        adj[u].push_back({v, t});
    }
    cin >> S;

    vector<int> dist(N, INT_MAX);
    dist[S] = 0;
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({0, S});

    while (!pq.empty()) {
        auto [time, node] = pq.top();
        pq.pop();
        if (time > dist[node]) continue;

        for (auto [nextNode, wt] : adj[node]) {
            if (dist[nextNode] > time + wt) {
                dist[nextNode] = time + wt;
                pq.push({dist[nextNode], nextNode});
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (dist[i] == INT_MAX) {
            cout << -1;
            return 0;
        }
        ans = max(ans, dist[i]);
    }

    cout << ans;
}
