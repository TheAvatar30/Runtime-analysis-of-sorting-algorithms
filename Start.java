import java.io.IOException;

import java.util.Scanner;

public abstract  class Start {

	public static void main(String[] args) throws IOException {
		GroceryList list = new GroceryList();
		
		
		System.out.println(">> Enter (c)omparisons or (t)ime");
		Scanner keyboard = new Scanner(System.in);
		String inputString = keyboard.nextLine();
		
		System.out.println(">> Enter number of repetitions to recive an average value (1 or higher)");
		Scanner keyboardInt = new Scanner(System.in);
		String inputInt = keyboardInt.nextLine();
		int input = 0;
		if(!inputInt.isEmpty()  && 47 < (int)inputInt.charAt(0) && (int)inputInt.charAt(0) < 57) {
			input = Integer.parseInt(inputInt);
		}
		
		if(inputString.equals("c") && input > 0) {		//1. Quicksort		2.Insertionsort		3.Bubblesort
		
			System.out.println("ITERATIONS"+ (char)9 +"QuickSort"+ (char)9 +"Insertionsort"+ (char)9 +"BubbleSort");
			System.out.println("-------------+---------------+----------------+-------------");
			for(int i=500;i<5000;i=i+500) {
				long[] x = list.comparisonsChart(i, input);

				System.out.println(i +""+ (char)9 + (char)9 +""+ x[0] +""+ (char)9 + (char)9 +""+ x[1] +""+ (char)9 + (char)9 +""+ x[2]);
			}
			
			
		}else if(inputString.equals("t") && input > 0) {
			System.out.println("ITERATIONS"+ (char)9 +"QuickSort (ms)"+ (char)9 + (char)9 +"Insertionsort (ms)"+ (char)9 +"BubbleSort (ms)");
			System.out.println("-------------+----------------------+------------------------+------------------");
			for(int i=500;i<5000;i=i+500) {
				long[] x = list.timeChart(i, input);
				
				System.out.println(i +""+ (char)9 + (char)9 + (char)9 +""+ x[0] +""+ (char)9 + (char)9 + (char)9 +""+ x[1] +""+ (char)9 + (char)9 + (char)9 +""+ x[2]);
			}
			//File f = new File("F:/Users/Niklas/Desktop");
			//f.createNewFile();
			
			
		}else if(inputInt.equals("") || !inputString.equals("t") && !inputString.equals("c") || input < 1){
			if(inputString.isEmpty() && inputInt.isEmpty()) {
				System.out.println("Please enter 'c' or 't'");
				System.out.println("Your number of repetitions has to be higher than '0'");
			
			}else if(inputInt.equals("")  || !inputString.equals("t") && !inputString.equals("c") && input > 0) {
				System.out.println("Please enter 'c' or 't'");
			}else if(inputString.equals("t") || inputString.equals("c") && input < 1) {
				System.out.println("Your number of repetitions has to be higher than '0'");
			}else {
				System.out.println("Please enter 'c' or 't'");
				System.out.println("Your number of repetitions has to be higher than '0'");
			}
		
		}
	}

	
}
