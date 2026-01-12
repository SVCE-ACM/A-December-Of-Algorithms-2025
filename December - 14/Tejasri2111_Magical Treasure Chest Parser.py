s = input().strip()

# Remove surrounding quotes if present
if (s[0] == '"' and s[-1] == '"') or (s[0] == "'" and s[-1] == "'"):
    s = s[1:-1]

# If it's a single number
if s[0] != '[':
    print(int(s))
else:
    stack = []
    num = ''
    curr = []

    for ch in s:
        if ch == '[':
            stack.append(curr)
            curr = []
        elif ch == ']':
            if num:
                curr.append(int(num))
                num = ''
            prev = stack.pop()
            prev.append(curr)
            curr = prev
        elif ch == ',':
            if num:
                curr.append(int(num))
                num = ''
        else:  # digit or '-'
            num += ch

    print(curr[0])
