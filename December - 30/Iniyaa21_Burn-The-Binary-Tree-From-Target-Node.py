from collections import deque

class Node:
    def __init__(self, x):
        self.data = x
        self.left = None
        self.right = None

def markParents(root, parent, target):
    q = deque([root])
    targetNode = None
    while q:
        curr = q.popleft()
        if curr.data == target:
            targetNode = curr
        if curr.left:
            parent[curr.left] = curr
            q.append(curr.left)
        if curr.right:
            parent[curr.right] = curr
            q.append(curr.right)
    return targetNode

def burnTree(root, target):
    if not root:
        return
    parent = {}
    targetNode = markParents(root, parent, target)
    if not targetNode:
        return
    visited = {targetNode: True}
    q = deque([targetNode])
    while q:
        sz = len(q)
        level = []
        for _ in range(sz):
            curr = q.popleft()
            level.append(curr.data)
            for neighbor in [curr.left, curr.right, parent.get(curr)]:
                if neighbor and neighbor not in visited:
                    visited[neighbor] = True
                    q.append(neighbor)
        print(", ".join(map(str, level)))

def build_sample_1():
    root = Node(10)
    root.left = Node(14)
    root.right = Node(12)
    root.left.left = Node(21)
    root.left.right = Node(24)
    root.right.left = Node(15)
    root.right.right = Node(13)
    root.left.left.left = Node(22)
    root.left.left.right = Node(23)
    return root

def build_sample_2():
    root = Node(2)
    root.left = Node(41)
    root.right = Node(19)
    root.left.left = Node(12)
    root.left.left.right = Node(82)
    root.left.left.right.left = Node(15)
    root.left.left.right.right = Node(95)
    root.left.left.right.left.left = Node(21)
    root.left.left.right.left.right = Node(7)
    root.left.left.right.right.right = Node(16)
    return root

burnTree(build_sample_1(), 14)

burnTree(build_sample_2(), 41)