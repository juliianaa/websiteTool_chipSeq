/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.util.ArrayList;
import java.util.Map;

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
        
       
         //gets the paths to where the files are saved
        Object obj1 = args.get("pathToTempDir");
        //sets the object like an arraylist
        String tmpDir = obj1.toString();
        
        //receives the advanced options that the user gives
        Object obj2 = args.get("advancedOptions");
        //sets the object like an ArrayList
        ArrayList options = (ArrayList) obj2;
        //get the first option
        Object firstFunction = (String) options.get(0);
        
        // Tries to call the start function of the call methods
        try{
            CallRMethods call = new CallRMethods();
            call.startRFunctions(firstFunction, tmpDir, options);
        }catch(NullPointerException e){
                System.out.println("error servlet: " + e);
            }

        
        
    }
    
    
    
    




    
    
}
