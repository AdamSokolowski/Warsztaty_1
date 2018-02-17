package graWZgadywanieLiczb;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
    	Random r = new Random();
    	int NumberTyped = 0;
        int NumberToFind = r.nextInt(100)+1;
        // System.out.println("Wylosowana liczba to:" +NumberToFind);
        NumberTyped = typeInNumber();
        	while (NumberToFind != NumberTyped) {
        		if (NumberToFind > NumberTyped) {
        			System.out.println("Za mało!");
        			NumberTyped = typeInNumber();
        		} else {  //NumberToFind < NumberTyped
        			System.out.println("Za dużo!");
        			NumberTyped = typeInNumber();
        		}
        	}
        	System.out.println("Zgadłeś!");
        
    }
    static int typeInNumber() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Zgadnij liczbę:");
    	while (!scan.hasNextInt()) {
    		scan.next();
    		System.out.print("Podana fraza nie jest liczbą całkowitą");    		
    	}
    	
    	return scan.nextInt();
    }
}