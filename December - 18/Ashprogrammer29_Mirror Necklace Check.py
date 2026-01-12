def mirror_necklace(N, beads):
    if N == 0:
        print("The necklace is empty.")
        return
    
    left, right = 0, N - 1
    
    while left < right:
        if beads[left] != beads[right]:
            print("The necklace is not mirrored.")
            return
        left += 1
        right -= 1
    
    print("The necklace is mirrored.")
