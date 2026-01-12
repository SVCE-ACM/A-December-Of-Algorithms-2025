def parse(s):
    s = s.strip().strip('"')
    
    if not s.startswith('['):
        return int(s)
    
    result = []
    stack = [result]
    num = ""
    
    for char in s:
        if char == '[':
            new_list = []
            stack[-1].append(new_list)
            stack.append(new_list)
        elif char == ']':
            if num:
                stack[-1].append(int(num))
                num = ""
            stack.pop()
        elif char == ',':
            if num:
                stack[-1].append(int(num))
                num = ""
        else:
            num += char
    
    return result[0] if len(result) == 1 else result

s = input().strip()
result = parse(s)
print(str(result).replace(' ', ''))