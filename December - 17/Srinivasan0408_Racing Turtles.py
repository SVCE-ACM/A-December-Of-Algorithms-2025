target = int(input("target = ").strip())
n = int(input("n = ").strip())
pos = input("position = ").strip()
spd = input("speed = ").strip()
pos = pos[1:-1]   
spd = spd[1:-1]
if pos=="":
    print("The number of turtle fleets is: 0")
    exit()
positions = list(map(int, pos.split(',')))
speeds    = list(map(int, spd.split(',')))
pairs = []
for i in range(n):
    pairs.append([positions[i], speeds[i]])
pairs.sort(reverse=True)
fleets = 0
curr_time = 0
for p,s in pairs:
    t = (target-p)/s
    if t > curr_time:
        fleets += 1
        curr_time = t
print("The number of turtle fleets is:", fleets)