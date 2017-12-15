/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Set<Boxer> boxerSet = new HashSet<Boxer>();
    private static DataReader dr = new DataReader();
    private static DataWriter dw = new DataWriter();
    
    public static void main(String[] args) throws IOException{
        boolean quit = false;
    //Initial boxer creation from data file
        boxerSet = dr.CreateBoxers();
    //write data to files both for output(visible stats) and storage(all stats)
        dw.WriteBoxers(boxerSet);
        
    //Player selects option from menu to continue
        while(!quit){
            switch(printMenu()) {
            case 0: quit = true;
                break;
            case 1: boxerSet = dr.CreateBoxers();
                break;
            case 2: addBoxer();
                break;
            case 3: displayFighters();
                break;
            case 4: manualFight();
                break;
        }
    }

    }
    
    public static int printMenu(){    
        System.out.println("Enter Number to Select Option:");
        System.out.println("1: Create/Re-create fighters.");
        System.out.println("2: Add a new fighter (manual).");
        System.out.println("3: Display all fighters");
        System.out.println("4: Practice fight(manual match-up).");
        System.out.println("0: Exit");
        System.out.print("Selection: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        return choice;     
    }
    
    public static void addBoxer() {
        String name = "Default Joe";
        Style style = null;
        int choice = 0;
        
        System.out.print("Enter new boxer name: ");
        name = scanner.nextLine();
        
        System.out.print("Style(1-Slugger, 2-Dancer, 3-Balanced): ");
        choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 1: style = style.SLUGGER;
                    break;
            case 2: style = style.DANCER;
                    break;
            case 3: style = style.BALANCED;
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
    
    public static void displayFighters() {       
        Iterator it = boxerSet.iterator();
        Boxer boxer;
        StringBuilder line = new StringBuilder();
        
        System.out.println("\nCurrent Fighters:");
        System.out.println("===============================");
        System.out.println(String.format("%-10s%-10s%-4s%-4s%-4s", "Name","Style", "Str",
                "Spd","Agl"));
        while(it.hasNext()){
            boxer = (Boxer)it.next();
            line.append(String.format("%-10s", boxer.GetName()));
            line.append(String.format("%-10s", boxer.GetStyle()));
            line.append(String.format("%-4s", boxer.GetStr()));
            line.append(String.format("%-4s", boxer.GetSpd()));
            line.append(String.format("%-4s", boxer.GetAgl()));
            System.out.println(line.toString());
            line.delete(0,100);
        }
        System.out.println("===============================\n");
    }
    
    public static void manualFight(){
        Boxer b1, b2;
        ISimulation sim = new BoxingSim();
        
        b1 = boxerSelect(1);
        b2 = boxerSelect(2);

        sim.fightSim(b1, b2);
        System.out.println("\n===================================");
        System.out.println("Now fighting, " + sim.GetF1() + " vs. " + sim.GetF2());
        System.out.println("===================================\n");   
    }
    
    public static Boxer boxerSelect(int i){
        String name;
        Boxer temp;
        boolean valid = false;
        
        while(!valid){
            System.out.println("(0 to exit)Enter name of fighter " + i + ": ");
            name = scanner.nextLine();
            temp = findBoxer(name);
            if(temp != null) {
                valid = true;
                return temp;
            }
            else if(name.equals("0"))
                return null;
            else
                System.out.println("Did not locate fighter.");
        }
        return null;
    }
    
    public static Boxer findBoxer(String name){
        //improve with more efficient search(binary)
        Iterator it = boxerSet.iterator();
        Boxer boxer;
        
        while(it.hasNext()) {
            boxer = (Boxer)it.next();
            if(boxer.GetName().equals(name)){
                return boxer;
            }
        }
        return null;
    }
}
