s=input().strip()
d={}
for i in s:
    if i not in d:
        d[i]=1
    else:
        d[i]+=1

for k in range(len(s)):
    if d[s[k]]==1:
        print("The first non-repeating character is:",s[k])
        exit()
print("No non-repeating character found.")