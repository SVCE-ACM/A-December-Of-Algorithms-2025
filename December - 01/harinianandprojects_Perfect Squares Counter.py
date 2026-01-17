n = int(input())
m = int(n**0.5)
a = [i*i for i in range(1, m+1)]
print(" ".join(map(str, a)))
print(len(a))

