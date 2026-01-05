import sys

def solve():
    tokens = sys.stdin.read().strip().split()
    if not tokens:
        return
    stack = []
    for op in tokens:
        if op == "C":
            if stack:
                stack.pop()
        elif op == "D":
            if stack:
                stack.append(stack[-1]*2)
        elif op == "+":
            if len(stack) >= 2:
                stack.append(stack[-1] + stack[-2])
        else:
            stack.append(int(op))
    print(sum(stack))

if __name__ == "__main__":
    solve()
