target = int(input("Enter the target position: "))
n = int(input("Enter number of turtles: "))

if n == 0:
    print("No turtle fleets formed.")
else:
    position = list(map(int, input("Enter positions: ").split()))
    speed = list(map(int, input("Enter speeds: ").split()))

    turtles = []

    for i in range(n):
        turtles.append((position[i], speed[i]))

    # sort turtles based on position (descending)
    turtles.sort(reverse=True)

    fleets = 0
    max_time = 0

    for pos, spd in turtles:
        time = (target - pos) / spd

        if time > max_time:
            fleets += 1
            max_time = time

    print("The number of turtle fleets is:", fleets)
