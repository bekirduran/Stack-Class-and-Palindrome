/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author bekirduran
 */
public class PalindromeMaker {
        
    // Reading File    
    public static String ReadFile(String fileName){
        String data="" ;
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            
        while(myReader.hasNextLine())
            {
                data += myReader.nextLine()+"\n"; 
                
            }
        myReader.close();
        
    } catch (FileNotFoundException error) {
      System.out.println(error + "Error! when reading file");
      error.printStackTrace();
    }
        
        return data.toLowerCase() ;
    }
    
    
    
    public static void main(String [] args) throws FileNotFoundException{
        
        // Define textfile output 
        MyStack myStack=new MyStack(10000);
        PrintStream outPut = new PrintStream(new File("palindromeOutput.txt"));
        
        // Define textfile path
        String palindromeFile = ReadFile("/Users/bekirduran/Desktop/palindromes.txt");
        String[] sentence = palindromeFile.split("\n");
        
        char[] myCharArray;
        for(int i=0;i<sentence.length;i++){
            
            myCharArray = sentence[i].toCharArray();
            
            for(int j=0;j<myCharArray.length;j++){
                
                if(Character.isLetter(myCharArray[j])){
                    myStack.push(myCharArray[j]);
                }
            }
            
            if(myStack.isPalindrome(myStack.display())){
                outPut.println('"'+sentence[i]+'"'+" is a palindrome");
            }
            
            else{
                outPut.println('"'+sentence[i]+'"'+" is not a palindrome");
            }
            
            for(int j=0;j<myCharArray.length;j++){
                if(Character.isLetter(myCharArray[j])){
                    myStack.pop();
                }
            }
            
        }
 
    }
   
}
