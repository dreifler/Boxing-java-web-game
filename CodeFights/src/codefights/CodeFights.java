/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefights;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darrenreifler
 */
public class CodeFights {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        String s = "The ((quick (brown) (fox) jumps over the lazy) dog)";
        System.out.println(reverseParentheses(s));
    }
    
    public static String reverseParentheses(String s) {
        int first = s.lastIndexOf("("),last = s.indexOf(")");
        StringBuilder sBuilder = new StringBuilder(s.toString());
        StringBuilder reverser = new StringBuilder();
        String subS = "";
        boolean check = false;
        
        if (first == -1){
            return s;
        }
        
        // check if parentheses are not contained in each other
        if(last < first) {
            first = s.indexOf("(");
            last = s.indexOf(")");
            
            subS = s.substring(first + 1,last);
            if (subS.contains("(")) {
                check = true;
                last = s.lastIndexOf(")");
                subS = reverseParentheses(s.substring(first + 1, last));
            }  
        }
        
        // remove parentheses and save substring
        sBuilder.delete(first, last + 1);
        if (!check)
            subS = s.substring(first + 1, last);
           
        // reverse string with StringBuilder 
        reverser.append(subS);
        reverser.reverse();
        subS = reverser.toString();
        reverser.delete(0,56);
        
        // insert subS into sBuilder
        sBuilder.insert(first, subS);
        
        return reverseParentheses(sBuilder.toString());
    }   
}
