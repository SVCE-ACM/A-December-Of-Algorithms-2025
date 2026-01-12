from collections import deque, defaultdict

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def map_parents(root, parent):
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent[node.left] = node
            q.append(node.left)
        if node.right:
            parent[node.right] = node
            q.append(node.right)


def find_target(root, target):
    if not root:
        return None
    if root.val == target:
        return root
    return find_target(root.left, target) or find_target(root.right, target)


def burn_tree(root, target):
    if not root:
        return []

    parent = {}
    map_parents(root, parent)

    target_node = find_target(root, target)
    if not target_node:
        return []

    q = deque([target_node])
    visited = set([target_node])
    result = []

    while q:
        size = len(q)
        level = []

        for _ in range(size):
            node = q.popleft()
            level.append(node.val)

      
            for nei in (node.left, node.right, parent.get(node)):
                if nei and nei not in visited:
                    visited.add(nei)
                    q.append(nei)

        result.append(level)

    return result


def print_burn_sequence(seq):
    for level in seq:
        print(", ".join(map(str, level)))
