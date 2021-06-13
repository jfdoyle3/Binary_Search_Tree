package com.company;

import java.util.*;

class Node {
    Node left = null;
    Node right = null;
    int data;

    public Node(int data) {

        this.data = data;
        left = right = null;
    }
}
// BST Rules
// first node is Root
// If Node exists
// Go left if value is less than node.data
// Go right if value is greater than node.data
// if value is the same do nothing

public class Main {
    public static Node addNode(Node root, int value) {
        // Instantiate a 'New Node' with data to create a Node.
        Node newNode = new Node(value);
        // Check if root is null make the new node root
        if (root == null) {
            // return New Node
            return newNode;
        }
        // If root is not null check value against current Node's data to determine which branch to travel
        Node trav = root;
        while (true) {

            // If lower
            if (value < trav.data) {
                if (trav.left != null) {
                    trav = trav.left;
                    continue;
                } else {
                    trav.left = newNode;
                    break;
                }
            }
            // If there's a current node then travel.
            // repeat line 25
            // else add Node to Current.left = New Node
            // If greater
            if (value > trav.data) {
                if (trav.right != null) {
                    trav = trav.right;
                    continue;
                } else {
                    trav.right = newNode;
                    break;
                }
            }
            // If there's a current node then travel.
            // repeat line 25
            // else add Node to Current.right= New Node
            // return root
        }
        return root;
    }

    public static int findNode(int value){
        return value;
    }

    //Add your Level order method here
    static void levelOrder(Node root) {
        // create a node queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            // if node print value
            System.out.printf("%d ", node.data);
            // if left node not null add child node to the queue
            if (node.left != null)
                queue.add(node.left);
            // if right node not null add child node to the queue
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 5, 4, 7, 2, 1));
        for (int num : nums) {
            root = addNode(root, num);
        }
        levelOrder(root);

    }
}
