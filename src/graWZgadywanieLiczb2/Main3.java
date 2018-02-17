package graWZgadywanieLiczb2;

import java.util.Random;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        int min = 0;
        int max = 1000;
        int valTyped = 0;
        int valGuessed = 0;
        String takNie;
              
        System.out.println("Pomy�l liczb� od 0 do 1000, a ja j� zgadn� w max.10 pr�bach.");
        valGuessed = guess(min,max);
        System.out.println("Zgaduj�: "+valGuessed);
        System.out.println("Zgad�em?");
        takNie = typeInTakNie();
        while (takNie.compareTo("tak")!=0) {
        	System.out.println("Za du�o?");
        	if (typeInTakNie().compareTo("tak")==0) {
        		max = guess(min, max);
        	} else {
        		System.out.println("Za ma�o?");
        		if (typeInTakNie().compareTo("tak")==0) {
        			min = guess(min,max);
        		} else
        			System.out.println("nie oszukuj!");
        	}
        }
        	
        
        
    }
    
    static int guess(int min, int max) {
    	return ((max-min)/2) + min;
    }
    static String typeInTakNie() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Zgad�em?");
    	while (!scan.hasNext("tak") && !scan.hasNext("nie")) {
    		scan.next();
    		System.out.print("Wpisz nie lub tak.");    		
    	}
    	
    	return scan.next();
    }
}