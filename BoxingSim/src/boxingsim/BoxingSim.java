/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.IOException;
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
    public static void main(String[] args) throws IOException{
        //Boxer creation from data file
        DataReader dr = new DataReader();
        DataWriter dw = new DataWriter();
        
        boolean created = dw.CheckBoxers(dw.getBoxerOUT());
        if(!created) {
            List<Boxer> boxerList;
            boxerList = dr.CreateBoxers();
            //add log that fighter creation was skipped
        
        //add method to datawriter to append an existing file--use FileWriter(file, true)
        
        //write data to files both for output(visible stats) and storage(all stats)
        dw.WriteBoxers(boxerList);
        }
    }
    
}
