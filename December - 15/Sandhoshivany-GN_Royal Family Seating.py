from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def buildTree(values):
    if not values or values[0] is None:
        return None
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    while queue and i < len(values):
        current = queue.popleft()
        if i < len(values) and values[i] is not None:
            current.left = TreeNode(values[i])
            queue.append(current.left)
        i += 1
        if i < len(values) and values[i] is not None:
            current.right = TreeNode(values[i])
            queue.append(current.right)
        i += 1
    return root

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

if __name__ == "__main__":
    raw_input_str = input().strip()
    raw_input_str = raw_input_str.replace("null", "None")
    values = eval(raw_input_str)
    root = buildTree(values)
    result = isCompleteTree(root)
    print(str(result).lower())
