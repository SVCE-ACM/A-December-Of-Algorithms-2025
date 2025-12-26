class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def is_complete_binary_tree(root):
    if not root:
        return True
    
    queue = [root]
    found_null = False
    
    while queue:
        node = queue.pop(0)
        
        if node is None:
            found_null = True
        else:
            if found_null:
                return False
            queue.append(node.left)
            queue.append(node.right)
    
    return True

def build_tree(values):
    if not values or values[0] is None:
        return None
    
    root = TreeNode(values[0])
    queue = [root]
    i = 1
    
    while queue and i < len(values):
        node = queue.pop(0)
        
        if i < len(values) and values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        
        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    
    return root

input_str = input("root = ").strip()
values_str = input_str.strip("[]").split(",")
values = []
for v in values_str:
    v = v.strip()
    if v == "null":
        values.append(None)
    else:
        values.append(int(v))

root = build_tree(values)
result = is_complete_binary_tree(root)
print(str(result).lower())