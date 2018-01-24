/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import boxing.entity.Boxer;

/**
 *
 * @author darrenreifler
 */

public class DataWriter {
    private static final String BoxerOUT = "boxerOut.txt";
    private static final String BoxerDATA = "boxerData.txt";
    private static final String Result = "result.txt";
    private int fightCount = 0;
    
    public void WriteBoxers(Set<Boxer> boxerSet) {
        StringBuilder line = new StringBuilder(40);
        Boxer boxer;
        Iterator it = boxerSet.iterator();
        
        //Writing boxers as formatted output
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
                line.append(String.format("%-10s", boxer.getName()));
                line.append(String.format("%-10s", boxer.getStyle()));
                line.append(String.format("%-4s", boxer.getStr()));
                line.append(String.format("%-4s", boxer.getSpd()));
                line.append(String.format("%-4s", boxer.getAgl()));
                bw.write(line.toString());
                bw.newLine();
                line.delete(0,100);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //writes as a data file for storing created fighters
         try(
            BufferedWriter bwd = 
                    Files.newBufferedWriter(Paths.get(BoxerDATA))) { 
            
            bwd.write("name;style;str;spd;agl;ftg;cnd;tgh;pwr");
            bwd.newLine();
            it = boxerSet.iterator();
            while(it.hasNext()){
                boxer = (Boxer)it.next();
                line.append(boxer.getName());
                line.append(";").append(boxer.getStyle());
                line.append(";").append(boxer.getStr());
                line.append(";").append(boxer.getSpd());
                line.append(";").append(boxer.getAgl());
                line.append(";").append(boxer.getCnd());
                bwd.append(line.toString());
                bwd.newLine();
                line.delete(0,100);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getBoxerOUT() {
        return BoxerOUT;
    }
    
    public String getResult() {
        return Result;
    }
    
    public void addBoxer(Boxer boxer) {
        StringBuilder line = new StringBuilder(40);
        
        //Writing boxers as formatted output
        try(Writer fw = new FileWriter(BoxerOUT, true)) {       
            line.append(String.format("%-10s", boxer.getName()));
            line.append(String.format("%-10s", boxer.getStyle()));
            line.append(String.format("%-4s", boxer.getStr()));
            line.append(String.format("%-4s", boxer.getSpd()));
            line.append(String.format("%-4s", boxer.getAgl()));
            fw.write(line.toString());        
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //writes as a data file for storing created fighters
       try(Writer fwd = new FileWriter(BoxerDATA, true)) { 
            line.append(boxer.getName());
            line.append(";").append(boxer.getStyle());
            line.append(";").append(boxer.getStr());
            line.append(";").append(boxer.getSpd());
            line.append(";").append(boxer.getAgl());
            line.append(";").append(boxer.getCnd());
            fwd.write(line.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
   
    public void clearResult() {
        try(BufferedWriter bw = 
                 Files.newBufferedWriter(Paths.get(Result))) { 
            bw.write("");
            }catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void addResult(String line) {
        try(Writer fwd = new FileWriter(Result, true)) { 
            fwd.write(line + "\n");
            }catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                
    }
}
