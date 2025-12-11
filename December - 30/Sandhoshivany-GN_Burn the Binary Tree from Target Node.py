from collections import deque, defaultdict

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def build_parent_map(root, parent_map):
    """Store parent of each node"""
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent_map[node.left] = node
            q.append(node.left)
        if node.right:
            parent_map[node.right] = node
            q.append(node.right)


def find_target(root, target):
    """Find target node by value"""
    if not root:
        return None
    if root.data == target:
        return root
    left = find_target(root.left, target)
    if left:
        return left
    return find_target(root.right, target)


def burn_tree(root, target):
    """Simulate fire spreading level by level"""
    if not root:
        return

    parent_map = {}
    build_parent_map(root, parent_map)
    target_node = find_target(root, target)
    if not target_node:
        print("Target not found in tree.")
        return

    visited = set()
    q = deque([target_node])
    visited.add(target_node)

    while q:
        size = len(q)
        level_nodes = []

        for _ in range(size):
            node = q.popleft()
            level_nodes.append(str(node.data))

            for neighbor in [node.left, node.right, parent_map.get(node)]:
                if neighbor and neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)

        print(", ".join(level_nodes))


root = Node(10)
root.left = Node(14)
root.right = Node(12)
root.left.left = Node(21)
root.left.right = Node(24)
root.right.left = Node(15)
root.right.right = Node(13)
root.left.right.left = Node(22)
root.left.right.right = Node(23)

target_node = 14
burn_tree(root, target_node)
