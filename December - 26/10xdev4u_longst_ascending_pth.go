package main

import (
	"fmt"
)

var directions = [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

func longestPth(grid [][]int, row, col int) int {
	dp := make([][]int, len(grid))
	for i := range dp {
		dp[i] = make([]int, len(grid[0]))
	}

	maxLn := 0

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			len := dfs(grid, i, j, dp, row, col)
			if len > maxLn {
				maxLn = len
			}
		}
	}
	return maxLn
}

func dfs(grid [][]int, i, j int, dp [][]int, row, col int) int {
	if dp[i][j] != 0 {
		return dp[i][j]
	}
	mxPth := 1
	for _, dir := range directions {
		newR := i + dir[0]
		newC := j + dir[1]

		if newR >= 0 && newR < row && newC >= 0 && newC < col && grid[newR][newC] > grid[i][j] {
			length := 1 + dfs(grid, newR, newC, dp, row, col)
			if length > mxPth {
				mxPth = length
			}
		}
	}
	dp[i][j] = mxPth
	return mxPth
}

func main() {
	// Solution for Day 26: longst_ascending_pth
	var r, c int
	fmt.Scan(&r, &c)

	matrix := make([][]int, r)
	for i := 0; i < r; i++ {
		matrix[i] = make([]int, c)
		for j := 0; j < c; j++ {
			fmt.Scan(&matrix[i][j])
		}
	}
	fmt.Println(longestPth(matrix, r, c))
}
