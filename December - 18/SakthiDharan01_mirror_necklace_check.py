import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    beads = list(map(int, data[1:1+n]))
    if n == 0:
        print("The necklace is empty.")
        return
    if beads == beads[::-1]:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")

if __name__ == "__main__":
    solve()
