/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darrenreifler
 */

public class DataWriter {
    private static final String BoxerOUT = "boxerOut.txt";
    private static final String BoxerDATA = "boxerData.txt";
    
    public void WriteBoxers(Set<Boxer> boxerSet) {
        StringBuilder line = new StringBuilder(40);
        Boxer boxer;
        Iterator it = boxerSet.iterator();
        
        //Writing boxers as viewable output for sending to GUI
        try(
            BufferedWriter bw = 
                    Files.newBufferedWriter(Paths.get(BoxerOUT))) { 
            //add search function to check for duplicate names
            
            //Create header for Fighter list
            bw.write(String.format("%-10s%-10s%-4s%-4s%-4s", "Name","Style", "Str",
                "Spd","Agl"));
            bw.newLine();
            
            while(it.hasNext()){
                boxer = (Boxer)it.next();
                line.append(String.format("%-10s", boxer.name));
                line.append(String.format("%-10s", boxer.style));
                line.append(String.format("%-4s", boxer.GetStr()));
                line.append(String.format("%-4s", boxer.GetSpd()));
                line.append(String.format("%-4s", boxer.GetAgl()));
                bw.write(line.toString());
                bw.newLine();
                line.delete(0,100);
            }
        } catch (IOException ex) {
            Logger.getLogger(BoxingSim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //writes as a data file for storing created fighters for 
         try(
            BufferedWriter bwd = 
                    Files.newBufferedWriter(Paths.get(BoxerDATA))) { 
            
            bwd.write("name;style;str;spd;agl;ftg;cnd;tgh;pwr");
            bwd.newLine();
            it = boxerSet.iterator();
            while(it.hasNext()){
                boxer = (Boxer)it.next();
                line.append(boxer.name);
                line.append(";").append(boxer.style);
                line.append(";").append(boxer.GetStr());
                line.append(";").append(boxer.GetSpd());
                line.append(";").append(boxer.GetAgl());
                line.append(";").append(boxer.GetFtg());
                line.append(";").append(boxer.GetCnd());
                line.append(";").append(boxer.GetTgh());
                line.append(";").append(boxer.GetPwr());
                bwd.append(line.toString());
                bwd.newLine();
                line.delete(0,100);
            }
        } catch (IOException ex) {
            Logger.getLogger(BoxingSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getBoxerOUT() {
        return BoxerOUT;
    }
}
