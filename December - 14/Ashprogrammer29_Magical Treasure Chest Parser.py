def parse_chest(s: str):
    if s[0] != '[':
        return int(s)

    stack = []
    num = None
    sign = 1

    for ch in s:
        if ch == '[':
            stack.append([])
        
        elif ch == '-':
            sign = -1
        
        elif ch.isdigit():
            if num is None:
                num = int(ch)
            else:
                num = num * 10 + int(ch)

        elif ch == ',' or ch == ']':
            if num is not None:
                stack[-1].append(sign * num)
            num = None
            sign = 1

            if ch == ']' and len(stack) > 1:
                last = stack.pop()
                stack[-1].append(last)

    return stack[0]

s = input().strip()
result = parse_chest(s)
print(result)
