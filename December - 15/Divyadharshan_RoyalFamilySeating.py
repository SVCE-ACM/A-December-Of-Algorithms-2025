from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCompleteTree(self, root):
        if not root:
            return True
        queue = deque([root])
        end = False
        while queue:
            node = queue.popleft()
            if node is None:
                end = True
            else:
                if end:
                    return False
                queue.append(node.left)
                queue.append(node.right)
        return True