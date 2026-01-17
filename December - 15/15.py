from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
def isCompleteTree(root):
    if not root:
        return True
    
    queue = deque([root])
    end = False
    
    while queue:
        node = queue.popleft()
        if node:
            if end:
                return False
            queue.append(node.left)
            queue.append(node.right)
        else:
            end = True
    return True
def build_tree(values):
    if not values or values[0] == "null":
        return None
    
    root = TreeNode(int(values[0]))
    queue = deque([root])
    i = 1
    
    while queue and i < len(values):
        node = queue.popleft()
        if i < len(values) and values[i] != "null":
            node.left = TreeNode(int(values[i]))
            queue.append(node.left)
        i += 1

        if i < len(values) and values[i] != "null":
            node.right = TreeNode(int(values[i]))
            queue.append(node.right)
        i += 1
    
    return root
if __name__ == "__main__":
    values = input().split()
    root = build_tree(values)
    result = isCompleteTree(root)
    print("true" if result else "false")
