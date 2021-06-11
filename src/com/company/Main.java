package com.company;

class Node {
    Node left = null;
    Node right = null;
    int data;
    public Node(int data){
        this.data = data;
    }
}

//BST rules:
    //first node is the root.
    //if node already exists,
        //go left if value is less than node.data
        //go right is value is greater than node.data
        //if value is same, do nothing (binary search trees are unique values)

public class Main {
    public Node addNode(Node root, int value) {
        // Instantiate a 'New Node' with data to create a Node.
        Node newNode = new Node(value);

        // Check if root is null make the new node root
        if(root == null){
            // return New Node
            return newNode;

        }
        // If root is not null check value against current Node's data to determine which branch to travel
        // If lower
            // If there's a current node then travel.
                // repeat line 25
            // else add Node to Current.left = New Node
        // If greater
            // If there's a current node then travel.
                // repeat line 25
            // else add Node to Current.right= New Node
        // return root
        return root;
    }
    public static void main(String[] args) {
        Node root;
    }
}
