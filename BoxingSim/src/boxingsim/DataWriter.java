/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darrenreifler
 */


public class DataWriter {
    private static final String BoxerOUT = "boxerOut.txt";
    
    public void WriteBoxers(List<Boxer> boxerList) {
        StringBuilder line = new StringBuilder(40);
        Boxer boxer;
        try(
            BufferedWriter bw = 
                    Files.newBufferedWriter(Paths.get(BoxerOUT))) { 
            //add search function to check for duplicate names
            
            //Create header for Fighter list
            bw.write(String.format("%-10s%-10s%-4s%-4s%-4s", "Name","Style", "Str",
                "Spd","Agl"));
            bw.newLine();
            
            for(int i = 0; i < boxerList.size();i++){
                bw.flush();
                boxer = boxerList.get(i);
                line.append(String.format("%-10s", boxer.name));
                line.append(String.format("%-10s", boxer.style));
                line.append(String.format("%-4s", boxer.GetStr()));
                line.append(String.format("%-4s", boxer.GetSpd()));
                line.append(String.format("%-4s", boxer.GetAgl()));
                bw.write(line.toString());
                bw.newLine();
                line.delete(0,50);
            }
        } catch (IOException ex) {
            Logger.getLogger(BoxingSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
