class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

def build_tree_from_input():
    input_str = input("Binary Tree : ").strip() #12 13 10 N N 14 15 21 24 22 23
    # N = 'null'
    if not input_str or input_str == 'N':
        return None   
    values = input_str.split()
    root = Node(int(values[0]))
    queue = [root]
    i = 1
    while queue and i < len(values):
        curr_node = queue.pop(0)
        if i < len(values):
            if values[i] != 'N':
                curr_node.left = Node(int(values[i]))
                queue.append(curr_node.left)
            i += 1
        if i < len(values):
            if values[i] != 'N':
                curr_node.right = Node(int(values[i]))
                queue.append(curr_node.right)
            i += 1   
    return root

def find_target_and_parents(root, target_val, parent_map):
    target_node = None
    queue = [root]
    parent_map[root] = None 
    while queue:
        curr = queue.pop(0)
        if curr.data == target_val:
            target_node = curr
        if curr.left:
            parent_map[curr.left] = curr
            queue.append(curr.left)
        if curr.right:
            parent_map[curr.right] = curr
            queue.append(curr.right)
    return target_node

def burn_tree(root, target_val):
    if not root:
        return

    parent_map = {}
    target_node = find_target_and_parents(root, target_val, parent_map)
    
    if not target_node:
        print(f"Error: Target node {target_val} was not found in the tree.")
        return
    current_level = [target_node]
    visited = {target_node}
    
    while current_level:
        line_output = []
        for node in current_level:
            line_output.append(str(node.data))
        print(", ".join(line_output))
        
        next_level = []
        for node in current_level:
            if node.left and node.left not in visited:
                visited.add(node.left)
                next_level.append(node.left)
            if node.right and node.right not in visited:
                visited.add(node.right)
                next_level.append(node.right)
            parent = parent_map.get(node)
            if parent and parent not in visited:
                visited.add(parent)
                next_level.append(parent)
        current_level = next_level
try:
    root = build_tree_from_input()

    if root:
        val_input = input("Target node = ").strip() #14
        if val_input:
            target_val = int(val_input)
            burn_tree(root, target_val)
        else:
            print("Error: You didn't enter a target number.")
    else:
        print("Tree is empty.")
except Exception as e:
    print(f"An error occurred: {e}")