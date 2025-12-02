package main

import (
	"fmt"
)

type Stpx struct {
	row, col, key, dist int
}

type Statx struct {
	row, col, key int
}

func tresurHnt(grid []string, r, c int) int {
	startR, startC := 0, 0
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if grid[i][j] == 'S' {
				startR, startC = i, j
			}
		}
	}

	Que := []Stpx{{startR, startC, 0, 0}}

	visited := make(map[Statx]bool)
	visited[Statx{startR, startC, 0}] = true

	dirR, dirC := []int{-1, 1, 0, 0}, []int{0, 0, -1, 1}

	for len(Que) > 0 {
		curr := Que[0]
		Que = Que[1:]

		if grid[curr.row][curr.col] == 'T' {
			return curr.dist
		}

		for d := 0; d < 4; d++ {
			nr, nc := curr.row+dirR[d], curr.col+dirC[d]

			if nr < 0 || nr >= r || nc < 0 || nc >= c {
				continue
			}

			cell := grid[nr][nc]
			if cell == '#' {
				continue
			}

			newKey := curr.key

			if cell >= 'a' && cell <= 'j' {
				newKey |= 1 << (cell - 'a')
			}
			if cell >= 'A' && cell <= 'J' {
				if (newKey & (1 << (cell - 'A'))) == 0 {
					continue
				}
			}

			state := Statx{nr, nc, newKey}
			if !visited[state] {
				visited[state] = true
				Que = append(Que, Stpx{nr, nc, newKey, curr.dist + 1})
			}
		}
	}
	return -1
}

func main() {
	// Solution for Day 25: treasure_hunt_in_lokdmaze
	var Row, Col int
	fmt.Scan(&Row, &Col)
	grid := make([]string, Row)
	for i := 0; i < Row; i++ {
		fmt.Scan(&grid[i])
	}
	fmt.Println(tresurHnt(grid, Row, Col))
}
