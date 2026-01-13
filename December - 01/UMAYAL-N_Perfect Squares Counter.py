import math
n=int(input())
l=[i for i in range(1,n+1) if math.isqrt(i)**2==i ]
print(" ".join(map(str,l)))
print(len(l))
