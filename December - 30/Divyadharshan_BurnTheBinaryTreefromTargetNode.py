from collections import defaultdict, deque

def burnTree(root, target):
    graph = defaultdict(list)
    def build(node, parent=None):
        if not node:
            return
        if parent:
            graph[node.val].append(parent.val)
            graph[parent.val].append(node.val)
        build(node.left, node)
        build(node.right, node)
    build(root)
    q = deque([target])
    visited = {target}
    while q:
        level = list(q)
        print(", ".join(map(str, level)))
        for _ in range(len(q)):
            cur = q.popleft()
            for nei in graph[cur]:
                if nei not in visited:
                    visited.add(nei)
                    q.append(nei)
