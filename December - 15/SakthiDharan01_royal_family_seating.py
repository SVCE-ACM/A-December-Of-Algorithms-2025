import sys
from collections import deque

def build_tree(values):
    if not values:
        return None
    nodes = [None if v is None else [v, None, None] for v in values]
    kids = deque(nodes[1:])
    for node in nodes:
        if node is not None:
            if kids:
                node[1] = kids.popleft()
            if kids:
                node[2] = kids.popleft()
    return nodes[0]

def is_complete(root):
    if not root:
        return True
    q = deque([root])
    end = False
    while q:
        node = q.popleft()
        if node is None:
            end = True
        else:
            if end:
                return False
            q.append(node[1])
            q.append(node[2])
    return True

def parse_line(line):
    vals = []
    for tok in line.replace(',', ' ').split():
        if tok.lower() == 'null':
            vals.append(None)
        else:
            vals.append(int(tok))
    return vals

def solve():
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return
    values = parse_line(' '.join(data))
    root = build_tree(values)
    print(str(is_complete(root)).lower())

if __name__ == "__main__":
    solve()
