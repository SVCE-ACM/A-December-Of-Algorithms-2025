#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

typedef struct NestedChest {
    int isInteger;
    int value;
    struct NestedChest **list;
    int size;
    int capacity;
} NestedChest;

NestedChest* createInteger(int val) {
    NestedChest* node = (NestedChest*)malloc(sizeof(NestedChest));
    node->isInteger = 1;
    node->value = val;
    node->list = NULL;
    node->size = 0;
    node->capacity = 0;
    return node;
}

NestedChest* createList() {
    NestedChest* node = (NestedChest*)malloc(sizeof(NestedChest));
    node->isInteger = 0;
    node->list = NULL;
    node->size = 0;
    node->capacity = 0;
    return node;
}

void addToList(NestedChest* listNode, NestedChest* element) {
    if (listNode->capacity == 0) {
        listNode->capacity = 4;
        listNode->list = (NestedChest**)malloc(listNode->capacity * sizeof(NestedChest*));
    } else if (listNode->size == listNode->capacity) {
        listNode->capacity *= 2;
        listNode->list = (NestedChest**)realloc(listNode->list, listNode->capacity * sizeof(NestedChest*));
    }
    listNode->list[listNode->size++] = element;
}

NestedChest* parseChest(char* s) {
    int n = strlen(s);
    NestedChest* stack[50000];
    int top = -1;
    NestedChest* current = NULL;
    int i = 0;

    while (i < n) {
        if (s[i] == '[') {
            NestedChest* newList = createList();
            if (top >= 0) addToList(stack[top], newList);
            stack[++top] = newList;
            i++;
        } else if (s[i] == ']') {
            current = stack[top--];
            i++;
        } else if (s[i] == ',') {
            i++;
        } else {
            int sign = 1;
            if (s[i] == '-') { sign = -1; i++; }
            int num = 0;
            while (i < n && isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
                i++;
            }
            num *= sign;
            NestedChest* node = createInteger(num);
            if (top >= 0) addToList(stack[top], node);
            else current = node;
        }
    }
    return current;
}

void printChest(NestedChest* chest) {
    if (!chest) return;
    if (chest->isInteger) {
        printf("%d", chest->value);
    } else {
        printf("[");
        for (int i = 0; i < chest->size; i++) {
            printChest(chest->list[i]);
            if (i < chest->size - 1) printf(",");
        }
        printf("]");
    }
}

int main() {
    char s[50001];
    scanf("%s", s);
    NestedChest* chest = parseChest(s);
    printChest(chest);
    return 0;
}
