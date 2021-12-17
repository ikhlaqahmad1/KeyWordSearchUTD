/*
This class is the full implementation of the BST.
 */
class BinarySearchTree {

    //Tree Node variable
    TreeNode root;

    //Adds ArticleData to ArticleNode by Keywords
    public void addArticle(ArticleData article) {

        for (String key:article.keywords) {
            ArticleNode newArticleNode = new ArticleNode(article.id, article.title, article.author, null);

            //Adds a node to the tree if key == "not found"
            boolean inserted = insertTreeNode(key, newArticleNode);

            //Adds a node to the Article Node if Tree node is present
            if (!inserted) {
                appendArticleNode(key, newArticleNode);
            }
        }
    }

    //Adds the article to list of corresponding keywords if the keyword node is present in the tree
    public void appendArticleNode(String keyword, ArticleNode newArticleNode) {
        //Tree Root
        TreeNode current = root;

        while (current != null) {
            if (keyword.compareTo(current.keyword) < 0) {
                current = current.leftChild;
            }
            else if (keyword.compareTo(current.keyword) > 0) {
                current = current.rightChild;
            }
            else {
                newArticleNode.next = current.head;
                current.head = newArticleNode;
                return;
            }
        }
    }

    //Adds a node in the tree by keywords
    public boolean insertTreeNode(String keyword, ArticleNode newArticleNode) {

        //if root is empty
        if (root == null) {
            root = new TreeNode(keyword, newArticleNode);
            return true;
        }
        else {
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if (keyword.compareTo(current.keyword) < 0) {
                    parent = current;
                    current = current.leftChild;
                }
                else if (keyword.compareTo(current.keyword) > 0) {
                    parent = current;
                    current = current.rightChild;
                }
                else {
                    return false;
                }
            }
            if (keyword.compareTo(parent.keyword) < 0) {
                parent.leftChild = new TreeNode(keyword, newArticleNode);
            }
            else if (keyword.compareTo(parent.keyword) > 0) {
                parent.rightChild = new TreeNode(keyword, newArticleNode);
            }
        }
        return true;
    }

    //prints the whole tree in ascending order
    public void print() {
        System.out.println("\n ********************** Recursive Print *****************************************\n");
        inOrderPrint(root);
    }


    //prints the tree elements recursively
    private void inOrderPrint(TreeNode node) {

        if (node == null){
            return;
        }
        inOrderPrint(node.leftChild);
        System.out.printf("\n%s\n", node.keyword);
        ArticleNode article = node.head;
        while (article != null) {
            System.out.printf("\t %d | %s | %s-->\n", article.id, article.title, article.author);
            article = article.next;
        }
        inOrderPrint(node.rightChild);
    }//end inOrder

    //Searches the records by the keyword
    public void getRecords(String keyword){
        String result;
        if(root == null){
            result = "No record(s) found";
            System.out.println(result);
        }
        else{
            TreeNode current = root;
            while(current != null) {
                if (keyword.compareTo(current.keyword) < 0) {
                    current = current.leftChild;
                }
                else if (keyword.compareTo(current.keyword) > 0) {
                    current = current.rightChild;
                }
                else if(keyword.compareTo(current.keyword) == 0){

                    ArticleNode article = current.head;
                    while (article != null) {
                        System.out.printf("\t %d | %s | %s-->\n", article.id, article.title, article.author);
                        article = article.next;

                    }
                    break;
                }

            }
        }
    }//end records


    //Deletes a particular Node (Optional Credit)
    public boolean delete(String keyWord) {

        //sets initial value for parent and current
        TreeNode parent = root;
        TreeNode current = root;

        //If root is empty (No data)
        if(root == null){
            return false;
        }

        //if keyword belongs to root
        if(keyWord.compareTo(root.keyword) == 0){
            current = root.rightChild;
            current.leftChild = root.leftChild;
            root = current;
            return true;
        }

        //find the keyword
        while (current != null) {

            //if keyword is less than current keyword
            if (keyWord.compareTo(current.keyword) < 0) {
                parent = current;
                current = current.leftChild;
            }

            //if the keyword is greater than current keyword
            else if (keyWord.compareTo(current.keyword) > 0) {
                parent = current;
                current = current.rightChild;
            }

            //if keyword is found
            else if(keyWord.compareTo(current.keyword) == 0){

                //if the node doesn't have any children
                if((current.leftChild == null) && (current.rightChild == null)){

                    //deletes the node on left
                    if(keyWord.compareTo(parent.keyword) < 0){
                        parent.leftChild = null;
                        return true;
                    }

                    //deletes the node on right
                    else if(keyWord.compareTo(parent.keyword) > 0){
                        parent.rightChild = null;
                        return true;
                    }
                }

                //if the current node doesn't have a left child
                else if(current.leftChild == null){

                    if(keyWord.compareTo(parent.keyword) < 0){
                        parent.leftChild = current.rightChild;
                        return true;
                    }

                    //deletes the node on right
                    else if(keyWord.compareTo(parent.keyword) > 0){
                        parent.rightChild = current.rightChild;
                        return true;
                    }

                }

                //if the current node doesn't have a right child
                else if(current.rightChild == null){

                    if(keyWord.compareTo(parent.keyword) < 0){
                        parent.leftChild = current.leftChild;
                        return true;
                    }

                    //deletes the node on right
                    else if(keyWord.compareTo(parent.keyword) > 0){
                        parent.rightChild = current.leftChild;
                        return true;
                    }
                }

                // if the current node has both children
                else {

                    //saves left child of the current node
                    TreeNode brokenNode = current.leftChild;


                    //if keyword is less than parents
                    if(keyWord.compareTo(parent.keyword) < 0){

                        parent.leftChild = current.rightChild;
                        current.leftChild = null;
                        insertTreeNode(keyWord, brokenNode.head);
                        return true;
                    }

                    //if keyword is greater than parents
                    else if(keyWord.compareTo(parent.keyword) > 0){
                        parent.rightChild = current.rightChild;
                        current.leftChild = null;
                        insertTreeNode(keyWord, brokenNode.head);
                        return true;
                    }

                    //False for everything else
                    else{
                        return false;
                    }

                }
            }
        }
        //clears memory
        System.gc();

        return true; // Element deleted successfully
    }
}//end BST

