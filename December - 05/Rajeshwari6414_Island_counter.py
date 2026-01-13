{
  "metadata": {
    "kernelspec": {
      "name": "xpython",
      "display_name": "Python 3.13 (XPython)",
      "language": "python"
    },
    "language_info": {
      "file_extension": ".py",
      "mimetype": "text/x-python",
      "name": "python",
      "version": "3.13.1"
    }
  },
  "nbformat_minor": 5,
  "nbformat": 4,
  "cells": [
    {
      "id": "5de85149-5baf-4be8-8276-59b806693dcf",
      "cell_type": "code",
      "source": "def count_islands(grid, R, C):\n    visited = [[False]*C for _ in range(R)]\n\n    def dfs(r, c):\n        if r < 0 or r >= R or c < 0 or c >= C:\n            return\n        if grid[r][c] == 0 or visited[r][c]:\n            return\n\n        visited[r][c] = True\n        dfs(r+1, c)\n        dfs(r-1, c)\n        dfs(r, c+1)\n        dfs(r, c-1)\n\n    count = 0\n    for i in range(R):\n        for j in range(C):\n            if grid[i][j] == 1 and not visited[i][j]:\n                dfs(i, j)\n                count += 1\n    return count\n\n\n# Input\nR, C = map(int, input().split())\ngrid = [list(map(int, input().split())) for _ in range(R)]\n\nprint(count_islands(grid, R, C))\n",
      "metadata": {
        "trusted": true
      },
      "outputs": [
        {
          "output_type": "stream",
          "name": "stdin",
          "text": " 4 5\n 1 1 0 0 0\n 1 1 0 0 1\n 0 0 0 1 1\n 0 0 0 0 0\n"
        },
        {
          "name": "stdout",
          "output_type": "stream",
          "text": "2\n"
        }
      ],
      "execution_count": 2
    },
    {
      "id": "6b2f60ec-3def-4386-bd92-f24d7a845a23",
      "cell_type": "code",
      "source": "",
      "metadata": {
        "trusted": true
      },
      "outputs": [],
      "execution_count": null
    }
  ]
}