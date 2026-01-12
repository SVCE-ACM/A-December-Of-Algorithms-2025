def parse_treasure_chest(s):
    if s[0] != '[':
        return int(s)
    stack = []
    num = ""
    for ch in s:
        if ch == '[':
            stack.append([])
        elif ch == ',':
            if num:
                stack[-1].append(int(num))
                num = ""
        elif ch == ']':
            if num:
                stack[-1].append(int(num))
                num = ""
            last = stack.pop()
            if stack:
                stack[-1].append(last)
            else:
                return last
        else:
            num += ch  
s = input("Enter the serialized treasure chest: ").strip()
if s.startswith('"') and s.endswith('"'):
    s = s[1:-1]
result = parse_treasure_chest(s)
print("Parsed Chest:", result)
