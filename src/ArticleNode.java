/*

It takes information from the articleData and makes a linked list

*/

class ArticleNode {
    int id;
    String title;
    String author;
    ArticleNode next;

    //Overloaded constructor
    ArticleNode(int i, String t, String a, ArticleNode r){
        id = i;
        title = t;
        author = a;
        next = r;
    }
}