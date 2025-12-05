program sudoku_solver;

function is_valid(board: [[u32; 9]; 9], row: u32, col: u32, num: u32) -> bool {
    let mut i: u32 = 0u32;
    while i < 9u32 {
        if board[row][i] == num {
            return false;
        }
        i = i + 1u32;
    }

    let mut j: u32 = 0u32;
    while j < 9u32 {
        if board[j][col] == num {
            return false;
        }
        j = j + 1u32;
    }

    let box_row: u32 = (row / 3u32) * 3u32;
    let box_col: u32 = (col / 3u32) * 3u32;
    let mut br: u32 = 0u32;
    while br < 3u32 {
        let mut bc: u32 = 0u32;
        while bc < 3u32 {
            if board[box_row + br][box_col + bc] == num {
                return false;
            }
            bc = bc + 1u32;
        }
        br = br + 1u32;
    }

    return true;
}

function solve_helper(board: [[u32; 9]; 9], pos: u32) -> (bool, [[u32; 9]; 9]) {
    if pos == 81u32 {
        return (true, board);
    }

    let row: u32 = pos / 9u32;
    let col: u32 = pos % 9u32;

    if board[row][col] != 0u32 {
        return solve_helper(board, pos + 1u32);
    }

    let mut num: u32 = 1u32;
    while num <= 9u32 {
        if is_valid(board, row, col, num) {
            let mut new_board: [[u32; 9]; 9] = board;
            new_board[row][col] = num;
            
            let result: (bool, [[u32; 9]; 9]) = solve_helper(new_board, pos + 1u32);
            if result.0 {
                return result;
            }
        }
        num = num + 1u32;
    }

    return (false, board);
}

function main(board: [[u32; 9]; 9]) -> [[u32; 9]; 9] {
    let result: (bool, [[u32; 9]; 9]) = solve_helper(board, 0u32);
    return result.1;
}
