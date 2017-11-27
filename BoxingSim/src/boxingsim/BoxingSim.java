/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BoxingSim {

    private static Scanner scanner = new Scanner(System.in);
    private static Set<Boxer> boxerSet = new HashSet<Boxer>();
    private static DataReader dr = new DataReader();
    private static DataWriter dw = new DataWriter();
    
    public static void main(String[] args) throws IOException{
    //Initial boxer creation from data file
        boxerSet = dr.CreateBoxers();
    //write data to files both for output(visible stats) and storage(all stats)
        dw.WriteBoxers(boxerSet);
        
    //List of options to player to continue
        printMenu();
        

    }
    
    public static int printMenu(){    
        System.out.println("Enter Number to Select Option:");
        System.out.println("1: Create/Re-create fighters.");
        System.out.println("2: Add a new fighter (manual).");
        System.out.println("3: Practice fight(manual match-up).");
        System.out.print("Selection: ");
        
        return scanner.nextInt();
    }
    
    public static void addBoxer() {
        String name = "Default Joe";
        Style style = null;
        int choice = 0;
        
        System.out.print("Enter new boxer name: ");
        name = scanner.nextLine();
        
        System.out.print("Style: 1-Slugger, 2-Dancer, 3-Balanced");
        choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 1: style = style.SLUGGER;
                    break;
            case 2: style = style.DANCER;
                    break;
            case 3: style = style.BALANCED;
                    break;
            case 4: style = style.ROPIST;
                    break;
            default: style = style.BALANCED;
                    break;
        } 
        System.out.println("Creating new fighter " + name + " with style " + style.toString());
        
        Boxer newBoxer = new Boxer(name, style);
        if(boxerSet.add(newBoxer))
            dw.addBoxer(newBoxer);
        else
            System.out.println("Boxer already exists.");
    }
}
