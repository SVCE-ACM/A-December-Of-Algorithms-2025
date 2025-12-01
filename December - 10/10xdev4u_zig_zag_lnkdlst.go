package main

import (
	"fmt"
)

type Node struct {
	data int
	next *Node
}

func createLL(nodeEmts []int) *Node {
	head := &Node{data: nodeEmts[0]}
	curr := head
	for i := 1; i < len(nodeEmts); i++ {
		curr.next = &Node{data: nodeEmts[i]}
		curr = curr.next
	}
	return head
}

func reOrderLL(head *Node) {
	if head == nil || head.next == nil {
		return
	}

	slow, fast := head, head
	for fast != nil && fast.next != nil {
		slow = slow.next
		fast = fast.next.next
	}

	secondHlf := slow.next
	slow.next = nil

	var prev *Node = nil
	curr := secondHlf
	for curr != nil {
		nxtTmp := curr.next
		curr.next = prev
		prev = curr
		curr = nxtTmp
	}
	secondHlf = prev
	firstHlf := head

	for secondHlf != nil {
		firstNext := firstHlf.next
		secondNext := secondHlf.next

		firstHlf.next = secondHlf
		secondHlf.next = firstNext

		firstHlf = firstNext
		secondHlf = secondNext
	}
}

func printLL(head *Node) {
	curr := head
	for curr != nil {
		fmt.Printf("%d -> ", curr.data)
		curr = curr.next
	}
	fmt.Println("nil")
}

func main() {
	// Solution for Day 10: zig_zag_lnkdlst
	var n int
	fmt.Scan(&n)
	nodeEmts := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&nodeEmts[i])
	}
	head := createLL(nodeEmts)
	reOrderLL(head)
	printLL(head)
}
