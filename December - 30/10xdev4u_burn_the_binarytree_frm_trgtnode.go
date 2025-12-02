package main

import (
	"fmt"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildParentMap(root *TreeNode, target int) (map[*TreeNode]*TreeNode, *TreeNode) {
	parentMap := make(map[*TreeNode]*TreeNode)
	var targetNode *TreeNode

	if root == nil {
		return parentMap, nil
	}

	queue := []*TreeNode{root}
	parentMap[root] = nil

	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if node.Val == target {
			targetNode = node
		}

		if node.Left != nil {
			parentMap[node.Left] = node
			queue = append(queue, node.Left)
		}

		if node.Right != nil {
			parentMap[node.Right] = node
			queue = append(queue, node.Right)
		}
	}

	return parentMap, targetNode
}

func burnTree(root *TreeNode, target int) [][]int {
	parentMap, targetNode := buildParentMap(root, target)

	if targetNode == nil {
		return [][]int{}
	}

	visited := make(map[*TreeNode]bool)
	queue := []*TreeNode{targetNode}
	visited[targetNode] = true

	result := [][]int{}

	for len(queue) > 0 {
		levelSize := len(queue)
		currentLevel := []int{}

		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]

			currentLevel = append(currentLevel, node.Val)

			if node.Left != nil && !visited[node.Left] {
				visited[node.Left] = true
				queue = append(queue, node.Left)
			}

			if node.Right != nil && !visited[node.Right] {
				visited[node.Right] = true
				queue = append(queue, node.Right)
			}

			if parent := parentMap[node]; parent != nil && !visited[parent] {
				visited[parent] = true
				queue = append(queue, parent)
			}
		}
		result = append(result, currentLevel)
	}

	return result
}

func buildTreeFromLevelOrder(values []int) *TreeNode {
	if len(values) == 0 || values[0] == -1 {
		return nil
	}

	root := &TreeNode{Val: values[0]}
	queue := []*TreeNode{root}
	i := 1

	for len(queue) > 0 && i < len(values) {
		node := queue[0]
		queue = queue[1:]

		if i < len(values) {
			if values[i] != -1 {
				node.Left = &TreeNode{Val: values[i]}
				queue = append(queue, node.Left)
			}
			i++
		}

		if i < len(values) {
			if values[i] != -1 {
				node.Right = &TreeNode{Val: values[i]}
				queue = append(queue, node.Right)
			}
			i++
		}
	}
	return root
}

func main() {
	// Solution for Day 30: burn_binary_tree
	var n int
	fmt.Scan(&n)

	if n == 0 {
		return
	}

	values := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&values[i])
	}

	var target int
	fmt.Scan(&target)

	root := buildTreeFromLevelOrder(values)
	result := burnTree(root, target)

	for _, level := range result {
		parts := make([]string, len(level))
		for i, val := range level {
			parts[i] = fmt.Sprintf("%d", val)
		}
		fmt.Println(strings.Join(parts, ", "))
	}
}
