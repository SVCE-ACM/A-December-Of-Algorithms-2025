def solve(board):
    rows = [set() for _ in range(9)]
    cols = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]
    empty = []

    for i in range(9):
        for j in range(9):
            if board[i][j] == '.':
                empty.append((i, j))
            else:
                rows[i].add(board[i][j])
                cols[j].add(board[i][j])
                boxes[(i // 3) * 3 + j // 3].add(board[i][j])

    def backtrack(idx):
        if idx == len(empty):
            return True
        i, j = empty[idx]
        b = (i // 3) * 3 + j // 3
        for c in '123456789':
            if c not in rows[i] and c not in cols[j] and c not in boxes[b]:
                board[i][j] = c
                rows[i].add(c)
                cols[j].add(c)
                boxes[b].add(c)
                if backtrack(idx + 1):
                    return True
                board[i][j] = '.'
                rows[i].remove(c)
                cols[j].remove(c)
                boxes[b].remove(c)
        return False

    backtrack(0)

board = [input().split() for _ in range(9)]
solve(board)
for row in board:
    print(' '.join(row))
