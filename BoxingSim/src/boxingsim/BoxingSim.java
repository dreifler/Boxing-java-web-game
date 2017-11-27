/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

/**
 *
 * @author darrenreifler
 */
public class BoxingSim implements Simulation{

    @Override
    public void fightSim(Fighter f1, Fighter f2) {
        System.out.println("\n============================");
        System.out.println("Now fighting, " + f1.GetName() + " vs " + f2.GetName());
        System.out.println("============================\n");
    }
    
}
