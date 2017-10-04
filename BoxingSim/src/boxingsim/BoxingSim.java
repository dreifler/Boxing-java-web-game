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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darrenreifler
 */
public class BoxingSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Boxer> list = new ArrayList<Boxer>();
        list = CreateBoxers();
        System.out.println(list.toString());//verification of CreateBoxers working
    }
    
    static ArrayList CreateBoxers() throws IOException {
        String name;
        String thisLine;
        String boxer[];
        BoxerStyle style;
        
        ArrayList<Boxer> boxerList = new ArrayList<Boxer>();
        
        try(
            BufferedReader br =
                    Files.newBufferedReader(Paths.get("boxerList.txt"))){
           while((thisLine = br.readLine()) != null) {
               boxer = thisLine.split(";");
               name = boxer[0];
               style = BoxerStyle.valueOf(boxer[1]);
               boxerList.add(new Boxer(name, style));
           }
           
        }
        return boxerList;
    }
    
    //Method will write all fighter data with tags (str:..) to file
    void WriteData(Boxer boxer) {
        try(
            BufferedWriter bw = 
                    Files.newBufferedWriter(Paths.get("boxerList.txt"))) { 
            
        } catch (IOException ex) {
            Logger.getLogger(BoxingSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
