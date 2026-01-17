import sys

def generate_magic_square(n: int):
    magic = [[0]*n for _ in range(n)]
    i, j = 0, n // 2
    for num in range(1, n*n + 1):
        magic[i][j] = num
        ni, nj = (i - 1) % n, (j + 1) % n
        if magic[ni][nj] != 0:
            i = (i + 1) % n
        else:
            i, j = ni, nj
    return magic

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    if n % 2 == 0:
        print("Magic square is only possible for odd values of n.")
        return
    M = n * (n * n + 1) // 2
    square = generate_magic_square(n)
    print(f"Magic constant: {M}")
    for row in square:
        print(" ".join(str(x) for x in row))

if __name__ == "__main__":
    solve()
