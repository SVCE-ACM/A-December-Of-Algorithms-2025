from collections import deque

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def burn_tree(root, target):
    if not root:
        return
    
    
    parent_map = {}
    def dfs(node, parent):
        if not node:
            return
        parent_map[node] = parent
        dfs(node.left, node)
        dfs(node.right, node)
    dfs(root, None)
    
    
    def find_target(node):
        if not node:
            return None
        if node.val == target:
            return node
        return find_target(node.left) or find_target(node.right)
    
    target_node = find_target(root)
    if not target_node:
        print("Target node not found.")
        return
    
    # Step 3: BFS to simulate fire
    queue = deque([target_node])
    visited = set([target_node])
    
    while queue:
        size = len(queue)
        burning_nodes = []
        for _ in range(size):
            node = queue.popleft()
            burning_nodes.append(node.val)
            
            for neighbor in (node.left, node.right, parent_map[node]):
                if neighbor and neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        
        print(', '.join(map(str, burning_nodes)))


root = TreeNode(14)
root.left = TreeNode(21)
root.right = TreeNode(24)
root.left.left = TreeNode(15)
root.left.right = TreeNode(12)
root.right.right = TreeNode(10)
root.left.left.left = TreeNode(22)
root.left.left.right = TreeNode(23)
root.left.right.right = TreeNode(13)

# Target node
target = 14


burn_tree(root, target)
