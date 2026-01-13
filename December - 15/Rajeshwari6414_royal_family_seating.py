from collections import deque

def is_complete_tree(tree):
    queue = deque()
    queue.append(0)
    end = False

    while queue:
        i = queue.popleft()
        if i >= len(tree) or tree[i] is None:
            end = True
        else:
            if end:
                return False
            queue.append(2 * i + 1)
            queue.append(2 * i + 2)
    return True


tree = eval(input())
print(is_complete_tree(tree))
