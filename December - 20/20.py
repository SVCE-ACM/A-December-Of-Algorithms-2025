def next_taller_towers(heights):
    n = len(heights)
    result = [-1] * n
    stack = [] 
    for i in range(n-1, -1, -1):
        while stack and heights[stack[-1]] <= heights[i]:
            stack.pop()
        if stack:
            result[i] = heights[stack[-1]]
        stack.append(i)
    
    return result

if __name__ == "__main__":
    N = int(input())
    heights = list(map(int, input().split()))
    result = next_taller_towers(heights)
    print(" ".join(map(str, result)))
