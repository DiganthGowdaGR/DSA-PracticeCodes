#include <stdio.h>
#include <stdlib.h>

// Define the structure for a tree node
struct TreeNode {
    int data;
    struct TreeNode* left;
    struct TreeNode* right;
};

// Function to create a new node
struct TreeNode* createNode(int data) {
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to calculate the height of the binary tree
int calculateHeight(struct TreeNode* root) {
    if (root == NULL)
        return -1;  // Base case: Empty tree has height -1
    // Recursively find the height of the left and right subtrees
    int leftHeight = calculateHeight(root->left);
    int rightHeight = calculateHeight(root->right);

    // Height of the current node is max(leftHeight, rightHeight) + 1
    return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
}

int main() {
    // Create the binary tree
    struct TreeNode* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right.left = createNode(6);
    root->right.right = createNode(7);

    // Calculate and print the height of the tree
    printf("Height of the Binary Tree: %d\n", calculateHeight(root));

    return 0;
}
