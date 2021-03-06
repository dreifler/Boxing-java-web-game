/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BoxingGame.springsecurity.sim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.BoxingGame.springsecurity.entity.Boxer;


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
            case 3: deleteBoxer();
                break;
            case 4: displayFighters();
                break;
            case 5: manualFight();
                break;
        }
    }

    }
    
    public static int printMenu(){    
        System.out.println("Enter Number to Select Option:");
        System.out.println("1: Create/Re-create fighters.");
        System.out.println("2: Add a new fighter (manual).");
        System.out.println("3: Delete a fighter.");
        System.out.println("4: Display all fighters");
        System.out.println("5: Practice fight(manual match-up).");
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
            case 1: style = Style.SLUGGER;
                    break;
            case 2: style = Style.DANCER;
                    break;
            case 3: style = Style.BALANCED;
                    break;
            default: style = Style.BALANCED;
                    break;
        } 
        System.out.println("\nCreating new fighter " + name + " with style " + style.toString() + "\n");
        
        Boxer newBoxer = new Boxer(name, style);
        if(boxerSet.add(newBoxer)){
            dw.addBoxer(newBoxer);
        }
        else
            System.out.println("Boxer already exists.");
    }
    
    public static void deleteBoxer(){
        String name;
        
        System.out.print("Enter boxer name to delete: ");
        name = scanner.nextLine();
        
        if(findBoxer(name) != null){
            boxerSet.remove(findBoxer(name));
            System.out.println("\nDeleted " + name +"\n");
        } else {
            System.out.println("\nUnable to locate boxer.\n");
        }
         
    }
    
    public static ArrayList displayFighters() {       
        Iterator it = boxerSet.iterator();
        Boxer boxer;
        StringBuilder line = new StringBuilder();
        ArrayList <String>fighters = new ArrayList<String>();
        
        line.append(String.format("%-10s%-10s%-4s%-4s%-4s", "Name","Style", "Str",
                "Spd","Agl"));
        while(it.hasNext()){
            boxer = (Boxer)it.next();
            line.append(String.format("%-10s", boxer.getName()));
            line.append(String.format("%-10s", boxer.getStyle()));
            line.append(String.format("%-4s", boxer.getStr()));
            line.append(String.format("%-4s", boxer.getSpd()));
            line.append(String.format("%-4s", boxer.getAgl()));
            fighters.add(line.toString());
            line.delete(0,100);
        }
        
        return fighters;
    }
    
    public static void manualFight(){
        IFighter b1, b2;
        ISimulation sim = new BoxingSim();
        boolean finished = false;
        int actions = 0;
        int round = 1;
        
        //Set up fight matchup
        b1 = boxerSelect(1);
        b2 = boxerSelect(2);
        sim.fightSim(b1, b2);
        
        //begin logging results in file
        dw.clearResult();
        dw.addResult("\n===================================");
        dw.addResult("Now fighting, " + sim.GetF1().getName() + " vs. " + sim.GetF2().getName());
        dw.addResult("===================================\n");
        
        while(!finished) {
            sim.GetF1().selectAction();
            sim.GetF2().selectAction(); 
        //Hardcode of aggression only to test
        //Add input of fighter strategy
            sim.GetF1().setAgg(3);
            sim.GetF2().setAgg(8);
        
        //Print fight results to file
            switch(sim.GetF1().getCurrent()){
                case PUNCH:
                    dw.addResult(actions + "..." + sim.GetF1().getName() + " landed a punch.");
                        sim.GetF1().selectAction();
                    break;
                case DEFEND:
                    dw.addResult(actions + "..." + sim.GetF1().getName() + " is defending.");
                        sim.GetF1().selectAction();
                    break;
            }
            
            switch(sim.GetF2().getCurrent()){
                case PUNCH:
                    dw.addResult(actions + "..." + sim.GetF2().getName() + " landed a punch.");
                        sim.GetF2().selectAction();
                    break;
                case DEFEND:
                    dw.addResult(actions + "..." + sim.GetF2().getName() + " is defending.");
                        sim.GetF2().selectAction();
                    break;
            }
                
            actions++;
            if(actions == 180){
                actions = 0;
                dw.addResult("----End of Round----");
                round++;
            }
            if(round == 4)
                finished = true;
        }
        System.out.println("=====Fight Simulation Complete.=====");
    }
    
    public static IFighter boxerSelect(int i){
        String name;
        IFighter temp;
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
    
    public static IFighter findBoxer(String name){
        //improve with more efficient search(binary)
        Iterator it = boxerSet.iterator();
        IFighter boxer;
        
        while(it.hasNext()) {
            boxer = (IFighter)it.next();
            if(boxer.getName().equals(name)){
                return boxer;
            }
        }
        return null;
    }
}
