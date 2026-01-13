package main

import (
	"fmt"
)

type Pntx struct {
	r, c, dist int
}

func shortsPth(grid [][]int, row, col int) int {
	if grid[0][0] == 1 || grid[row-1][col-1] == 1 {
		return -1
	}

	movsRow := []int{-1, 1, 0, 0}
	movsCol := []int{0, 0, -1, 1}

	Que := []Pntx{{0, 0, 0}}
	visited := make([][]bool, row)

	for i := 0; i < row; i++ {
		visited[i] = make([]bool, col)
	}
	visited[0][0] = true
	for len(Que) > 0 {
		curr := Que[0]
		Que = Que[1:]

		if curr.r == row-1 && curr.c == col-1 {
			return curr.dist
		}
		for i := 0; i < 4; i++ {
			newR := curr.r + movsRow[i]
			newC := curr.c + movsCol[i]

			if newR >= 0 && newR < row && newC >= 0 && newC < col &&
				grid[newR][newC] == 0 && !visited[newR][newC] {
				visited[newR][newC] = true
				Que = append(Que, Pntx{newR, newC, curr.dist + 1})
			}
		}
	}
	return -1
}

func main() {
	// Solution for Day 23: shortest_path_in_wrhse
	var row, col int
	fmt.Scan(&row, &col)

	griD := make([][]int, row)
	for i := 0; i < row; i++ {
		griD[i] = make([]int, col)
		for j := 0; j < col; j++ {
			fmt.Scan(&griD[i][j])
		}
	}
	fmt.Println(shortsPth(griD, row, col))
}
