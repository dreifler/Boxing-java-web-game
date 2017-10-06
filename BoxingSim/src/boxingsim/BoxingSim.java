/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author darrenreifler
 */
public class BoxingSim {

    /**
     * @param args the command line arguments
     */
    //add loggers for each main step in process
    public static void main(String[] args) throws IOException{
        //Boxer creation from data file
        DataReader dr = new DataReader();
        DataWriter dw = new DataWriter();
       
        Set<Boxer> boxerSet = new HashSet<Boxer>();
        boxerSet = dr.CreateBoxers();
        
        //add method to datawriter to append an existing file--use FileWriter(file, true)
        
        //write data to files both for output(visible stats) and storage(all stats)
        dw.WriteBoxers(boxerSet);
    }
    
}
