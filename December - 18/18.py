def check_necklace_palindrome(n, beads):
    if n == 0:
        return "The necklace is empty."
    if beads == beads[::-1]:
        return "The necklace is mirrored."
    else:
        return "The necklace is not mirrored."
if __name__ == "__main__":
    n = int(input("n: "))
    if n > 0:
        beads = list(map(int, input("beads: ").split()))
    else:
        beads = []
    result = check_necklace_palindrome(n, beads)
    print(result)
