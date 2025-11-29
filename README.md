# A-December-of-Algorithms-2025

<div align="left">
<h1>
    <p align="center"><img alt="header" src="https://github.com/user-attachments/assets/ef5563b7-51a9-4308-8faa-c4bf59b6141e" width="500"></img></p>

</h1>
Welcome to A December of Algorithms 2025.

Building on the success and enthusiasm of previous years, we’re excited to bring you a fresh selection of algorithms to explore and implement this December!

Each Day, Each Algorithm ;)
Finish them all to get a certificate :)

**Send a pull request only after completing all 31 algorithms.**

**Please submit all PRs on or before January 1st 11:59 PM IST.**

## What Do I Do?

We have a small collection of algorithms, one for every day of the month. Scroll down to take a look at them.

All you need to do is fork this repository, implement all 31 algorithms and send a pull request over to us.

Check out our FAQ for more information.

## Index

- [**December 01 - Perfect Squares Counter**](#december-01---perfect-squares-counter)
- [**December 02 - Total of Distinct Values**](#december-02---total-of-distinct-values)
- [**December 03 - Bridge Crossing Challenge**](#december-03---bridge-crossing-challenge)
- [**December 04 - Target Subarray Finder**](#december-04---target-subarray-finder)
- [**December 05 - Island Counter**](#december-05---island-counter)
- [**December 06 - Magic Square of Odd Order**](#december-06---magic-square-of-odd-order)
- [**December 07 - Baseball Score Record Keeper**](#december-07---baseball-score-record-keeper)
- [**December 08 - Cafeteria Queue Challenge**](#december-08---cafeteria-queue-challenge)
- [**December 09 - Sum of Unique Elements**](#december-09---sum-of-unique-elements)
- [**December 11 - Counting Prime Numbers**](#december-11---counting-prime-numbers)
- [**December 12 - The Missing Positive Element**](#december-12---the-missing-positive-element)
- [**December 13 - Mountain Peaks in a Trail**](#december-13---mountain-peaks-in-a-trail)
- [**December 14 - Magical Treasure Chest Parser**](#december-14---magical-treasure-chest-parser)
- [**December 15 - Royal Family Seating**](#december-15---royal-family-seating)
- [**December 16 - Treasure Trail Adjustment**](#december-16---treasure-trail-adjustment)
- [**December 17 - Racing Turtles**](#december-17---racing-turtles)
- [**December 18 - Mirror Necklace Check**](#december-18---mirror-necklace-check)
- [**December 19 - Balanced Team Assignment**](#december-19---balanced-team-assignment)
- [**December 20 - Tower Visibility Challenge**](#december-20---tower-visibility-challenge)
- [**December 21 - Efficient Parcel Sorting**](#december-21---efficient-parcel-sorting)
- [**December 22 - AquaNet – Minimum Time to Fill All City Reservoirs**](#december-22---aquanet-–-minimum-time-to-fill-all-city-reservoirs)
- [**December 23 - Shortest Path in a Warehouse Grid**](#december-23---shortest-path-in-a-warehouse-grid)
- [**December 24 - First Non-Repeating Character in a String**](#december-24---first-non-repeating-character-in-a-string)
- [**December 25 - Treasure Hunt in the Locked Maze**](#december-25---treasure-hunt-in-the-locked-maze)
- [**December 26 - Mountain Climber – Longest Ascending Path**](#december-26---mountain-climber-–-longest-ascending-path)
- [**December 27 - Signal Propagation in a Network**](#december-27---signal-propagation-in-a-network)
- [**December 28 - Sweet Rewards for Students**](#december-28---sweet-rewards-for-students)
- [**December 29 - Minimum Weight Cycle in a Graph**](#december-29---minimum-weight-cycle-in-a-graph)
- [**December 30 - Burn the Binary Tree from Target Node**](#december-30---burn-the-binary-tree-from-target-node)
- [**December 31 - Sudoku Solver**](#december-31---sudoku-solver)
- [**FAQ**](#faq)

## Algorithms

## December 01 - Perfect Squares Counter

### Problem Statement
```

You are a mathematician exploring numbers. You are given a range of integers from 1 to N. Your task is to find all the perfect square numbers in this range and calculate their total count.
• A perfect square is an integer that can be written as the square of another integer.
• For example, 1, 4, 9, 16 are perfect squares.
```

### Input Format:
```
• A single integer N (1 ≤ N ≤ 10⁵), representing the upper bound of the range.
```
### Output Format:
```
• First, print all the perfect squares in ascending order, separated by spaces.
• Then, in the next line, print the total count of perfect squares.
```

### Sample Input 1
```
20
```

### Sample Output 1
```
1 4 9 16
4
```

### Sample Input 2
```
5
```

### Sample Output 2
```
1 4
2
```

### Explanation

```
• For N = 20, the perfect squares are 1²=1, 2²=4, 3²=9, 4²=16 → total count = 4.
• For N = 5, only 1²=1 and 2²=4 are perfect squares → total count = 2.
```

#### Constraints
```
1 ≤ N ≤ 10^5
1 ≤ array[i] ≤ N
All elements are unique
```

### Reference

- GeeksforGeeks – Perfect Squares  
  https://www.geeksforgeeks.org/check-if-a-number-is-perfect-square/

- W3Schools – Math Functions  
  https://www.w3schools.com/cpp/cpp_math.asp

- Programiz – Square Root  
  https://www.programiz.com/cpp-programming/library-function/cmath/sqrt


## December 02 - Total of Distinct Values

#### Problem Statement

```
The Data Standardization Team needs a utility to display a sequence of integers in four
different numerical bases in a clean tabular format.

You are given an integer N. For every number i from 1 to N, you must print four different
representations of i:

1. Decimal (Base 10)
2. Octal (Base 8)
3. Hexadecimal (Base 16) — letters A–F must be uppercase
4. Binary (Base 2)

The output should display all four formats in aligned columns.
```

### Example 1:

```
Input:
3

Output:
    1     1     1     1
    2     2     2    10
    3     3     3    11
```

### Example 2:

```
Input:
6

Output:
    1     1     1      1
    2     2     2     10
    3     3     3     11
    4     4     4    100
    5     5     5    101
    6     6     6    110
```

#### Constraints
```
1 ≤ N ≤ 99
```
#### Explanation

```
For every number from 1 to N, the program converts the value into:
- Octal using base-8 representation
- Hexadecimal using base-16 (A–F in uppercase)
- Binary using base-2

These converted values are then printed in four neatly aligned columns,
allowing easy comparison between different number systems.
```


#### Reference

 https://www.geeksforgeeks.org/number-system-conversions/  
 https://www.w3schools.com/python/python_numbers.asp  
 https://www.programiz.com/python-programming/examples/decimal-binary-convert  


### December 03 - Bridge Crossing Challenge

#### Problem Statement

```

You are an explorer standing at the start of a series of stepping stones across a river. Each stone is numbered from 0 to N-1. Each stone has a number written on it, which tells you the maximum number of stones you can jump forward from that stone.

Your goal is to reach the last stone.

From stone i, if the number is 3, you can jump to stone i+1, i+2, or i+3.
If the number is 0, you cannot jump forward from that stone.

You need to determine whether it is possible to reach the last stone from the first stone.

```

#### Input Format

```

An array of integers stones, where stones[i] indicates the maximum jump length from stone i.

```

#### Output Format

```

true if you can reach the last stone, otherwise false.

```

#### Sample Input 1

```

stones = [2,3,1,1,4]

```

#### Sample Output 1

```

true

```

#### Sample Input 2

```

stones = [3,2,1,0,4]

```

#### Sample Output 2

```

false

```

#### Explanation

```

Sample Input 1:
Jump 1 stone from index 0 → 1
Jump 3 stones from index 1 → 4 (last stone reached)

Sample Input 2:
No matter how you jump, you will land on index 3.
Stone 3 has 0, so you cannot move further. The last stone is unreachable.

```
#### Constraints
```
1 ≤ stones.length ≤ 10^4
0 ≤ stones[i] ≤ 10^5
```

#### Reference

 https://www.geeksforgeeks.org/jump-game/  
 https://www.programiz.com/dsa/jump-game

## December 04 - Target Subarray Finder

#### Problem Statement

```
You are given a collection of numbers and a target value. Your task is to find a contiguous segment of numbers in the collection whose sum equals the target.

- If such a segment exists, report the starting and ending indices (0-based) of any one segment.
- If no such segment exists, report -1 -1.
```

#### Input Format:
```
Two integers, N (number of elements) and K (target sum).
N space-separated integers — the elements of the array.
```

#### Output Format:
```
Two integers — the starting and ending indices of a subarray whose sum is K, or -1 -1 if no such subarray exists.
```
#### Sample Input 1:
```
7 15
1 2 3 7 5 1 2
```
#### Sample Output 1:
```
2 4
```
#### Sample Input 2:
```
5 100
10 20 30 40 50
```
#### Sample Output 2:
```
-1 -1
```

#### Explanation:
```
The subarray [3, 7, 5] (indices 2 to 4) sums to 15.
```

#### Constraints:
```
1 ≤ N ≤ 10^5
-10^9 ≤ array elements ≤ 10^9
-10^9 ≤ K ≤ 10^9
```

#### Reference

https://www.geeksforgeeks.org/find-subarray-with-given-sum/

## December 05 - Island Counter

#### Problem Statement

```
You are exploring a map represented as a 2D grid, where:
- 1 represents land
- 0 represents water

An island is a group of connected lands (horizontally or vertically). Your task is to count how many islands exist on the map.
```

#### Input Format:
```
Two integers R (rows) and C (columns).
Next R lines: each line contains C integers (0 or 1) representing the map.
```

#### Output Format:
```
A single integer — the number of islands in the grid.
```


#### Sample Input 1:
```
4 5
1 1 0 0 0
1 1 0 0 1
0 0 0 1 1
0 0 0 0 0
```
#### Sample Output 1:
```
2
```
#### Sample Input 2:
```
3 3
1 0 1
0 1 0
1 0 1
```

#### Sample Output 2:

```
5
```
#### Explanation:
```
Each connected group of 1's horizontally or vertically counts as an island.
```
#### Constraints:
```
1 ≤ R, C ≤ 300
Each cell is either 0 or 1
```

#### Reference

 https://www.geeksforgeeks.org/find-number-of-islands/

## December 06 - Magic Square of Odd Order

#### Problem Statement

```
You are given a positive odd integer n (1, 3, 5, 7, …). Your task is to generate a magic
square of order n × n.

A magic square is a grid filled with numbers from 1 to n² such that:
- Every row,
- Every column, and
- Both main diagonals
have the same sum, known as the magic constant (M).

The magic constant for an odd-order magic square is:
M = (n(n² + 1)) / 2

If the user enters an even value for n, the program should output:
"Magic square is only possible for odd values of n."
```
### Input Format:
```
Enter the value of n (order of the magic square): An odd integer.
If n is odd, compute M and construct the magic square.
If n is even, display the error message.
```
### Output Format:
```
If n is even:
Magic square is only possible for odd values of n.

If n is odd:
Magic constant: M
<n × n magic square grid>
```
### Sample Input 1:
```
Enter n: 5
```
### Sample Output 1:
```
Magic constant: 65
9   3  22  16  15
2  21  20  14   8
25 19  13   7   1
18 12   6   5  24
11 10   4  23  17
```
### Sample Input 2:
```
Enter n: 6
```
### Sample Output 2:
```
Magic square is only possible for odd values of n.
```

### Constraints:
1 ≤ n ≤ 99
n must be odd to generate a magic square


#### Explanation

```
A magic square of odd order is constructed using the Siamese method:
- Start from the middle of the top row.
- Place numbers 1 to n², moving up-right each time.
- If the cell is occupied or goes out of bounds, move down one cell instead.
```

#### Reference

* [https://www.geeksforgeeks.org/magic-square/](https://www.geeksforgeeks.org/magic-square/)
* [https://www.programiz.com/python-programming/examples/magic-square](https://www.programiz.com/python-programming/examples/magic-square)

## December 07 - Baseball Score Record Keeper

#### Problem Statement

```
You are keeping track of scores in a baseball game using unusual rules. You begin with an
empty score record. A series of operations modify this record:

- A number x → add this score to the record.
- "+" → add a score equal to the sum of the previous two scores.
- "D" → add a score equal to double the previous score.
- "C" → remove the previous score.

After all operations are applied, compute the total sum of the final record.
```
### Input Format:
```
An array of strings 'operations', where each element is "C", "D", "+", or an integer string.
```
### Output Format:
```
A single integer — the total sum of scores after all operations.
```

### Example 1:

```
Input:
ops = ["5","2","C","D","+"]

Output:
30
```

### Example 2:

```
Input:
ops = ["5","-2","4","C","D","9","+","+"]

Output:
27
```

#### Constraints

```
1 ≤ operations.length ≤ 1000
Each operation is "C", "D", "+", or an integer string in [-30000, 30000]
"+" always has at least two previous scores
"C" and "D" always have at least one previous score
```

#### Explanation

```
The operations modify the score list step by step, and finally the sum of
all valid scores is computed.
```

#### Reference

* [https://leetcode.com/problems/baseball-game/](https://leetcode.com/problems/baseball-game/)
* [https://www.geeksforgeeks.org/stack-in-python/](https://www.geeksforgeeks.org/stack-in-python/)
* [https://www.programiz.com/python-programming/list](https://www.programiz.com/python-programming/list)

---

### December 08 - Cafeteria Queue Challenge

#### Problem Statement

```
In a school cafeteria, students wait in a queue and sandwiches are stacked on a counter.
Each student prefers either circular (0) or square (1) sandwiches.

Rules:
- The student at the front checks the top sandwich.
- If they like it, they take it and leave.
- If not, they move to the end of the queue.
- The process stops when no student wants the top sandwich.

Your task is to determine how many students cannot eat.
```

```
Input Format:
students — array representing preferences (0 or 1)
sandwiches — array representing sandwich stack (0 or 1), index 0 is the top
```
### Output Format:
```
A single integer — number of students who cannot eat.
```

### Example 1:

```
Input:
students = [1,1,0,0]
sandwiches = [0,1,0,1]

Output:
0
```

### Example 2:

```
Input:
students = [1,1,1,0,0,1]
sandwiches = [1,0,0,0,1,1]

Output:
3
```

#### Constraints

```
1 ≤ students.length, sandwiches.length ≤ 100
students.length == sandwiches.length
students[i] ∈ {0,1}
sandwiches[i] ∈ {0,1}
```

#### Explanation

```
Students continue rotating in the queue until no one wants the top sandwich.
The remaining students are counted as unable to eat.
```

#### Reference

* [https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/)
* [https://www.programiz.com/python-programming/queue](https://www.programiz.com/python-programming/queue)
* [https://www.geeksforgeeks.org/queue-data-structure/](https://www.geeksforgeeks.org/queue-data-structure/)


### December 09 - Sum of Unique Elements

#### Problem Statement

```
You are given an array of integers. Your task is to find the sum of all elements
that appear exactly once in the array.

If no element is unique, the sum should be 0.
```
### Input Format:
```
- First line: an integer N (size of the array)
- Second line: N space-separated integers
```
### Output Format:
```
A single integer — the sum of all elements that appear exactly once.
```
### Sample Input 1:
```
6
1 2 2 3 4 4
```
### Sample Output 1:
```
4
```
### Sample Input 2:
```
5
5 5 5 5 5
```
### Sample Output 2:
```
0
```
### Explanation:
```
Sample 1:
Unique elements = 1 and 3
Sum = 1 + 3 = 4
Sample 2:
No element appears exactly once → output = 0
```
### Constraints:
```
1 ≤ N ≤ 100000
-10^9 ≤ array elements ≤ 10^9
```
#### Reference
- GeeksforGeeks – Frequency counting using hashmap:
  https://www.geeksforgeeks.org/frequency-of-array-elements/

## December 10 - Zig-Zag Linked List

#### Problem Statement

```
You are given a linked list representing a train of carriages. The goal is to reorder
the list in a zig-zag pattern:

Original:
L0 → L1 → L2 → … → Ln-1 → Ln

Reordered:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

You are allowed to change only the node pointers, not the node values.
```
### Input Format:
```
- An integer N (number of nodes)
- N space-separated integers representing node values
```

### Output Format:
```
Print the reordered linked list values separated by spaces.
```
### Sample Input 1:
```
Enter N: 4
Enter node values: 1 2 3 4
```
### Sample Output 1:
```
1 4 2 3
```
### Sample Input 2:
```
Enter N: 5
Enter node values: 1 2 3 4 5
```
### Sample Output 2:
```
1 5 2 4 3
```
### Constraints:
```
1 ≤ N ≤ 100000
Node values can be any integer.
Only node pointers may be changed.
```

#### Reference

- GeeksforGeeks – Reorder List (Zig-Zag merge)
  https://www.geeksforgeeks.org/reorder-list/

### December 11 - Counting Prime Numbers

#### Problem Statement

```
Given a non-negative integer N, your task is to count how many prime numbers
exist strictly less than N.

A prime number is a natural number greater than 1 that is divisible only by
1 and itself.
```

### Input Format:
```
A single integer N.
```
### Output Format:
```
The count of prime numbers less than N is: <value>
```

### Sample Input 1:
```
Enter N: 10
```
### Sample Output 1:
```
The count of prime numbers less than 10 is: 4
```

### Sample Input 2:
```
Enter N: 20
```
### Sample Output 2:
```
The count of prime numbers less than 20 is: 8
```
### Constraints:
```
0 ≤ N ≤ 1000000
```
#### Reference


- GeeksforGeeks – Sieve of Eratosthenes:
  https://www.geeksforgeeks.org/sieve-of-eratosthenes/

## December 12 - The Missing Positive Element

#### Problem Statement

```
You are given an unsorted list of N integers containing all values from 1 to N
exactly once, except:

- One number is missing.
- One number appears twice.

Your task is to find:
1. The missing positive integer.
2. The duplicate integer.

The solution must be efficient and use no extra auxiliary space.
```

### Input Format:
```
- First line: An integer N (the expected number of elements).
- Second line: N space-separated integers.
```
### Output Format:
```
Missing Number: <value>
Duplicate Number: <value>
```

### Sample Input 1:
```
5
3 1 2 2 5
```
### Sample Output 1:
```
Missing Number: 4
Duplicate Number: 2
```
### Sample Input 2:
```
4
4 3 3 1
```
### Sample Output 2:
```
Missing Number: 2
Duplicate Number: 3
```
### Constraints:
```
- Expected Time Complexity: O(N)
- Expected Space Complexity: O(1)
- All values are between 1 and N
```
#### Reference

- GeeksforGeeks – Cyclic Sort and finding missing/duplicate:
  https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/


## December 13 - Mountain Peaks in a Trail

### Problem Statement

```
You are analyzing a hiking trail represented by an array of integers heights, where
heights[i] is the elevation at the i-th checkpoint. A mountain peak is defined as a
point in the trail that is strictly higher than its immediate neighbors.

Rules:
- The first and last points in the trail cannot be peaks.
- If there are no peaks, return an empty list.
```

### Input Format

```
- An integer N — the number of checkpoints on the trail (3 ≤ N ≤ 10^5)
- N space-separated integers — the elevations of the checkpoints (1 ≤ heights[i] ≤ 10^6)
```

### Output Format

```
- Print the 0-based indices of all mountain peaks in ascending order, separated by spaces.
- If no peaks exist, print -1.
```

### Sample Input 1

```
8
1 3 2 4 5 3 2 1
```

### Sample Output 1

```
1 4
```

### Sample Input 2

```
5
1 2 3 4 5
```

### Sample Output 2

```
-1
```

### Constraints

```
- 3 ≤ N ≤ 10^5
- 1 ≤ heights[i] ≤ 10^6
```

### Expected complexity

```
Expected Complexity:
- Time: O(N)
- Space: O(P), where P is the number of peaks
```

### Reference

* GeeksforGeeks – Find peak element in array: [https://www.geeksforgeeks.org/find-peak-element/](https://www.geeksforgeeks.org/find-peak-element/)

## December 14 - Magical Treasure Chest Parser

### Problem Statement

```
You are an adventurer exploring a magical treasure chest. The chest contains either
single treasures (integers) or nested compartments that can themselves contain
treasures or more compartments.

The chest is described by a string s — a serialized representation of its contents:

- An integer represents a single treasure.
- Square brackets [ ] represent a compartment, which can contain integers or other compartments.

Your task is to write a parser that reads the string s and returns a structured
representation of the chest’s contents, preserving the nested structure.
```

### Input Format

```
- A single string s representing the serialized treasure chest.
```

### Output Format

```
- A structured object (NestedChest) representing the parsed chest:
  Each element is either an integer treasure or a nested compartment.
```

### Sample Input 1

```
"324"
```

### Sample Output 1

```
324
```

### Sample Input 2

```
"[123,[456,[789]]]"
```

### Sample Output 2

```
[123,[456,[789]]]
```

### Constraints

```
- 1 ≤ length of s ≤ 50,000
- s consists of digits, square brackets [ ], negative sign -, and commas ,
- s is guaranteed to be a valid serialized NestedChest
- All treasure values are in the range [-10^6, 10^6]
```

### Reference

* GeeksforGeeks – Deserialize nested list / Nested Integer: [https://www.geeksforgeeks.org/deserialize-nested-integer-array/](https://www.geeksforgeeks.org/deserialize-nested-integer-array/)

## December 15 - Royal Family Seating

### Problem Statement

```
A kingdom is arranging a royal family hierarchy in levels. Each level represents a
generation, with ancestors at the top and descendants below. 

The seating arrangement follows these rules:

1. Every generation, except possibly the last, must be completely filled.
2. In the last generation, all family members must sit as far left as possible.

The family hierarchy is represented as a binary tree, where each node is a family
member, and the tree’s root is the eldest ancestor.

Your task is to determine whether the seating arrangement forms a complete binary tree.
```

### Input Format

```
- The root of a binary tree (TreeNode) representing the royal family hierarchy.
```

### Output Format

```
- true if the family tree is complete (all levels except possibly the last are full,
  and the last level is left-filled).
- false otherwise.
```

### Sample Input 1

```
root = [1,2,3,4,5,6]
```

### Sample Output 1

```
true
```

### Sample Input 2

```
root = [1,2,3,4,5,null,7]
```

### Sample Output 2

```
false
```

### Constraints

```
- The number of nodes is in the range [1, 1000]
- Node values are unique integers
```
### Reference

* GeeksforGeeks – Check Complete Binary Tree: [https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/](https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/)

## December 16 - Treasure Trail Adjustment

### Problem Statement

```
You are a treasure hunter following a trail of treasure markers represented as a linked list.
Each marker contains a treasure value. Sometimes, a marker needs to be removed from the trail 
to optimize your path.

Your task is to remove the nth marker from the end of the trail and return the updated trail.
```

### Input Format

```
- head: the head of a singly linked list representing the trail of treasure markers.
- n: an integer indicating the position (from the end) of the marker to remove.
```

### Output Format

```
- Return the head of the linked list after removing the nth marker from the end.
```

### Sample Input 1

```
head = [1,2,3,4,5], n = 2
```

### Sample Output 1

```
[1,2,3,5]
```

### Sample Input 2

```
head = [1], n = 1
```

### Sample Output 2

```
[]
```

### Sample Input 3

```
head = [1,2], n = 1
```

### Sample Output 3

```
[1]
```

### Constraints

```
- The number of markers in the trail is sz, 1 ≤ sz ≤ 30
- 0 ≤ Node.val ≤ 100
- 1 ≤ n ≤ sz
```

### Explanation

```
After removing the nth marker from the end, the linked list is updated and returned as output.
```

### Reference

* GeeksforGeeks – Remove N-th Node from End of Linked List: [https://www.geeksforgeeks.org/remove-n-th-node-from-end-of-a-linked-list/](https://www.geeksforgeeks.org/remove-n-th-node-from-end-of-a-linked-list/)


## December 17 - Racing Turtles

#### Problem Statement

```
You are organizing a turtle race along a straight track with n turtles.
Each turtle has a starting position and a speed. Turtles cannot overtake but can join a slower turtle ahead to form a fleet.
Compute the total number of distinct turtle fleets that will reach the finish line.
```

### Input Format

```
- target: integer, the finish line position
- n: integer, number of turtles
- position: array of n integers, starting positions of turtles
- speed: array of n integers, speeds of turtles
```

### Output Format

```
- Print "The number of turtle fleets is: <value>" if one or more fleets reach the finish line.
- Print "No turtle fleets formed." if n = 0.
```

### Sample Input 1

```
target = 10
n = 1
position = [3]
speed = [3]
```

### Sample Output 1

```
The number of turtle fleets is: 1
```

### Sample Input 2

```
target = 12
n = 5
position = [10, 8, 0, 5, 3]
speed = [2, 4, 1, 1, 3]
```

### Sample Output 2

```
The number of turtle fleets is: 3
```

### Sample Input 3

```
target = 100
n = 3
position = [0, 2, 4]
speed = [4, 2, 1]
```

### Sample Output 3

```
The number of turtle fleets is: 1
```

### Constraints

```
- 0 ≤ n ≤ 10^5
- 0 ≤ position[i] < target ≤ 10^6
- 1 ≤ speed[i] ≤ 10^6
```

### Explanation

```
The problem requires counting how many separate groups of turtles (fleets) arrive at the finish line.
Turtles can join fleets if they catch up to slower turtles ahead, otherwise they form a new fleet.
```

## December 18 - Mirror Necklace Check

#### Problem Statement

```
A jeweler is inspecting a necklace made of beads, where each bead has a number engraved on it. 
The beads are strung in a single chain, and the jeweler wants to check if the necklace is symmetric — 
meaning the sequence of numbers reads the same from left to right and from right to left.

A necklace is considered mirrored if the bead numbers form a palindrome. 
Your task is to determine whether a given necklace is mirrored.
```

### Input Format

```
1. An integer N — the number of beads in the necklace.
2. N space-separated integers — the numbers engraved on each bead, in order from the first to the last bead.
```

### Output Format

```
- Print "The necklace is mirrored." if the sequence forms a palindrome.
- Print "The necklace is not mirrored." if it does not.
- Print "The necklace is empty." if N = 0.
```

### Sample Input 1

```
N = 5
Beads = 1 2 3 2 1
```

### Sample Output 1

```
The necklace is mirrored.
```

### Sample Input 2

```
N = 4
Beads = 10 20 20 30
```

### Sample Output 2

```
The necklace is not mirrored.
```

### Sample Input 3

```
N = 0
```

### Sample Output 3

```
The necklace is empty.
```

### Explanation

```
The necklace sequence is checked from both ends:
- Forward sequence: 1, 2, 3, 2, 1
- Backward sequence: 1, 2, 3, 2, 1
- Since the sequences match, the necklace is mirrored.
```

### Constraints

```
- 0 ≤ N ≤ 10^5
- Bead values are integers in the range [-10^6, 10^6]
```

#### Reference

* GeeksforGeeks – Check if linked list is palindrome: [https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/](https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/)


## December 19 - Balanced Team Assignment

#### Problem Statement

```
A company wants to assign employees to two project teams such that the total skill levels of both teams are as balanced as possible.

You are given an array of positive integers skills[], where skills[i] represents the skill level of the i-th employee.

Your task is to divide the employees into two teams such that the absolute difference between the total skill levels of the teams is minimized.
```

### Input Format

```
1. An integer N — the number of employees.
2. N space-separated integers — skills[0], skills[1], ..., skills[N-1].
```

### Output Format

```
Print a single integer — the minimum difference between the total skill levels of the two teams.
```

### Sample Input 1

```
5
3 1 4 2 2
```

### Sample Output 1

```
0
```

### Sample Input 2

```
4
1 2 3 5
```

### Sample Output 2

```
1
```

### Explanation

```
The goal is to partition the employees into two teams such that the sum of skills in each team is as close as possible.

For example:
- Sample 1: Team A = [3,2], Team B = [1,4,2], sums both equal 5 → difference 0.
- Sample 2: Team A = [1,5], Team B = [2,3], sums 6 and 5 → difference 1.
```

### Constraints

```
1 ≤ N ≤ 30
1 ≤ skills[i] ≤ 100
```

#### Reference

* GeeksforGeeks – Partition problem (minimum subset sum difference): [https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-difference-of-subset-sums-is-minimum/](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-difference-of-subset-sums-is-minimum/)


## December 20 - Tower Visibility Challenge

#### Problem Statement

```
A city has a row of N towers, each with a certain height. A tower can “see” the next taller tower to its right.

You are given an array heights[] where heights[i] represents the height of the i-th tower.

For each tower, determine the height of the first taller tower to its right. If there is no taller tower to the right, record -1 for that tower.
```

### Input Format

```
1. An integer N — the number of towers.
2. N space-separated integers — heights[0], heights[1], ..., heights[N-1].
```

### Output Format

```
Print N integers separated by spaces — the height of the first taller tower to the right for each tower, or -1 if none exists.
```

### Sample Input 1

```
6
4 5 2 25 7 6
```

### Sample Output 1

```
5 25 25 -1 -1 -1
```

### Sample Input 2

```
5
13 7 6 12 10
```

### Sample Output 2

```
-1 12 12 -1 -1
```

### Explanation

```
For each tower, we look for the first taller tower to its right:
- Tower 0 (height 4) → next taller tower is 5
- Tower 1 (height 5) → next taller tower is 25
- Tower 2 (height 2) → next taller tower is 25
- Tower 3 (height 25) → no taller tower → -1
- Tower 4 (height 7) → no taller tower → -1
- Tower 5 (height 6) → no taller tower → -1
```

### Constraints

```
1 ≤ N ≤ 10^5
1 ≤ heights[i] ≤ 10^9
```

#### Reference

* GeeksforGeeks – Next Greater Element: [https://www.geeksforgeeks.org/next-greater-element/](https://www.geeksforgeeks.org/next-greater-element/)

## December 21 - Efficient Parcel Sorting

#### Problem Statement

```
A delivery company needs an efficient way to sort parcels by their weights. The sorting machine processes parcels one by one and can perform two operations:

1. Move Front to Back (Rotate): Move the parcel at the front of the queue to the back of the queue.
2. Pick and Place: Remove the lightest parcel currently in the queue and place it in a sorted output list.

You must simulate the sorting process performed by the machine and display the final sorted list of parcel weights in non-decreasing order. The goal is to use the minimum number of rotations to achieve the sorting, following the exact behavior of the described machine.
```

### Input Format

```
- First line: An integer N — the number of parcels.
- Second line: N space-separated integers — the weights of the parcels.
```

### Output Format

```
Print the sorted list of parcel weights after performing the required operations.
```

### Sample Input 1

```
5
4 2 1 5 3
```

### Sample Output 1

```
1 2 3 4 5
```

### Sample Input 2

```
4
10 30 20 40
```

### Sample Output 2

```
10 20 30 40
```

### Sample Input 3

```
6
6 5 4 3 2 1
```

### Sample Output 3

```
1 2 3 4 5 6
```

### Explanation

```
The queue simulates selection sort using rotations:

- Always find the lightest parcel in the current queue.
- Rotate the queue to bring the lightest parcel to the front.
- Pick the parcel and place it in the sorted output.
- Repeat until the queue is empty.
```

### Constraints

```
1 ≤ N ≤ 10^4
1 ≤ weight ≤ 10^5
Expected Time Complexity: O(N²) or better
Expected Space Complexity: O(N)
```

#### Reference

* GeeksforGeeks – Queue Data Structure: [https://www.geeksforgeeks.org/queue-data-structure/](https://www.geeksforgeeks.org/queue-data-structure/)
* GeeksforGeeks – Sorting using selection concept: [https://www.geeksforgeeks.org/selection-sort/](https://www.geeksforgeeks.org/selection-sort/)

## December 22 - AquaNet – Minimum Time to Fill All City Reservoirs

#### Problem Statement

```
A city’s water network is represented as an undirected graph where each node is a reservoir and each edge is a pipe.

Some reservoirs already contain water at the start. Every minute, water flows from each filled reservoir to all its directly connected neighbors.

You need to find the minimum number of minutes required to fill all reservoirs. If it is impossible to fill every reservoir (some are disconnected), print "-1".
```

### Input Format

```
1. Enter the number of reservoirs V and the number of pipes E.
2. Enter E pairs of integers u v, representing a pipe between reservoirs u and v.
3. Enter V space-separated integers (0 or 1):
   - 1 → reservoir initially has water
   - 0 → reservoir is empty
```

### Output Format

```
- Print the minimum number of minutes required to fill all reservoirs.
- If any reservoir cannot be filled, print -1.
```

### Sample Input 1

```
7 6
0 1
1 2
2 3
3 4
1 5
5 6
1 0 0 0 0 0 0
```

### Sample Output 1

```
4
```

### Sample Input 2

```
6 4
0 1
1 2
3 4
4 5
1 1 0 0 0 0
```

### Sample Output 2

```
-1
```

### Explanation

```
Water spreads from initially filled reservoirs to their neighbors every minute. 
The total time is counted until all reservoirs are filled. 
If some reservoirs are disconnected and cannot be reached, output -1.
```

### Constraints

```
1 ≤ V ≤ 10^5
0 ≤ E ≤ 10^5
Reservoir indices: 0 to V-1
Initial water state: 0 or 1
```

#### Reference

* LeetCode – Rotting Oranges: [https://leetcode.com/problems/rotting-oranges/](https://leetcode.com/problems/rotting-oranges/)
* LeetCode – 01 Matrix: [https://leetcode.com/problems/01-matrix/](https://leetcode.com/problems/01-matrix/)
* GeeksforGeeks – Multi-Source BFS: [https://www.geeksforgeeks.org/multi-source-bfs/](https://www.geeksforgeeks.org/multi-source-bfs/)

## December 23 - Shortest Path in a Warehouse Grid

#### Problem Statement

```
A warehouse is represented as a 2D grid of size m × n. Each cell contains:
- 0 → Empty path (you can walk)
- 1 → Obstacle (cannot pass through)

You start at the top-left corner (0,0) and must reach the bottom-right corner (m−1, n−1). 
You can move UP, DOWN, LEFT, RIGHT (no diagonal moves).

Compute the minimum number of steps required to travel from start to goal without crossing obstacles. 
If the destination cannot be reached, print -1.
```

### Input Format

```
1. First line: two integers m n — number of rows and columns.
2. Next m lines: each line contains n integers (0 or 1), representing the warehouse grid.
```

### Output Format

```
- Print a single integer — the minimum number of steps from (0,0) to (m-1,n-1), or -1 if unreachable.
```

### Sample Input 1

```
4 5
0 0 0 0 0
1 1 0 1 0
0 0 0 0 0
0 1 1 1 0
```

### Sample Output 1

```
7
```

### Sample Input 2

```
3 3
0 1 0
0 1 0
0 0 0
```

### Sample Output 2

```
5
```

### Explanation

```
- Start: (0,0)
- End: (m-1, n-1)
- Obstacles (1s) cannot be crossed.
- The shortest path moves only through walkable cells (0s) in the minimal number of steps.
- For Sample Input 1, one possible path: right 2 → down 3 → right 2 = 7 steps.
```

### Constraints

```
1 ≤ m, n ≤ 1000
Grid cells: 0 or 1
Start and end positions are always within bounds
```

#### Reference

* LeetCode – Shortest Path in Binary Matrix: [https://leetcode.com/problems/shortest-path-in-binary-matrix/](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
* GeeksforGeeks – BFS on Grid: [https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/](https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/)
* GeeksforGeeks – Breadth-First Search (BFS) Basics: [https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/)

## December 24 - First Non-Repeating Character in a String

#### Problem Statement

```
You are given a string containing lowercase English letters. 

Determine the first character that does not repeat anywhere else in the string. 

If all characters repeat, print "No non-repeating character found."
```

### Input Format

```
- A single string containing only lowercase letters (a–z), without spaces.
```

### Output Format

```
- If a non-repeating character exists:
  "The first non-repeating character is: <character>"
- If all characters repeat:
  "No non-repeating character found."
```

### Sample Input 1

```
swiss
```

### Sample Output 1

```
The first non-repeating character is: w
```

### Sample Input 2

```
aabbcc
```

### Sample Output 2

```
No non-repeating character found.
```

### Explanation

```
For Sample Input 1:
- Input string: swiss
- s → appears 3 times
- w → appears 1 time
- i → appears 1 time
- s, s again → repeating
The first character that appears only once is 'w'.
```

### Constraints

```
- 1 ≤ length of string ≤ 10^5
- String contains only lowercase English letters (a–z)
```

#### Reference

* LeetCode – First Unique Character in a String: [https://leetcode.com/problems/first-unique-character-in-a-string/](https://leetcode.com/problems/first-unique-character-in-a-string/)
* GeeksforGeeks – First Non-Repeating Character in a String: [https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/](https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/)

## December 25 - Treasure Hunt in the Locked Maze

### Problem Statement

```
You are an adventurer exploring a maze to find a hidden treasure. 
The maze is a 2D grid of size M × N with the following symbols:

- S → Starting position
- T → Treasure (goal)
- . → Open path
- # → Wall
- a–j → Keys to unlock doors
- A–J → Locked doors that require corresponding keys

You can move up, down, left, or right. 
Find the minimum number of steps needed to reach the treasure, collecting any keys needed to unlock doors. 
Return -1 if the treasure is unreachable.
```

### Input Format

```
- Two integers M and N — number of rows and columns
- M lines, each containing N characters representing the maze
```

### Output Format

```
- A single integer: minimum steps to reach the treasure
- -1 if unreachable
```

### Sample Input 1

```
3 3
S.a
#A#
..T
```

### Sample Output 1

```
6
```

### Sample Input 2

```
3 4
S.A.
###.
a...
```

### Sample Output 2

```
-1
```

### Explanation

```
Sample 1 Maze:

Row 0: S . a
Row 1: # A #
Row 2: . . T

Path:
1. Start at S (0,0)
2. Move right to collect key a → (0,1) → (0,2) (steps = 2)
3. Backtrack to door A and unlock it → (0,2) → (0,1) → (1,1) (steps = 4)
4. Move to treasure → (1,1) → (2,1) → (2,2) (steps = 6)

Total steps = 6
```

### Constraints

```
- 1 ≤ M, N ≤ 30
- Maximum 10 keys/doors (a–j, A–J)
- Exactly one starting point S and one treasure T
```

### Reference

* Shortest Path in a Grid with Keys and Doors – LeetCode: [https://leetcode.com/problems/shortest-path-to-get-all-keys/](https://leetcode.com/problems/shortest-path-to-get-all-keys/)
* BFS on Grid – GeeksforGeeks: [https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/](https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/)

## December 26 - Mountain Climber – Longest Ascending Path

### Problem Statement

```
You are exploring a mountainous terrain represented as an M × N grid. 
Each cell contains an integer representing the height at that location.

Your goal is to climb along the longest strictly ascending path, moving only to 
adjacent cells (up, down, left, right). 
Find the length of the longest strictly increasing path in the terrain.
```

### Input Format

```
- Two integers M and N — number of rows and columns
- M lines each with N space-separated integers — heights of terrain cells
```

### Output Format

```
- A single integer: length of the longest strictly ascending path
```

### Sample Input 1

```
3 3
9 9 4
6 6 8
2 1 1
```

### Sample Output 1

```
4
```

### Sample Input 2

```
3 3
3 4 5
3 2 6
2 2 1
```

### Sample Output 2

```
4
```

### Sample Input 3

```
1 1
1
```

### Sample Output 3

```
1
```

### Explanation

```
Sample 1: Longest ascending path is [1 → 2 → 6 → 9]
Sample 2: One possible path is [3 → 4 → 5 → 6]
```

### Constraints

```
- 1 ≤ M, N ≤ 200
- 0 ≤ height ≤ 2³¹ - 1
```

### Reference

* Longest Increasing Path in a Matrix – LeetCode: [https://leetcode.com/problems/longest-increasing-path-in-a-matrix/](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
* DFS with Memoization – GeeksforGeeks: [https://www.geeksforgeeks.org/longest-increasing-path-in-a-matrix/](https://www.geeksforgeeks.org/longest-increasing-path-in-a-matrix/)

## December 27 - Signal Propagation in a Network

### Problem Statement

```
A city has a network of communication towers represented as a directed graph. 
Each tower is numbered from 0 to N-1 and each one-way link has a propagation delay.

A signal is sent from a source tower S. The signal travels along the directed links 
to other towers. Multiple signals can travel simultaneously along different links.

Determine the minimum time needed for all towers to receive the signal. 
If some towers cannot be reached, return -1.
```

### Input Format

```
- An integer N — number of towers
- An integer M — number of directed links
- M lines each with three integers u, v, t — a link from tower u to v with propagation time t
- An integer S — the source tower
```

### Output Format

```
- A single integer: minimum time for all towers to receive the signal, or -1 if some are unreachable
```

### Sample Input 1

```
4
4
0 1 2
1 2 1
0 2 4
2 3 3
0
```

### Sample Output 1

```
6
```

### Sample Input 2

```
3
2
0 1 5
1 0 5
0
```

### Sample Output 2

```
-1
```

### Explanation

```
Sample 1: 
- Signal travels 0 → 1 → 2 → 3: total time = 2 + 1 + 3 = 6
- Other path 0 → 2 → 3 = 4 + 3 = 7, which is slower
- Minimum time for all towers = 6

Sample 2:
- Tower 2 is unreachable from source 0 → return -1
```

### Constraints

```
- 1 ≤ N ≤ 500
- 0 ≤ M ≤ N × (N-1)
- 0 ≤ u, v < N
- 1 ≤ t ≤ 10^4
```

### Reference

* Network Delay Time – LeetCode: [https://leetcode.com/problems/network-delay-time/](https://leetcode.com/problems/network-delay-time/)
* Dijkstra’s Algorithm – GeeksforGeeks: [https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority-queue/](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority-queue/)

## December 28 - Sweet Rewards for Students

### Problem Statement

```
In a school, n students stand in a line, each with a performance score. 
Sweets must be distributed following these rules:

1. Every student receives at least one sweet.
2. A student with a higher score than their immediate neighbors must get more sweets than them.

Determine the minimum total number of sweets required while satisfying these rules.
```

### Input Format

```
- An integer n — number of students
- A line with n space-separated integers — performance scores of the students
```

### Output Format

```
- A single integer: minimum total number of sweets
```

### Sample Input 1

```
3
1 0 2
```

### Sample Output 1

```
5
```

### Sample Input 2

```
3
1 2 2
```

### Sample Output 2

```
4
```

### Explanation

```
Sample 1:
- Scores: [1, 0, 2]
- Minimum sweets distribution: [2, 1, 2]
- Total sweets = 5

Sample 2:
- Scores: [1, 2, 2]
- Minimum sweets distribution: [1, 2, 1]
- Total sweets = 4
```

### Constraints

```
- 1 ≤ n ≤ 2 × 10^4
- 0 ≤ score[i] ≤ 2 × 10^4
```

### Reference

* Candy Problem – LeetCode: [https://leetcode.com/problems/candy/](https://leetcode.com/problems/candy/)
* Greedy Two-Pass Approach – GeeksforGeeks: [https://www.geeksforgeeks.org/candy-distribution-problem/](https://www.geeksforgeeks.org/candy-distribution-problem/)

## December 29 - Minimum Weight Cycle in a Graph

### Problem Statement

```
Given an undirected, weighted graph with V vertices numbered from 0 to V-1, and E edges represented as a 2D array edges[][], where each element edges[i] = [u, v, w] denotes an edge between nodes u and v with weight w. All edge weights are positive integers.

Your task is to find the minimum weight cycle in the graph.

Note:
- A cycle in a graph is a path that starts and ends at the same vertex without repeating any edges or vertices (except the starting/ending vertex).
- The minimum weight cycle is the one among all possible cycles that has the smallest total sum of edge weights.
```

### Input Format

```
- An integer V — number of vertices
- A 2D array edges — list of edges [u, v, w]
```

### Output Format

```
- A single integer — total weight of the minimum cycle
```

### Sample Input 1

```
V = 5
edges = [
 [0, 1, 2],
 [1, 2, 2],
 [1, 3, 1],
 [1, 4, 1],
 [0, 4, 3],
 [2, 3, 4]
]
```

### Sample Output 1

```
6
```

### Sample Input 2

```
V = 6
edges = [
 [0, 1, 4],
 [1, 2, 3],
 [2, 0, 5],
 [1, 3, 2],
 [3, 4, 6],
 [4, 1, 1]
]
```

### Sample Output 2

```
9
```

### Explanation

```
Sample 1:
- Cycle 0 → 1 → 4 → 0: weight = 2 + 1 + 3 = 6
- Cycle 1 → 2 → 3 → 1: weight = 2 + 4 + 1 = 7
- Minimum weight cycle = 6

Sample 2:
- Cycle 0 → 1 → 2 → 0: weight = 4 + 3 + 5 = 12
- Cycle 1 → 3 → 4 → 1: weight = 2 + 6 + 1 = 9
- Minimum weight cycle = 9
```

### Constraints

```
- 1 ≤ V ≤ 500
- 1 ≤ number of edges ≤ V*(V-1)/2
- 1 ≤ weight ≤ 10^5
```

---

## December 30 - Burn the Binary Tree from Target Node

### Problem Statement

```
Given a binary tree and a target node, fire starts at the target node and spreads to all connected nodes (parent and children) simultaneously. 

Your task is to print the sequence of nodes burning at each time step until the entire tree is burned.

Rules:
- Fire spreads constantly to connected nodes.
- Every node takes the same time to burn.
- Each node burns only once.
```

### Input Format

```
- A binary tree
- An integer representing the target node
```

### Output Format

```
- Print the sequence of nodes burning at each time step, one line per step
```

### Sample Input 1

```
Target node = 14
```

### Sample Output 1

```
14
21, 24, 10
15, 12
22, 23, 13
```

### Sample Input 2

```
Target node = 41
```

### Sample Output 2

```
41
2, 19
12
82
15, 95
21, 7, 16
```

### Explanation

```
Sample 1:
- Node 14 burns first
- Next, neighbors 21, 24, 10 burn
- Then nodes 15 and 12 burn
- Finally, leaves 22, 23, 13 burn
- Process continues until the entire tree is burned

Sample 2:
- Node 41 burns first
- Then neighbors 2 and 19 burn
- Fire spreads level by level, covering parent and child nodes at each step until the tree is fully burned
```

### Constraints

```
- 1 ≤ number of nodes ≤ 10^4
- Node values are unique integers
```

## December 31 - Sudoku Solver

### Problem Statement

```
Write a program to solve a Sudoku puzzle by filling the empty cells. The Sudoku must follow these rules:

- Each of the digits 1-9 must occur exactly once in each row.
- Each of the digits 1-9 must occur exactly once in each column.
- Each of the digits 1-9 must occur exactly once in each of the 9 3×3 sub-boxes of the grid.
- The '.' character indicates empty cells.
```

### Input Format

```
- A 9×9 grid where each cell contains a digit 1–9 or '.' for empty cells.
```

### Output Format

```
- Print the completed Sudoku grid as a 9×9 matrix.
```

### Sample Input

```
5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9
```

### Sample Output

```
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
```

### Explanation

```
- All rows, columns, and 3×3 sub-boxes contain digits 1–9 exactly once.
- The puzzle is completely filled while respecting Sudoku rules.
```

### Constraints

```
- board.length == 9
- board[i].length == 9
- board[i][j] is a digit or '.'
- It is guaranteed that the input board has only one solution
```


# FAQ

#### Who can join the Challenge?

Anyone who is passionate about coding and can dedicate a little time a day for the challenge for the next 31 days.

#### When should I submit the pull request?

You don't need to submit it everyday. Just submit it once you're done with all 31 algorithms.

#### What if I'm not able to code every day?

Not a problem. While coding every day is nice, we understand that other commitments might interfere with it.

Plus its holiday season. So you don't have to solve one problem every day.

Go at your own pace. One per day or 7 a week or even all 30 in a day.

#### What language should I use to code?

Anything! New to GoLang? Best way to practice it.

Wanna find out what all this hype about Python is? Use it!

Any and all languages are welcome.

Maybe you could try using a different language for every problem as a mini-challenge?

#### Fork? Pull request? What is all that? I don't know how to use GitHub!

If you are new to Git or GitHub, check out this out [GitHub](https://guides.github.com/activities/hello-world/)

#### How should I complete these programs?

We have a folder for each day of the month. Simply complete your code and move the file into that folder.

Be sure to rename your file to the following format:  `username_problemname`
Example:
`exampleUser_probname.py`


**Please do not modify any existing files in the repository.**

#### I forked the repository but some problems were added only after that. How do I access those problems?

Not to worry! Open your nearest terminal or command prompt and navigate over to your forked repository.

Enter these commands:

```bash
git remote add upstream https://github.com/SVCE-ACM/A-December-of-Algorithms-2024.git
git fetch upstream
git merge upstream/main
```

If you're curious, the commands simply add a new remote called upstream that is linked to this repository. Then it 'fetches' or retrieves the contents of the repository and attempts to merge it with your progress.
Note that if you've already added the upstream repository, you don't need to re-add it in the future while fetching the newer questions.

#### I received a merge error. What do I do?

This shouldn't happen unless you modify an existing file in the repository. There's a lot of potential troubleshooting that might be needed, but the simplest thing to do is to make a copy of your code outside the repository and then clone it once again. Now repeat the steps from the answer above. Merge it and then add your code. Now proceed as usual. :)

#### I'm facing difficulties with/need help understanding a particular question.

Open up an [issue](https://github.com/SVCE-ACM/A-December-of-Algorithms-2021/issues) on this repository and we'll do our best to help you out.

###### [[Back to Top]](#----)

![wave](http://cdn.thekrishna.in/img/common/border.png)

```

```
