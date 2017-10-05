/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darrenreifler
 */
public class BoxingSim {

    /**
     * @param args the command line arguments
     */
    //add loggers for each main step in process
    public static void main(String[] args) throws IOException {
        //create a list of new boxers from data input file
        DataReader dr = new DataReader();
        DataWriter dw = new DataWriter();
        
        //check if boxers have been created from input file.
        //only run boxer creation if the file is empty
        boolean created = dw.CheckBoxers(dw.getBoxerOUT());
        if(!created) {
            List<Boxer> boxerList = new ArrayList<Boxer>();
            boxerList = dr.CreateBoxers();
            //add log that fighter creation was skipped
        
        //add method to datawriter to append an existing file--use FileWriter(file, true)
        
        //write output data of created fighters to file 
        dw.WriteBoxers(boxerList);
        }
    }
    
}
