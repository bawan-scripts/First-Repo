package SES3;

import java.util.Scanner;

public class Insertion {

    static Scanner sc = new Scanner(System.in);
    static int validSize;

    public static void main(String[] args) {

        // char[] letters = {'a','b','c'}; refrain from doing this if you want to
        // perform insertion to array
        int size, pos;
        do {
            System.out.print("Please enter size of the array: ");
            size = sc.nextInt();
        } while (size <= 0);

        char[] letters = new char[size];

        do {
            System.out.print("Please enter the total # of valid items: ");
            validSize = sc.nextInt();
        } while (validSize <= 0 || validSize >= size);

        // i need to put the items in array
        populateArray(letters);
        displayArray(letters);

        // System.out.print("Please enter the new character to be added at the
        // beginning: ");
        // System.out.print("Please enter the new character to be added at the End: ");
        System.out.print("Please enter the new character to be added at a position: ");
        char newChar = sc.next().charAt(0);

        do {
            System.out.print("Please enter a position to add the value at: ");
            pos = sc.nextInt();
        } while (pos <0 || pos > validSize);

        // InsertAtBeginning(letters, newChar);
        // insertAtEnd(letters, newChar);
        insertAtPosition(letters, newChar, pos);
        displayArray(letters);

    }

    public static void populateArray(char[] letters) {
        // i need to fill the array with elements
        for (int count = 0; count < validSize; count++) {
            System.out.print("Enter character " + (count + 1) + ": ");
            letters[count] = sc.next().charAt(0);
        }
    }

    public static void displayArray(char[] letters) {
        System.out.println("==================================");
        // i need to display the array with its elements
        for (int count = 0; count < validSize; count++) {
            System.out.println("Character " + (count + 1) + ": " + letters[count]);
        }
        System.out.println("==================================");

    }

    public static void InsertAtBeginning(char[] letters, char newVal) {
        if (validSize == letters.length) {
            System.out.println("Array is full");
        } else {
            // shifting the array elements to make space at the beginning is a loop
            for (int count = validSize - 1; count >= 0; count--) {
                // copy the value at count and put it in count+1
                letters[count + 1] = letters[count];
            }

            // after i am done shifting
            letters[0] = newVal;
            // update validSize and add one more to it
            validSize++;
        }
    }

    public static void insertAtEnd(char[] letters, char newVal) {
        letters[validSize] = newVal;
        validSize++;
    }

    public static void insertAtPosition(char[] letters, char newVal, int position) {
        // shift forward and looping backward, start from validSize -1 up to and
        // including position
        for (int count = validSize - 1; count >= position; count--) {
            letters[count + 1] = letters[count];
        }

        // after the loop finishes, insert the new value at the chosen position
        letters[position] = newVal;
        validSize++;

    }

}