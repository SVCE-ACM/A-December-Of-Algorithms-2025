target = int(input())
n = int(input())
if n == 0:
    print("No turtle fleets formed.")
else:
    position = list(map(int, input().split()))
    speed = list(map(int, input().split()))
    turtles = [(pos, (target - pos) / spd) for pos, spd in zip(position, speed)]
    turtles.sort(reverse=True)
    fleets = []
    for pos, time in turtles:
        if not fleets or time > fleets[-1]:
            fleets.append(time)
    print(f"The number of turtle fleets is: {len(fleets)}")
