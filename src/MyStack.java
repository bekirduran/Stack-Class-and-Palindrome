/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bekirduran
 */
public class MyStack {
    
    private char[] myCharArray;
    private int stackSize;
    private int stackCurrentIndex = 0;

    public MyStack (int size) {
        this.stackSize = size;
        myCharArray = new char[size];
    }

    //Get current index
    public int size() {
        return stackCurrentIndex;
    }
    
    
    // Checking is Empty
    public boolean isEmpty() {
        if (stackCurrentIndex == 0) {
            return true;
        }
        return false;
    }

    //Cheking is Full
    public boolean isFull() {
        if (stackCurrentIndex == stackSize) {
            return true;
        }
        return false;
    }
    
    
    // Checking is Full and Adding character to MyStack
    public void push(char element) {

        if (isFull()) {
            return;
        }

        myCharArray[stackCurrentIndex] = element;
        stackCurrentIndex++;
    }

    // Checking is Empty and Removing character to MyStack
    public char pop() {
        if (isEmpty()) {
            return '!';
        }
        return myCharArray[--stackCurrentIndex];
    }

    //Displaying all of Array
    public String display(){
        String displayingText="";
        for(int i=0;i<size();i++){
            displayingText+=myCharArray[i];
        }
        return displayingText;
    }
    
    //Cheking is Palindrome
    public boolean isPalindrome(String myWord){
        int i = myWord.length()-1;
        int j=0;
        while(i > j) {
            if(myWord.charAt(i) != myWord.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

}
