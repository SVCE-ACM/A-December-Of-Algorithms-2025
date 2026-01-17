n = int(input())
h = list(map(int, input().split()))
res = [-1] * n
st = []
for i, x in enumerate(h):
    while st and h[st[-1]] < x:
        res[st.pop()] = x
    st.append(i)
print(*res)
