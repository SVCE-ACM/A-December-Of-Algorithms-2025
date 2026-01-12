from collections import deque
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
def burn_tree(root, target):
    parent = {}
    def dfs(node, par=None):
        if not node:
            return
        if par:
            parent[node] = par
        dfs(node.left, node)
        dfs(node.right, node)
    dfs(root)
    def find_target(node, target_val):
        if not node:
            return None
        if node.val == target_val:
            return node
        left = find_target(node.left, target_val)
        if left:
            return left
        return find_target(node.right, target_val)
    
    target_node = find_target(root, target)
    if not target_node:
        print("Target not found in tree.")
        return
    visited = set()
    queue = deque([target_node])
    visited.add(target_node)
    
    while queue:
        level_size = len(queue)
        current_level = []
        for _ in range(level_size):
            node = queue.popleft()
            current_level.append(node.val)
            for neighbor in (node.left, node.right, parent.get(node)):
                if neighbor and neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        print(', '.join(map(str, current_level)))
# Build a sample tree
root = TreeNode(14)
root.left = TreeNode(21)
root.right = TreeNode(10)
root.left.left = TreeNode(15)
root.left.right = TreeNode(24)
root.right.left = TreeNode(12)
root.left.right.left = TreeNode(22)
root.left.right.right = TreeNode(23)
root.right.left.left = TreeNode(13)
target = int(input("Enter the target node: "))
burn_tree(root, target)
