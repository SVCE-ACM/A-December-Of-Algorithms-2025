package main

import (
	"fmt"
)

func minTime2Fill(v int, edges [][]int, water []int) int {
	graph := make([][]int, v)
	for _, edge := range edges {
		u, w := edge[0], edge[1]
		graph[u] = append(graph[u], w)
		graph[w] = append(graph[w], u)
	}

	visited := make([]bool, v)
	Que := []int{}
	timeT := make([]int, v)

	for i := 0; i < v; i++ {
		if water[i] > 0 {
			Que = append(Que, i)
			visited[i] = true
			timeT[i] = 0
		}
	}

	maxTime := 0
	for len(Que) > 0 {
		curr := Que[0]
		Que = Que[1:]

		for _, neighbor := range graph[curr] {
			if !visited[neighbor] {
				visited[neighbor] = true
				timeT[neighbor] = timeT[curr] + 1
				if timeT[neighbor] > maxTime {
					maxTime = timeT[neighbor]
				}
				Que = append(Que, neighbor)
			}
		}
	}

	for i := 0; i < v; i++ {
		if !visited[i] {
			return -1
		}
	}

	return maxTime
}

func main() {
	// Solution for Day 22: aquanet_min_tim2fill
	var v, e int
	fmt.Scan(&v, &e)

	edges := make([][]int, e)
	for i := 0; i < e; i++ {
		var u, w int
		fmt.Scan(&u, &w)
		edges[i] = []int{u, w}
	}

	water := make([]int, v)
	for i := 0; i < v; i++ {
		fmt.Scan(&water[i])
	}

	fmt.Println(minTime2Fill(v, edges, water))
}
