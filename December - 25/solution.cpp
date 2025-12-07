#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <cctype>

struct State {
    int r, c, keys, steps;
};

int main() {
    int m, n;
    if (std::cin >> m >> n) {
        std::vector<std::string> grid(m);
        int startR, startC;
        for (int i = 0; i < m; ++i) {
            std::cin >> grid[i];
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        static bool vis[30][30][1024]; 
        
        std::queue<State> q;
        q.push({startR, startC, 0, 0});
        vis[startR][startC][0] = true;
        
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        
        while (!q.empty()) {
            State curr = q.front();
            q.pop();
            
            if (grid[curr.r][curr.c] == 'T') {
                std::cout << curr.steps << std::endl;
                return 0;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    char cell = grid[nr][nc];
                    if (cell == '#') continue;
                    
                    int nkeys = curr.keys;
                    
                    if (islower(cell)) {
                        int keyBit = cell - 'a';
                        nkeys |= (1 << keyBit);
                    } else if (isupper(cell)) {
                        int doorBit = cell - 'A';
                        if (!(nkeys & (1 << doorBit))) {
                            continue;
                        }
                    }
                    
                    if (!vis[nr][nc][nkeys]) {
                        vis[nr][nc][nkeys] = true;
                        q.push({nr, nc, nkeys, curr.steps + 1});
                    }
                }
            }
        }
        
        std::cout << -1 << std::endl;
    }
    return 0;
}
