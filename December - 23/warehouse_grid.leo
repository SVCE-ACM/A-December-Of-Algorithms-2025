program warehouse_grid;

struct Cell {
    row: u32,
    col: u32,
    dist: u32,
}

function main(grid: [[u32; 1000]; 1000], m: u32, n: u32) -> u32 {
    if grid[0u32][0u32] == 1u32 || grid[m - 1u32][n - 1u32] == 1u32 {
        return 999999u32;
    }

    if m == 1u32 && n == 1u32 {
        return 0u32;
    }

    let mut visited: [[bool; 1000]; 1000] = [[false; 1000]; 1000];
    let mut queue: [Cell; 1000000] = [Cell { row: 0u32, col: 0u32, dist: 0u32 }; 1000000];
    let mut front: u32 = 0u32;
    let mut rear: u32 = 1u32;
    
    queue[0u32] = Cell { row: 0u32, col: 0u32, dist: 0u32 };
    visited[0u32][0u32] = true;

    while front < rear {
        let curr: Cell = queue[front];
        front = front + 1u32;

        if curr.row == m - 1u32 && curr.col == n - 1u32 {
            return curr.dist;
        }

        let dx: [u32; 4] = [0u32, 0u32, 1u32, 999999u32];
        let dy: [u32; 4] = [1u32, 999999u32, 0u32, 0u32];

        let mut i: u32 = 0u32;
        while i < 4u32 {
            let new_row: u32 = curr.row + dx[i];
            let new_col: u32 = curr.col + dy[i];

            if new_row < m && new_col < n && grid[new_row][new_col] == 0u32 && !visited[new_row][new_col] {
                visited[new_row][new_col] = true;
                queue[rear] = Cell { row: new_row, col: new_col, dist: curr.dist + 1u32 };
                rear = rear + 1u32;
            }
            i = i + 1u32;
        }
    }

    return 999999u32;
}
