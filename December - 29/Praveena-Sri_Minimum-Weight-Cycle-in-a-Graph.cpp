#include <bits/stdc++.h>
using namespace std;
static const long long INF = 1e18;
int main() {
    int V;
    cin >> V;
    int E;
    cin >> E;
    vector<vector<long long>> dist(V, vector<long long>(V, INF));
    vector<vector<long long>> w(V, vector<long long>(V, INF));
    for (int i = 0; i < V; i++)
        dist[i][i] = 0;
    for (int i = 0; i < E; i++) {
        int u, v, wt;
        cin >> u >> v >> wt;
        w[u][v] = w[v][u] = min(w[u][v], (long long)wt);
        dist[u][v] = dist[v][u] = min(dist[u][v], (long long)wt);
    }
    long long ans = INF;
    for (int k = 0; k < V; k++) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (dist[i][j] < INF && w[i][k] < INF && w[k][j] < INF) {
                    ans = min(ans, dist[i][j] + w[i][k] + w[k][j]);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    cout << (ans == INF ? -1 : ans);
    return 0;
}
