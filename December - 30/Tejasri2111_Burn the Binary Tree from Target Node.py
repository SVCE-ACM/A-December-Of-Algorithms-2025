from collections import deque

# Node definition
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# helper to build tree from input (level order)
def build_tree():
    vals = input("Enter tree nodes in level order (use 'N' for null): ").split()
    if not vals or vals[0] == 'N':
        return None
    root = Node(int(vals[0]))
    q = deque([root])
    i = 1
    while q and i < len(vals):
        node = q.popleft()
        if vals[i] != 'N':
            node.left = Node(int(vals[i]))
            q.append(node.left)
        i += 1
        if i < len(vals) and vals[i] != 'N':
            node.right = Node(int(vals[i]))
            q.append(node.right)
        i += 1
    return root

# build parent map
def build_parent_map(root):
    parent_map = {}
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent_map[node.left] = node
            q.append(node.left)
        if node.right:
            parent_map[node.right] = node
            q.append(node.right)
    return parent_map

# find node by value
def find_node(root, target_val):
    if not root:
        return None
    if root.val == target_val:
        return root
    left = find_node(root.left, target_val)
    if left:
        return left
    return find_node(root.right, target_val)

# BFS fire spreading
def burn_tree(root, target_val):
    parent_map = build_parent_map(root)
    target = find_node(root, target_val)
    if not target:
        print("Target not found in tree")
        return

    visited = set()
    q = deque([target])
    visited.add(target)
    while q:
        size = len(q)
        step_nodes = []
        for _ in range(size):
            node = q.popleft()
            step_nodes.append(node.val)
            for nei in [node.left, node.right, parent_map.get(node)]:
                if nei and nei not in visited:
                    visited.add(nei)
                    q.append(nei)
        print(*step_nodes)

# main
root = build_tree()
target_val = int(input("Enter target node: "))
burn_tree(root, target_val)

