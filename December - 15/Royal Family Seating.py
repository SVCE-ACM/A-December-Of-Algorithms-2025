from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isCompleteTree(root):
    if not root:
        return True

    queue = deque([(root, 1)])  # (node, index)
    count = 0
    max_index = 0

    while queue:
        node, idx = queue.popleft()
        count += 1
        max_index = idx

        if node.left:
            queue.append((node.left, 2 * idx))
        if node.right:
            queue.append((node.right, 2 * idx + 1))

    return count == max_index


def build_tree(lst):
    if not lst:
        return None
    root = TreeNode(lst[0])
    queue = deque([root])
    i = 1
    while queue and i < len(lst):
        node = queue.popleft()
        if lst[i] is not None:
            node.left = TreeNode(lst[i])
            queue.append(node.left)
        i += 1
        if i < len(lst) and lst[i] is not None:
            node.right = TreeNode(lst[i])
            queue.append(node.right)
        i += 1
    return root


lst = [1,2,3,4,5,None,7] 

root = build_tree(lst)
result = isCompleteTree(root)
print(result)  
