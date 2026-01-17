import sys

ROWS = COLS = 9

def solve_sudoku(board):
    rows = [set() for _ in range(ROWS)]
    cols = [set() for _ in range(COLS)]
    boxes = [set() for _ in range(9)]
    empties = []
    for i in range(ROWS):
        for j in range(COLS):
            ch = board[i][j]
            if ch == '.':
                empties.append((i, j))
            else:
                rows[i].add(ch)
                cols[j].add(ch)
                boxes[(i // 3) * 3 + j // 3].add(ch)

    def backtrack(idx=0):
        if idx == len(empties):
            return True
        i, j = empties[idx]
        b = (i // 3) * 3 + j // 3
        for d in '123456789':
            if d not in rows[i] and d not in cols[j] and d not in boxes[b]:
                board[i][j] = d
                rows[i].add(d)
                cols[j].add(d)
                boxes[b].add(d)
                if backtrack(idx + 1):
                    return True
                rows[i].remove(d)
                cols[j].remove(d)
                boxes[b].remove(d)
                board[i][j] = '.'
        return False

    backtrack()


def solve():
    data = sys.stdin.read().strip().split()
    if len(data) != ROWS * COLS:
        return
    board = [data[i * COLS:(i + 1) * COLS] for i in range(ROWS)]
    solve_sudoku(board)
    for row in board:
        print(' '.join(row))

if __name__ == "__main__":
    solve()
