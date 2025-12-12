
from collections import Counter
arr=[1,2,3,2,4,4]
frequency=Counter(arr)
sum_u = 0
for key,value in frequency.items():
   if value==1:
     sum_u +=key
print("sum of unique elements are:",sum_u)
   
sum of unique elements are: 4