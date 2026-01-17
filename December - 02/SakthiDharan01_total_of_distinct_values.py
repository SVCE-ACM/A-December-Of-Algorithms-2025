import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    width = len(bin(n)) - 2
    for i in range(1, n + 1):
        dec_str = format(i, "d").rjust(width)
        oct_str = format(i, "o").rjust(width)
        hex_str = format(i, "X").rjust(width)
        bin_str = format(i, "b").rjust(width)
        print(dec_str, oct_str, hex_str, bin_str)

if __name__ == "__main__":
    solve()
