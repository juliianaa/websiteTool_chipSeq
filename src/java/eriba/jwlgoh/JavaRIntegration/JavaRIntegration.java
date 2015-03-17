/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 *
 * @author Eriba
 */
public class JavaRIntegration {
    /**
     *
     * @param args
     */
    public void start(Map<String, Object> args){
        
        System.out.println("In program!");
       
         //gets the paths to where the files are saved
        Object obj1 = args.get("pathToTempDir");
        //sets the object like an arraylist
        String tmpDir = obj1.toString();
        
        
        //receives the advanced options that the user gives
        Object obj2 = args.get("advancedOptions");
        //sets the object like an ArrayList
        ArrayList options = (ArrayList) obj2;
        //get the first option
        String firstFunction = (String) options.get(0);
        
        String argsList = (String)options.get(1);
        
        List<String> sublist = new ArrayList<>(Arrays.asList(argsList
                .split(",")));
        
        CallRMethods call = new CallRMethods();
        
        // Tries to call the start function of the call methods
        try{
            System.out.println("call R methods");
  
            call.runRFunctions(firstFunction, tmpDir, sublist);
               
        }catch(NullPointerException e){
                System.out.println("error integration: " + e);
            }
    }

 
    
}
