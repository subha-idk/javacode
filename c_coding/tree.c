#include<stdio.h>
#include<stdlib.h>


struct Node {
	int data;
	struct Node* left;
	struct Node* right;
};


// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        perror("Memory allocation failed");
        exit(EXIT_FAILURE);
    }
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function for in-order traversal of the tree
void inOrderTraversal(struct Node* root) {
    if (root == NULL) {
        return;
    }
    inOrderTraversal(root->left);
    printf("%d ", root->data);
    inOrderTraversal(root->right);
}


int main() {
    // Create the root node
    struct Node* root = createNode(1);

    // Build the tree structure
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);

    printf("In-order traversal: ");
    inOrderTraversal(root);
    printf("\n");

    // Remember to free allocated memory to prevent memory leaks
    // (This example omits explicit freeing for brevity, but it's crucial in real applications)

    return 0;
}