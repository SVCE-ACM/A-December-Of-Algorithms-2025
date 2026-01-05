import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    it = iter(data)
    target = int(next(it))
    n = int(next(it))
    positions = [int(next(it)) for _ in range(n)]
    speeds = [int(next(it)) for _ in range(n)]
    if n == 0:
        print("No turtle fleets formed.")
        return
    turtles = sorted(zip(positions, speeds), reverse=True)
    fleets = 0
    slow_time = -1.0
    for pos, speed in turtles:
        time = (target - pos) / speed
        if time > slow_time:
            fleets += 1
            slow_time = time
    print(f"The number of turtle fleets is: {fleets}")

if __name__ == "__main__":
    solve()
