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
public class DataReader {
    private static final String BoxerIN =  "boxerIn.txt";
    private List<Boxer> boxerList = new ArrayList<>();
    
    public List CreateBoxers() throws IOException {
        String name;
        String thisLine;
        String boxer[];
        Style style;
        boolean dup;
        
        try(
            BufferedReader br =
                    Files.newBufferedReader(Paths.get(BoxerIN))){
            //add method to check for duplicate names before creating
            while((thisLine = br.readLine()) != null) {
               boxer = thisLine.split(";");
               name = boxer[0];
               style = Style.valueOf(boxer[1]);
               dup = Duplicate(name);
               if (!dup)
                    boxerList.add(new Boxer(name, style));
            }
           
        }
        return boxerList;
    }
    
    //improve this search method with sort and binary search
    private boolean Duplicate(String name) {
        boolean dup = false;
        
        for(int i = 0; i < boxerList.size();i++) {
            if (boxerList.get(i).name == name)
                return true;
        }
        
        return dup;
    }
}
