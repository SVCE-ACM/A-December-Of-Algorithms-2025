package main

import (
	"fmt"
)

type node struct {
	val  int
	next *node
}

func createLL(arr []int, n int) *node {
	head := &node{val: arr[0]}
	curr := head
	for i := 1; i < n; i++ {
		curr.next = &node{val: arr[i]}
		curr = curr.next
	}
	return head
}

func removNth(head *node, n int) *node {
	dmy := &node{next: head}
	slow, fast := dmy, dmy

	for i := 0; i <= n; i++ {
		fast = fast.next
	}

	for fast != nil {
		slow = slow.next
		fast = fast.next
	}

	slow.next = slow.next.next
	return dmy.next
}

func printLL(head *node) {
	curr := head
	for curr != nil {
		fmt.Printf("%d -> ", curr.val)
		curr = curr.next
	}
	fmt.Println("nil")
}

func main() {
	// Solution for Day 16: treasur_trail_adjstmnt
	var no, n int
	fmt.Scan(&no, &n)

	arrY := make([]int, no)
	for i := 0; i < no; i++ {
		fmt.Scan(&arrY[i])
	}
	root := createLL(arrY, no)
	modLst := removNth(root, n)
	printLL(modLst)
}
