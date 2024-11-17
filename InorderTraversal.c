#include <stdio.h>
#include <stdlib.h>

// Define the structure for a tree node
struct TreeNode {
    int data;
    struct TreeNode* left;
    struct TreeNode* right;
};

// Define the structure for a stack node
struct StackNode {
    struct TreeNode* treeNode;
    struct StackNode* next;
};

// Function to create a new tree node
struct TreeNode* createNode(int data) {
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Stack operations
struct StackNode* createStackNode(struct TreeNode* treeNode) {
    struct StackNode* stackNode = (struct StackNode*)malloc(sizeof(struct StackNode));
    stackNode->treeNode = treeNode;
    stackNode->next = NULL;
    return stackNode;
}

void push(struct StackNode** top, struct TreeNode* treeNode) {
    struct StackNode* stackNode = createStackNode(treeNode);
    stackNode->next = *top;
    *top = stackNode;
}

struct TreeNode* pop(struct StackNode** top) {
    if (*top == NULL)
        return NULL;
    struct StackNode* temp = *top;
    *top = (*top)->next;
    struct TreeNode* popped = temp->treeNode;
    free(temp);
    return popped;
}

int isEmpty(struct StackNode* top) {
    return top == NULL;
}

// Iterative inorder traversal
void inorderTraversalIterative(struct TreeNode* root) {
    struct StackNode* stack = NULL;
    struct TreeNode* current = root;

    while (current != NULL || !isEmpty(stack)) {
        // Reach the leftmost node of the current node
        while (current != NULL) {
            push(&stack, current);
            current = current->left;
        }

        // Process the top node
        current = pop(&stack);
        printf("%d ", current->data);

        // Move to the right subtree
        current = current->right;
    }
}

int main() {
    // Create the binary tree
    struct TreeNode* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);

    // Perform iterative inorder traversal
    printf("Inorder Traversal (Iterative): ");
    inorderTraversalIterative(root);
    printf("\n");

    return 0;
}
