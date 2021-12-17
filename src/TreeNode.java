/*

This file provides the structure for BST and makes a node to the tree.
Every Node has 1, 2, or 0 child nodes depending on the data provided.
Keywords have been used to organize the data in BST.

*/
class TreeNode {
    TreeNode leftChild;
    String keyword;
    TreeNode rightChild;
    ArticleNode head;

    public TreeNode(String key, ArticleNode record){
        leftChild = null;
        keyword = key;
        rightChild = null;
        head = record;
    }
}