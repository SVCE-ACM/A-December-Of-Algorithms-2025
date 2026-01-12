def isCompleteTree(root):
    if not root:
        return True
    
    queue = [root]
    i = 0
    
    while i < len(queue):
        node = queue[i]
        i += 1
        
        if node:
            queue.append(node['left'])
            queue.append(node['right'])
    
    while queue and queue[-1] is None:
        queue.pop()
    
    return len(queue) == i


def build_tree_from_list(values):
    if not values:
        return None
    
    nodes = [{'val': v, 'left': None, 'right': None} if v is not None else None for v in values]
    queue = [nodes[0]]
    i = 1
    
    for node in queue:
        if node and i < len(nodes):
            node['left'] = nodes[i]
            if nodes[i]:
                queue.append(nodes[i])
            i += 1
        
        if node and i < len(nodes):
            node['right'] = nodes[i]
            if nodes[i]:
                queue.append(nodes[i])
            i += 1
    
    return nodes[0]
