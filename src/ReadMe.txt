This is project 2 of CS 2336 By Ikhlaq Ahmad

*   The program is about searching the article title by keywords from a structured data file.
*   Binary Search Tree (BST) Data Structure has been utilized to perform the searching.
*   The BST has been implemented from the scratch and tested thoroughly to avoid any bugs.

Files:
    *   Project2Testing.java
        This file extracts the data and add to the ArticleData.java File. It also contains a main method which is used
        for testing delete and getRecords: It prints the corresponding record, otherwise, prints nothing

    *   ArticleData.java
        It stores the relative article information and adds keywords to an arraylist. ArrayList keeps the track of
        keyword used later in forming BST.

    *   ArticleNode.java
        It works as a linked list where if a keyword is present in more than one article, then, it simply adds that
        article information to the list associated with the keyword

    *   TreeNode.java
        Provides the building structure for the BST.

    *   BinarySearchTree.java
        This file contains all the functionality of BST. It contains necessary function for maintaining and optimizing
        the tree.

    *   datafile.txt
        Provided data set

The program prints the corresponding titles if searched by keywords. Otherwise, it prints all the titles present in
the tree in chronological order.



