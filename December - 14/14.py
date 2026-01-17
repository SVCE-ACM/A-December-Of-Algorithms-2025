def parse_treasure_chest(s):
    if s.isdigit():
        return int(s)
    stack = []
    num = ""
    current = []
    for char in s:
        if char.isdigit():
            num += char
        elif char == ",":
            if num:
                current.append(int(num))
                num = ""
        elif char == "[":
            stack.append(current)
            current = []
        elif char == "]":
            if num:
                current.append(int(num))
                num = ""
            last = stack.pop()
            last.append(current)
            current = last
    if num:
        return int(num)
    
    return current[0] if current else current
s = input()
print(parse_treasure_chest(s))
