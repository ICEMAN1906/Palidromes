import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
@Author: Aaron Brown
@date:9/29/2023
@Section: CSC 331-001
@purpose:create book class
*/

public class palindromes {

    public static void main(String[] args) {
        String Input = "wordList.txt";
        String output = "palindromes.txt";

        try {
            //the below code reads the file
            BufferedReader reader = new BufferedReader(new FileReader(Input));

            FileWriter writer = new FileWriter(output);  // open a file to write to

            String charicter;
            while ((charicter = reader.readLine()) != null) { //read until nothing is returned


                if (isPalindrome(charicter)) {
                    writer.write(charicter + "\n");//if palidrome append
                }
            }

            reader.close();
            writer.close();

            System.out.println("Palindromes appended: " + output);

        } catch (IOException e) {//check for error

            e.printStackTrace(); //print details of error
        }
    }








    private static boolean isPalindrome(String str) {
        // Base case: if the length is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }








        // Check if the first and last characters are equal
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            //use Recursion to check the substring without the first and last characters
            return isPalindrome(str.substring(1, str.length() - 1)); //moves towards the base case
        } else {
            return false;
        }
    }
}
