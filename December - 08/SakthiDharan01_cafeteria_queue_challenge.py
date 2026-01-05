import sys
import re

def parse(line: str):
    return list(map(int, re.findall(r"-?\d+", line)))

def solve():
    lines = sys.stdin.read().strip().splitlines()
    if len(lines) < 2:
        return
    students = parse(lines[0])
    sandwiches = parse(lines[1])
    from collections import Counter
    pref = Counter(students)
    for s in sandwiches:
        if pref[s] == 0:
            break
        pref[s] -= 1
    remaining = pref[0] + pref[1]
    print(remaining)

if __name__ == "__main__":
    solve()
