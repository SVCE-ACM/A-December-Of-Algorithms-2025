program treasure_hunt;

struct State {
    row: u32,
    col: u32,
    keys: u32,
    steps: u32,
}

function main(maze: [[u8; 30]; 30], m: u32, n: u32, start_r: u32, start_c: u32) -> u32 {
    let mut visited: [[[bool; 1024]; 30]; 30] = [[[false; 1024]; 30]; 30];
    let mut queue: [State; 100000] = [State { row: 0u32, col: 0u32, keys: 0u32, steps: 0u32 }; 100000];
    let mut front: u32 = 0u32;
    let mut rear: u32 = 1u32;
    
    queue[0u32] = State { row: start_r, col: start_c, keys: 0u32, steps: 0u32 };
    visited[start_r][start_c][0u32] = true;

    while front < rear {
        let curr: State = queue[front];
        front = front + 1u32;

        if maze[curr.row][curr.col] == 84u8 {
            return curr.steps;
        }

        let dx: [u32; 4] = [0u32, 0u32, 1u32, 999999u32];
        let dy: [u32; 4] = [1u32, 999999u32, 0u32, 0u32];

        let mut i: u32 = 0u32;
        while i < 4u32 {
            let nr: u32 = curr.row + dx[i];
            let nc: u32 = curr.col + dy[i];

            if nr < m && nc < n && maze[nr][nc] != 35u8 {
                let cell: u8 = maze[nr][nc];
                let mut new_keys: u32 = curr.keys;
                
                if cell >= 97u8 && cell <= 106u8 {
                    new_keys = curr.keys | (1u32 << (cell - 97u8));
                }

                if cell >= 65u8 && cell <= 74u8 {
                    let needed: u32 = 1u32 << (cell - 65u8);
                    if (curr.keys & needed) == 0u32 {
                        i = i + 1u32;
                        continue;
                    }
                }

                if !visited[nr][nc][new_keys] {
                    visited[nr][nc][new_keys] = true;
                    queue[rear] = State { row: nr, col: nc, keys: new_keys, steps: curr.steps + 1u32 };
                    rear = rear + 1u32;
                }
            }
            i = i + 1u32;
        }
    }

    return 999999u32;
}
