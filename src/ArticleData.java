/*
Article information is stored in this file.
 */
import java.util.*;
class ArticleData {
    int id;
    String title;
    String author;
    ArrayList<String> keywords;

    //Overloaded constructor
    ArticleData(int id, String title, String author, int keywordCount){
        this.id = id;
        this.title = title;
        this.author = author;
        keywords = new ArrayList<>(keywordCount);
    }

    //ArrayList of corresponding keywords
    void addKeyword(String keyword) {
        keywords.add(keyword);
    }
}