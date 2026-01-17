from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def build_tree(values):
    if not values or values[0] == "null":
        return None
    
    root = TreeNode(int(values[0]))
    q = deque([root])
    i = 1
    while q and i < len(values):
        node = q.popleft()
        
        if i < len(values) and values[i] != "null":
            node.left = TreeNode(int(values[i]))
            q.append(node.left)
        i += 1
        
        if i < len(values) and values[i] != "null":
            node.right = TreeNode(int(values[i]))
            q.append(node.right)
        i += 1
    
    return root

def build_parent_map(root, parent_map):
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent_map[node.left] = node
            q.append(node.left)
        if node.right:
            parent_map[node.right] = node
            q.append(node.right)

def find_node(node, val):
    if not node:
        return None
    if node.val == val:
        return node
    return find_node(node.left, val) or find_node(node.right, val)

def burning_tree(root, target):
    if not root:
        print("Empty tree.")
        return
    
    parent_map = {}
    build_parent_map(root, parent_map)
    
    target_node = find_node(root, target)
    if not target_node:
        print("Target node not found.")
        return
    
    q = deque([target_node])
    visited = set([target_node])
    
    while q:
        size = len(q)
        burning_nodes = []
        for _ in range(size):
            node = q.popleft()
            burning_nodes.append(node.val)
            if node.left and node.left not in visited:
                visited.add(node.left)
                q.append(node.left)
            if node.right and node.right not in visited:
                visited.add(node.right)
                q.append(node.right)
            if node in parent_map and parent_map[node] not in visited:
                visited.add(parent_map[node])
                q.append(parent_map[node])
        
        print(", ".join(map(str, burning_nodes)))
if __name__ == "__main__":
    values = input("Enter tree in level-order (use 'null' for missing nodes): ").split()
    target = int(input("Enter target node: "))
    root = build_tree(values)
    burning_tree(root, target)
