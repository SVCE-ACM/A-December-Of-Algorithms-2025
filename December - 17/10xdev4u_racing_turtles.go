package main

import (
	"fmt"
	"sort"
)

type Turtl struct {
	pos, speed int
}

func countFleets(trgt int, speed []int, posx []int, n int) int {
	turtls := make([]Turtl, n)
	for i := 0; i < n; i++ {
		turtls[i] = Turtl{posx[i], speed[i]}
	}

	sort.Slice(turtls, func(i, j int) bool {
		return turtls[i].pos > turtls[j].pos
	})

	fleets := 0
	var lastTime float64 = -1.0
	for _, t := range turtls {
		time := float64(trgt-t.pos) / float64(t.speed)
		if time > lastTime {
			fleets++
			lastTime = time
		}
	}
	return fleets
}

func main() {
	// Solution for Day 17: racing_turtles
	var trgt, n int
	fmt.Scan(&trgt, &n)
	posX := make([]int, n)
	speD := make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Scan(&posX[i])
	}
	for i := 0; i < n; i++ {
		fmt.Scan(&speD[i])
	}
	fmt.Println(countFleets(trgt, speD, posX, n))
}
