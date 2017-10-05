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
        List<Boxer> boxerList = new ArrayList<Boxer>();
        boxerList = dr.CreateBoxers();
        
        //write output data of created fighters to file 
        DataWriter dw = new DataWriter();
        dw.WriteBoxers(boxerList);
    }
    
}
