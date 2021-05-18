
//comes from HackerRank: https://www.hackerrank.com/challenges/is-binary-search-tree/problem
public class IsThisABST {
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/
    boolean checkNode(Node root, int upperLimit, int lowerLimit){
        if(root.left != null){
            if(root.data < upperLimit) {upperLimit = root.data;}
            if(root.left.data > lowerLimit && root.left.data < upperLimit) {
                checkNode(root.left, upperLimit, lowerLimit);
            }else{
                return false;
            }
        }
        if(root.right != null){
            if(root.data > lowerLimit) {lowerLimit = root.data;}
            if(root.right.data > lowerLimit && root.right.data < upperLimit){
                checkNode(root.right, upperLimit, lowerLimit);
            }
        }
        if(root.left == null && root.right == null){
            return false;
        }
        return true; //temporary to avoid automatic error
    }
    boolean checkBST(Node root) {
        int upperLimit = root.data;
        int lowerLimit = 0;
        return checkNode(root, upperLimit, lowerLimit);
    }
}

