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
      "id": "591bc706-4613-4a43-aafa-e05aeb315b52",
      "cell_type": "code",
      "source": "def find_subarray_with_sum(arr, K):\n    prefix_sum = 0\n    seen = {0: -1}\n\n    for i in range(len(arr)):\n        prefix_sum += arr[i]\n        if prefix_sum - K in seen:\n            return seen[prefix_sum - K] + 1, i\n        seen[prefix_sum] = i\n\n    return -1, -1\n\n\n# Input\nN, K = map(int, input().split())\narr = list(map(int, input().split()))\n\nstart, end = find_subarray_with_sum(arr, K)\nprint(start, end)\n",
      "metadata": {
        "trusted": true
      },
      "outputs": [
        {
          "output_type": "stream",
          "name": "stdin",
          "text": " 7 15\n 1 2 3 7 5 1 2\n"
        },
        {
          "name": "stdout",
          "output_type": "stream",
          "text": "2 4\n"
        }
      ],
      "execution_count": 8
    },
    {
      "id": "03420b7a-e40a-4940-b908-a799bfe967b0",
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