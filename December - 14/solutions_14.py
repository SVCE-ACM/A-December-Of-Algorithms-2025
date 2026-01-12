def parse_chest(s: str):
    if not s.startswith('['):
        return int(s)

    stack = []
    num = 0
    negative = False

    for ch in s:
        if ch == '[':
            stack.append([])
        elif ch == '-':
            negative = True
        elif ch.isdigit():
            num = num * 10 + int(ch)
        elif ch == ',' or ch == ']':
            if num != 0 or negative:
                stack[-1].append(-num if negative else num)
                num = 0
                negative = False
            if ch == ']' and len(stack) > 1:
                last = stack.pop()
                stack[-1].append(last)

    return stack[0]
