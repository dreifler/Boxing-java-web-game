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
    
    static List CreateBoxers() throws IOException {
        String name;
        String thisLine;
        String boxer[];
        Style style;
        
        List<Boxer> boxerList = new ArrayList<Boxer>();
        
        try(
            BufferedReader br =
                    Files.newBufferedReader(Paths.get(BoxerIN))){
           while((thisLine = br.readLine()) != null) {
               boxer = thisLine.split(";");
               name = boxer[0];
               style = Style.valueOf(boxer[1]);
               boxerList.add(new Boxer(name, style));
           }
           
        }
        return boxerList;
    }
}
