# Racing Turtles – Correct Implementation

target = int(input().strip())
n = int(input().strip())

if n == 0:
    print("No turtle fleets formed.")
else:
    position = list(map(int, input().split()))
    speed = list(map(int, input().split()))

    # Pair positions with speeds and sort by position DESCENDING
    turtles = sorted(zip(position, speed), reverse=True)

    fleets = 0
    slowest_time = 0

    # Calculate time to reach target for each turtle
    for p, s in turtles:
        time = (target - p) / s

        # If this turtle takes longer, it forms a new fleet
        if time > slowest_time:
            fleets += 1
            slowest_time = time

    print(f"The number of turtle fleets is: {fleets}")

