#include <iostream>
#include <deque>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int V, E;
    cin >> V >> E;
    vector<vector<int>> adj(V);
    
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> water(V);
    for (int i = 0; i < V; i++) cin >> water[i];

    queue<int> q;
    vector<int> time(V, -1);

    for (int i = 0; i < V; i++) {
        if (water[i] == 1) {
            q.push(i);
            time[i] = 0;
        }
    }

    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        for (int neighbor : adj[curr]) {
            if (time[neighbor] == -1) {
                time[neighbor] = time[curr] + 1;
                q.push(neighbor);
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < V; i++) {
        if (time[i] == -1) {
            cout << -1;
            return 0;
        }
        ans = max(ans, time[i]);
    }

    cout << ans;
}
