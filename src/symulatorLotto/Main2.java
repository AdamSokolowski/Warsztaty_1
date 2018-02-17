package symulatorLotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
    	Random r = new Random();
    	int numberTyped = 0;
    	int[] arrayNumberTyped = new int[6];
    	int[] arrayNumbersUnpicked = new int[49];
    	int[] arrayNumbersPicked = new int[6];
        boolean alreadyTyped = false;
        boolean outOfRange = false;
        int randomNumber;
        int pickedWinningNumbersCount = 0;

        System.out.println("Podaj liczbê nr 1 z zakresu 1-49:");
        numberTyped = typeInNumber();
        while(!valueIsInRange(1,49,numberTyped)) {
        	System.out.println("Podano liczbê spoza zakresu 1-49. Podaj liczbê nr 1 z zakresu 1-49:");
        	numberTyped = typeInNumber();
        }
        arrayNumberTyped[0]=numberTyped;
        
        for (int i = 1; i<6; i++) {
        	System.out.println("Podaj liczbê nr "+ (i+1) +" z zakresu 1-49:");
            numberTyped = typeInNumber();
            alreadyTyped = foundInArray(arrayNumberTyped, i, numberTyped);
            outOfRange = !valueIsInRange(1,49,numberTyped);
            while( outOfRange || alreadyTyped) {
            	if (outOfRange) {
            		System.out.println("Podano wartoœæ spoza zakresu 1-49. Podaj liczbê nr "+ (i+1) +" z zakresu 1-49:");
            	} else {
            		System.out.println("Podana liczba ju¿ by³a przez ciebie wybierana. Podaj inn¹ liczbê z zakresu 1-49:");
            	}
            	numberTyped = typeInNumber();
                alreadyTyped = foundInArray(arrayNumberTyped, i, numberTyped);
                outOfRange = !valueIsInRange(1,49,numberTyped);
            }
            arrayNumberTyped[i] = numberTyped;
        }
        
        Arrays.sort(arrayNumberTyped);
        
        System.out.println("Wybrane przez ciebie liczby to: ");
        for (int i = 0; i<arrayNumberTyped.length-1; i++ ) {
        	System.out.print(arrayNumberTyped[i]+ ", ");
        }
        	System.out.println(arrayNumberTyped[arrayNumberTyped.length-1]);
        
        for (int i = 0; i<arrayNumbersUnpicked.length; i++) {
        	arrayNumbersUnpicked[i] = i+1;
        }
        for (int i = 0; i<arrayNumbersPicked.length; i++) {
        	randomNumber = r.nextInt(49-i);
        	arrayNumbersPicked[i] = arrayNumbersUnpicked[randomNumber];
        	arrayNumbersUnpicked[randomNumber] = arrayNumbersUnpicked[49-i-1];
        }
        System.out.println("Wylosowane liczby to: ");
        for (int i = 0; i<arrayNumbersPicked.length-1; i++ ) {
        	System.out.print(arrayNumbersPicked[i]+ ", ");
        }
        	System.out.println(arrayNumbersPicked[arrayNumbersPicked.length-1]);
        	
        	
        	
        	
        for (int i = 0; i<arrayNumberTyped.length; i++) {
        	if (foundInArray(arrayNumbersPicked, arrayNumbersPicked.length, arrayNumberTyped[i])) {
        		pickedWinningNumbersCount++;
        	}
        }
        if (pickedWinningNumbersCount > 4) {
        	System.out.println("Gratulacje! Wytypowa³eœ " +pickedWinningNumbersCount+" wylosowanych liczby!");
        } else {
        	if (pickedWinningNumbersCount > 2) {
            	System.out.println("Gratulacje! Wytypowa³eœ " +pickedWinningNumbersCount+" wylosowane liczby!");        		
        	}
        }
        
        
        
    

        
    }
    

    
    static boolean foundInArray(int[] arrayInt, int arrayLength, int val) {
    	boolean b = false;
    	for (int i = 0; i<arrayLength;i++) {
    		if (arrayInt[i]==val) {
    			b = true;
    			break;
    		}
    	}
    	return b;
    }
    
    static boolean valueIsInRange(int min, int max, int val) {
    	if((val > min-1) && (val <max+1)) {
    		return true;
    	} else {
    		return false;
    	}
    		
    }
    
    static int typeInNumber() {
    	Scanner scan = new Scanner(System.in);
    	while (!scan.hasNextInt()) {
    		scan.next();
    		System.out.println("Podana fraza nie jest liczbÄ… caÅ‚kowitÄ…Podaj liczbê ca³kowit¹ z zakresu 1-49:");    		
    	}
    	
    	return scan.nextInt();
    }
}