s = input().strip()

def parse_nested_chest(s):
    if not s.startswith('['):
        return int(s)
    
    stack = []
    num = ''
    for ch in s:
        if ch == '[':
            stack.append([])
        elif ch == ']':
            if num:
                stack[-1].append(int(num))
                num = ''
            last = stack.pop()
            if stack:
                stack[-1].append(last)
            else:
                return last
        elif ch == ',':
            if num:
                stack[-1].append(int(num))
                num = ''
        else:  
            num += ch


result = parse_nested_chest(s)
print(result)
