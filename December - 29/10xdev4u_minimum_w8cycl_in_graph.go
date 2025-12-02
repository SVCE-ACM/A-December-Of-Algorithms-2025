package main

import (
	"container/heap"
	"fmt"
	"math"
)

type Edge struct {
	to     int
	weight int
}

type Item struct {
	node int
	dist int
}

type PriorityQueue []Item

func (pq PriorityQueue) Len() int           { return len(pq) }
func (pq PriorityQueue) Less(i, j int) bool { return pq[i].dist < pq[j].dist }
func (pq PriorityQueue) Swap(i, j int)      { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(Item))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}

func dijkstra(graph [][]Edge, V, start, end, skipU, skipV int) int {
	dist := make([]int, V)
	for i := range dist {
		dist[i] = math.MaxInt32
	}
	dist[start] = 0

	pq := &PriorityQueue{}
	heap.Init(pq)
	heap.Push(pq, Item{node: start, dist: 0})

	for pq.Len() > 0 {
		current := heap.Pop(pq).(Item)
		u := current.node

		if current.dist > dist[u] {
			continue
		}

		if u == end {
			break
		}

		for _, edge := range graph[u] {
			v := edge.to
			w := edge.weight

			if (u == skipU && v == skipV) || (u == skipV && v == skipU) {
				continue
			}

			newDist := dist[u] + w
			if newDist < dist[v] {
				dist[v] = newDist
				heap.Push(pq, Item{node: v, dist: newDist})
			}
		}
	}

	return dist[end]
}

func minWeightCycle(V int, edges [][3]int) int {
	graph := make([][]Edge, V)
	for _, e := range edges {
		u, v, w := e[0], e[1], e[2]
		graph[u] = append(graph[u], Edge{to: v, weight: w})
		graph[v] = append(graph[v], Edge{to: u, weight: w})
	}

	minCycle := math.MaxInt32

	for _, e := range edges {
		u, v, w := e[0], e[1], e[2]

		if w >= minCycle {
			continue
		}

		pathDist := dijkstra(graph, V, u, v, u, v)
		if pathDist < math.MaxInt32 {
			cycleWeight := w + pathDist
			if cycleWeight < minCycle {
				minCycle = cycleWeight
			}
		}
	}

	if minCycle == math.MaxInt32 {
		return -1
	}

	return minCycle
}

func main() {
	var V, E int
	fmt.Scan(&V)
	fmt.Scan(&E)

	edges := make([][3]int, E)
	for i := 0; i < E; i++ {
		var u, v, w int
		fmt.Scan(&u, &v, &w)
		edges[i] = [3]int{u, v, w}
	}

	result := minWeightCycle(V, edges)
	fmt.Println(result)
}
