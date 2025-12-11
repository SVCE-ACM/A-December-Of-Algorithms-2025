def parse_chest(s: str):

    if not s.startswith('['):
        return int(s)
    
    stack = []
    num = ''
    current = []
    
    for ch in s:
        if ch == '[':
            stack.append(current)
            current = []
        elif ch == ']':
            if num:
                current.append(int(num))
                num = ''
            last = stack.pop()
            last.append(current)
            current = last
        elif ch == ',':
            if num:
                current.append(int(num))
                num = ''
        else:  # digit or '-'
            num += ch
    
    return current[0]


if __name__ == "__main__":
    s = input().strip()          
    result = parse_chest(s)      
    print(result)                