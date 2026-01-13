#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <tuple>
#include <cctype>

struct State {
    int r, c, keys, dist;
};

int main() {
    int M, N;
    if (std::cin >> M >> N) {
        std::vector<std::string> grid(M);
        int sr, sc;
        
        for(int i=0; i<M; ++i) {
            std::cin >> grid[i];
            for(int j=0; j<N; ++j) {
                if (grid[i][j] == 'S') {
                    sr = i; sc = j;
                }
            }
        }
        
        std::queue<State> q;
        q.push({sr, sc, 0, 0});
        
        std::vector<std::vector<std::vector<bool>>> visited(M, 
            std::vector<std::vector<bool>>(N, 
            std::vector<bool>(1024, false)));
            
        visited[sr][sc][0] = true;
        
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        
        while(!q.empty()) {
            State curr = q.front();
            q.pop();
            
            if (grid[curr.r][curr.c] == 'T') {
                std::cout << curr.dist << std::endl;
                return 0;
            }
            
            for(int i=0; i<4; ++i) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                    char cell = grid[nr][nc];
                    if (cell == '#') continue;
                    
                    int nkeys = curr.keys;
                    
                    if (islower(cell)) {
                        nkeys |= (1 << (cell - 'a'));
                    }
                    
                    if (isupper(cell)) {
                        if (!(nkeys & (1 << (cell - 'A')))) {
                            continue;
                        }
                    }
                    
                    if (!visited[nr][nc][nkeys]) {
                        visited[nr][nc][nkeys] = true;
                        q.push({nr, nc, nkeys, curr.dist + 1});
                    }
                }
            }
        }
        
        std::cout << "-1" << std::endl;
    }
    return 0;
}
