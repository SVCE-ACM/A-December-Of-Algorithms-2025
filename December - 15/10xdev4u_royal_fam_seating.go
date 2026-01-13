package main

import (
	"fmt"
)

type TreNode struct {
	val   int
	left  *TreNode
	right *TreNode
}

func isCmplTree(root *TreNode) bool {
	if root == nil {
		return true
	}

	Que := []*TreNode{root}
	sawNil := false

	for len(Que) > 0 {
		node := Que[0]
		Que = Que[1:]

		switch {
		case node == nil:
			sawNil = true
		case sawNil:
			return false
		default:
			Que = append(Que, node.left)
			Que = append(Que, node.right)
		}
	}
	return true
}

func buldTre(vals []int) *TreNode {
	if len(vals) == 0 || vals[0] == -1 {
		return nil
	}
	root := &TreNode{val: vals[0]}
	Que := []*TreNode{root}
	i := 1

	for i < len(vals) {
		node := Que[0]
		Que = Que[1:]

		if i < len(vals) && vals[i] != -1 {
			node.left = &TreNode{val: vals[i]}
			Que = append(Que, node.left)
		}
		i++

		if i < len(vals) && vals[i] != -1 {
			node.right = &TreNode{val: vals[i]}
			Que = append(Que, node.right)
		}
		i++
	}
	return root
}

func main() {
	// Solution for Day 15: royal_fam_seating
	var n int
	fmt.Scan(&n)

	vals := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&vals[i])
	}

	root := buldTre(vals)
	fmt.Println(isCmplTree(root))
}
