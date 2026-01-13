package main

import (
	"container/heap"
	"fmt"
	"math"
)

type Edg struct {
	to, time int
}

type Itm struct {
	towr, indx, time int
}

type PQ []*Itm

func (pq PQ) Len() int { return len(pq) }

func (pq PQ) Less(i, j int) bool {
	return pq[i].time < pq[j].time
}

func (pq PQ) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PQ) Push(x interface{}) {
	*pq = append(*pq, x.(*Itm))
}

func (pq *PQ) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}

func signalPropg(n int, edges [][3]int, k int) int {
	graph := make([][]Edg, n)
	for _, e := range edges {
		from, to, time := e[0], e[1], e[2]
		graph[from] = append(graph[from], Edg{to, time})
	}

	dist := make([]int, n)
	for i := range dist {
		dist[i] = math.MaxInt32
	}
	dist[k] = 0

	pq := &PQ{}
	heap.Init(pq)
	heap.Push(pq, &Itm{k, -1, 0})

	for pq.Len() > 0 {
		curr := heap.Pop(pq).(*Itm)
		towr, time := curr.towr, curr.time

		if time > dist[towr] {
			continue
		}

		for _, edge := range graph[towr] {
			newTime := time + edge.time
			if newTime < dist[edge.to] {
				dist[edge.to] = newTime
				heap.Push(pq, &Itm{edge.to, towr, newTime})
			}
		}
	}

	ans := 0
	for _, d := range dist {
		if d == math.MaxInt32 {
			return -1
		}
		if d > ans {
			ans = d
		}
	}
	return ans
}

func main() {
	// Solution for Day 27: signal_prop_in_network
	var n, m int
	fmt.Scan(&n, &m)
	edges := make([][3]int, m)
	for i := 0; i < m; i++ {
		fmt.Scan(&edges[i][0], &edges[i][1], &edges[i][2])
	}
	var k int
	fmt.Scan(&k)
	fmt.Println(signalPropg(n, edges, k))
}
