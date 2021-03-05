package Hagay_Elihai_Exe1;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
/**
 * @author Hagay Cohen and Elihai Ben Avraham
 */
public class QuickSort {
	public static void main(String[] args) {
		int flag = 1; // flag to exit.
		Scanner inputInteger = new Scanner(System.in); // Scanner of Integer input.
		Scanner inputString = new Scanner(System.in); // Scanner of String input.
		do {
			printMenu();
			if (inputInteger.hasNextInt()) { // Checks if the input is a number.
				int num = inputInteger.nextInt(); // input num to menu.
				switch(num) {
				case 1:	
					Integer [] arrInt = {2,9,7,4,1,8,3};
					System.out.println("Before sorting:");
					printArr(arrInt);
					int length = arrInt.length; // the "length" Defined here but used in all code.
					System.out.println("...Sorting...");
					QuickSort.<Integer>qsort(arrInt ,0 , length-1);
					System.out.println("After sorting:");
					printArr(arrInt); // generic print.
					break;	
				case 2:
					String [] arrString = {"cc","ff","AA","rr","GG","WW","TT"};
					System.out.println("Before sorting:");
					printArr(arrString);
					length = arrString.length; 
					System.out.println("...Sorting...");
					QuickSort.<String>qsort(arrString ,0 , length-1);
					System.out.println("After sorting:");
					printArr(arrString);
					break;
				case 3:
					System.out.println("How many numbers would you like me to pick up?");
					if (inputInteger.hasNextInt()) {
						length = inputInteger.nextInt();
						Integer[] arrInteger = new Integer[length];
							for (int i = 0; i < length; i++) { // input strings from user
								System.out.println("enter your #" + (i + 1) + " number:");
								arrInteger[i] = inputInteger.nextInt();
								} //close for
							System.out.println("Before sorting:");
							printArr(arrInteger);
							System.out.println("...Sorting...");
							QuickSort.<Integer>qsort(arrInteger, 0, length - 1);// sorting.		
							System.out.println("After sorting:");
							printArr(arrInteger);
					}
					else {
						System.out.println("You entered wrong type.");
						inputInteger.next();// Throw in the wrong input 
					} //close else
					break;
				case 4:
					System.out.println("How many strings would you like me to pick up?");
					if (inputInteger.hasNextInt()) {
						length = inputInteger.nextInt();
						String[] arrString1 = new String[length]; // arrString1 is a new array.
							for (int i = 0; i < length; i++) { // input strings from user
								System.out.println("enter your #" + (i + 1) + " string:");
								arrString1[i] = inputString.nextLine(); // input string to arr.
							} // close for
							System.out.println("Before sorting:");
							printArr(arrString1);
							System.out.println("...Sorting...");
							QuickSort.<String>qsort(arrString1, 0, length-1);// sorting.	
							System.out.println("After sorting:");
							printArr(arrString1);
					}
					else {
						System.out.println("You entered wrong type.");
						inputInteger.next();// Throw in the wrong input 
					} // close else
					break;
				case 0: // to exit.
					flag = 0; // flag to exit from loop.
					System.out.println("...Thank you and goodbye...");
					break;	
				default: System.out.println("Wrong enter. you must enter a digit between 0-4."); // if input is wrong num.
				}
			} 
			else {
				System.out.println("You entered wrong type. please enter new number.");
				inputInteger.next();// Throw in the wrong input 
			} //close else
		} while (flag != 0);
		inputInteger.close(); // close the inputInteger scanner.
		inputString.close(); // close the inputString scanner.
	} // close main
	public static <T> void printArr(T[] object) { // generic method for print the sorted array.
		for (T obj : object) {
			System.out.print(obj + ", ");
		}
		System.out.println(); // to down line after print finish.
	}
	public static void printMenu() { // method that prints the menu.
	System.out.println("Welcome to generic quick sort,\n" +
			"Please enter your choice in number:\n" +
			"1. To sort my Integer array.\n" +
			"2. To sort my String array.\n" +
			"3. To input an Integer numbers and we sort them. \n" +
			"4. To input a Strings and we sort them.\n" +
			"0. To exit the program.");
	}
	public static <T extends Comparable<T>> void qsort(T[] arr, int start, int end) { // Recursive method that sorts the array in quick sort.
        if (start < end) { // "start" is for the first argument in the array. "end" is for the last argument in the array.
            int i = start, j = end; // "i" is a temp pointer to the first element, "j" is a temp pointer to the last element.
            T x = arr[(i + j) / 2]; // "T" for different kind of elements so we can change it according to the user's choices if needed (before compilation).
            do {
                while (arr[i].compareTo(x) < 0) i++; // Checks if the first element equals to the pivot element "x".
                while (x.compareTo(arr[j]) < 0) j--; // Checks if the last element equals to the pivot element "x"
                if (i <= j) { // Checks if there are still any elements to sort, if equal or less it means there is nothing to sort anymore.
					T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            qsort(arr, start, j); // call the method in recursion for the partition
            qsort(arr, i, end); // call the method in recursion for the first partition
        }
    }
} // close class