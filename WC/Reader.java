import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Write a description of class Reader here.
 * 
 * @author Saahil Rastogi 
 * @version 3/23/16
 */
public class Reader
{
    public static void main(String[] args)
    {
       try{
            File inputFile = new File("PrettyWoman.txt");
            Scanner in = new Scanner (inputFile);
       
            int characters  =  0;
            int wordCount= 0;
            int lines = 0;
            while ( in.hasNext())
            {
              wordCount++;
              
            }
            System.out.println(wordCount);
            
        }
       catch ( FileNotFoundException exception)
       {    
           System.out.println(" The file is not found");
       }
       
    }
}
