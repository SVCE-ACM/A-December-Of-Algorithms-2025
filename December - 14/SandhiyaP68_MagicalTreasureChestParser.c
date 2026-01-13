#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

struct node {
    int is_int;                 // 1 = integer, 0 = list
    int value;                  // valid only if is_int = 1
    struct node **list;         // array of pointers
    int size;                   // number of elements in list
    int capacity;               // capacity for dynamic growth
};

struct node* new_int(int val) {
    struct node* n = (struct node*)malloc(sizeof(struct node));
    n->is_int = 1;
    n->value = val;
    n->list = NULL;
    n->size = 0;
    n->capacity = 0;
    return n;
}

struct node* new_list() {
    struct node* n = (struct node*)malloc(sizeof(struct node));
    n->is_int = 0;
    n->value = 0;
    n->size = 0;
    n->capacity = 4;
    n->list = (struct node**)malloc(sizeof(struct node*) * n->capacity);
    return n;
}

void add_to_list(struct node* list, struct node* element) {
    if (list->size == list->capacity) {
        list->capacity *= 2;
        list->list = (struct node**)realloc(list->list, sizeof(struct node*) * list->capacity);
    }
    list->list[list->size++] = element;
}

void print_node(struct node* n) {
    if (n->is_int) {
        printf("%d", n->value);
        return;
    }

    printf("[");
    for (int i = 0; i < n->size; i++) {
        print_node(n->list[i]);
        if (i < n->size - 1)
            printf(",");
    }
    printf("]");
}

int main() {
    char s[50005];
    printf("enter the treasure string: ");
    scanf("%s", s);

    struct node* stack[50000];
    int top = -1;

    int i = 0;
    int n = strlen(s);

    while (i < n) {
        if (s[i] == '[') {
            stack[++top] = new_list();
            i++;
        }
        else if (s[i] == ']') {
            struct node* finished = stack[top--];

            if (top >= 0) {
                add_to_list(stack[top], finished);
            } else {
                print_node(finished);
                return 0;
            }
            i++;
        }
        else if (isdigit(s[i]) || s[i] == '-') {
            int sign = 1;
            if (s[i] == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            while (i < n && isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
                i++;
            }
            num *= sign;

            struct node* newnum = new_int(num);

            if (top >= 0) {
                add_to_list(stack[top], newnum);
            } else {
                print_node(newnum);
                return 0;
            }
        }
        else {
            i++;
        }
    }

    return 0;
}
