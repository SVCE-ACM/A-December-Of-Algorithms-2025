g = [input().split() for _ in range(9)]

def ok(r, c, v):
    for k in range(9):
        if g[r][k] == v or g[k][c] == v:
            return False
    br = (r//3)*3
    bc = (c//3)*3
    for i in range(br, br+3):
        for j in range(bc, bc+3):
            if g[i][j] == v:
                return False
    return True

def solve():
    for i in range(9):
        for j in range(9):
            if g[i][j] == '.':
                for v in map(str, range(1,10)):
                    if ok(i, j, v):
                        g[i][j] = v
                        if solve():
                            return True
                        g[i][j] = '.'
                return False
    return True

solve()

for r in g:
    print(*r)
