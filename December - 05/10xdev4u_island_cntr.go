package main

import (
	"fmt"
)

func dfs(grid [][]int, i, j, rows, cols int) {
	if i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0 {
		return
	}

	grid[i][j] = 0
	dfs(grid, i+1, j, rows, cols)
	dfs(grid, i-1, j, rows, cols)
	dfs(grid, i, j+1, rows, cols)
	dfs(grid, i, j-1, rows, cols)
}

func countIslands(grid [][]int, row, col int) int {
	count := 0
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == 1 {
				count++
				dfs(grid, i, j, row, col)
			}
		}
	}
	return count
}

func main() {
	// Solution for Day 05: island_cntr
	var x, y int
	fmt.Scan(&x, &y)
	grid := make([][]int, x)
	for i := 0; i < x; i++ {
		grid[i] = make([]int, y)
		for j := 0; j < y; j++ {
			fmt.Scan(&grid[i][j])
		}
	}
	fmt.Println(countIslands(grid, x, y))
}
