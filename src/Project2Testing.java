/*

This is the testing file for Binary Search Tree. It opens the data file and parses information into ArticleData.java
file. It also does error handling while opening the file and performs various test cases to ensure the performance and
accuracy.

*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Project 2 testing class
public class Project2Testing{

    //Opens and parses the data file into ArticleData.java
    static class BSTDataMining{
        //BST call
        BinarySearchTree bst = new BinarySearchTree();

        //Opens the file while taking name as the parameter
        public void fileData(String fileName){

            //ArticleData call
            ArticleData articleData;

            //try and catch block to safely open the file; throws an exception if file not found or empty
            try{
                //Buffer reader reads the entire file until the file reaches end
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

                //do while loop
                do{
                    //article id
                    int titleID = Integer.parseInt(bufferedReader.readLine());

                    //article title
                    String titleOfTheArticle = bufferedReader.readLine();

                    //article author
                    String author = bufferedReader.readLine();

                    //list of all the keywords by which the article can be searched
                    int numberOfKeywords = Integer.parseInt(bufferedReader.readLine());

                    //Adds article data to the Article Object
                    articleData = new ArticleData(titleID, titleOfTheArticle, author, numberOfKeywords);

                    //Adds all the keywords pertaining to the single article into an arraylist
                    for(int i = 0; i < numberOfKeywords; i++){
                        articleData.addKeyword(bufferedReader.readLine());
                    }

                    //Finally, adds the article to BST
                    bst.addArticle(articleData);

                }
                while(bufferedReader.readLine() != null);

                //closes buffer reader after the reading the file
                bufferedReader.close();
            }
            //Exceptions
            catch (FileNotFoundException e) {
                System.out.println("File Not Found!");
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }//end file data

    }//end BST mining


    //Main methods and some test cases
    public static void main(String[] args){

        //BSTDataMining call
        BSTDataMining bstDataMining = new BSTDataMining();
        bstDataMining.fileData("src/datafile.txt");

        //prints the whole tree
        bstDataMining.bst.print();
        System.out.println();

        /*********************** prints by keyword ********************/

        System.out.println("************************* Printing By KeyWords *****************************************");

        ArrayList<String> testVal = new ArrayList<>(6);
        //11 results
        testVal.add("database");

        //4 results
        testVal.add("concepts");

        //1 result
        testVal.add("weighting");

        //2 results
        testVal.add("recognition");

        //1 result
        testVal.add("information-retrieval");

        //0 result
        testVal.add("concept");

        for(String val : testVal){
            System.out.println("\"" + val + "\" result(s):");
            bstDataMining.bst.getRecords(val);
            System.out.println();
        }

        /********** deletes by keyword and checks afterwards if the node is present********/


        System.out.println("************************* Deleting By KeyWords *****************************************");

        for(String deletedVal : testVal){
            System.out.println("\"" + deletedVal + "\" result(s):");
            boolean b = (bstDataMining.bst.delete(deletedVal));
            if(!b){
                System.out.println("Deletion Unsuccessful!");
            }
            System.out.println();
        }

        //bstDataMining.bst.print();

    }


}