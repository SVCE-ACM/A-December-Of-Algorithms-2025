def build_parent_map(root, parent_map):
    if not root:
        return
    
    q = [root]
    
    while q:
        node = q.pop(0)
        
        if node['left']:
            parent_map[node['left']['val']] = node
            q.append(node['left'])
        
        if node['right']:
            parent_map[node['right']['val']] = node
            q.append(node['right'])

def find_node(root, target):
    if not root:
        return None
    
    q = [root]
    
    while q:
        node = q.pop(0)
        
        if node['val'] == target:
            return node
        
        if node['left']:
            q.append(node['left'])
        if node['right']:
            q.append(node['right'])
    
    return None

def burn_tree(root, target):
    parent_map = {}
    build_parent_map(root, parent_map)
    
    start = find_node(root, target)
    
    if not start:
        return
    
    q = [start]
    burned = {start['val']}
    
    while q:
        level_size = len(q)
        current_level = []
        
        for _ in range(level_size):
            node = q.pop(0)
            current_level.append(node['val'])
            
            if node['left'] and node['left']['val'] not in burned:
                burned.add(node['left']['val'])
                q.append(node['left'])
            
            if node['right'] and node['right']['val'] not in burned:
                burned.add(node['right']['val'])
                q.append(node['right'])
            
            if node['val'] in parent_map:
                p = parent_map[node['val']]
                if p['val'] not in burned:
                    burned.add(p['val'])
                    q.append(p)
        
        print(', '.join(map(str, current_level)))

def build_tree_from_input():
    n = int(input("Enter number of nodes: "))
    
    if n == 0:
        return None
    
    nodes = {}
    edges = []
    
    print("Enter parent-child relationships (parent left right, use -1 for null):")
    for _ in range(n):
        parts = input().split()
        parent_val = int(parts[0])
        left_val = int(parts[1]) if parts[1] != '-1' else None
        right_val = int(parts[2]) if parts[2] != '-1' else None
        
        if parent_val not in nodes:
            nodes[parent_val] = {'val': parent_val, 'left': None, 'right': None}
        
        if left_val is not None:
            if left_val not in nodes:
                nodes[left_val] = {'val': left_val, 'left': None, 'right': None}
            nodes[parent_val]['left'] = nodes[left_val]
        
        if right_val is not None:
            if right_val not in nodes:
                nodes[right_val] = {'val': right_val, 'left': None, 'right': None}
            nodes[parent_val]['right'] = nodes[right_val]
        
        edges.append((parent_val, left_val, right_val))
    
    root_val = int(input("Enter root node value: "))
    return nodes[root_val]

root = build_tree_from_input()
target = int(input("Enter target node: "))
burn_tree(root, target)
