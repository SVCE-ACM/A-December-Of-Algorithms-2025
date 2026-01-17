import sys
from collections import Counter

def solve():
    s = sys.stdin.read().strip()
    if not s:
        return
    freq = Counter(s)
    for ch in s:
        if freq[ch] == 1:
            print(f"The first non-repeating character is: {ch}")
            return
    print("No non-repeating character found.")

if __name__ == "__main__":
    solve()
