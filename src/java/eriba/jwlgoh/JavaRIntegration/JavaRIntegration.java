/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.util.*;

/**
 * This class contains one method which is the start method where all the needed classes/methods 
 * will be called when needed. This class/method can be seen as the main class/method of the program. 
 * 
 * @author jwlgoh
 */
public class JavaRIntegration {
    /**
     * This method can be seen as the main method where all the needed information will be parsed and
     * send to the next method.
     *
     * @param args
     */
    public void start(Map<String, Object> args){
        
        System.out.println("In program!");
       
        //Gets the paths to where the files are saved
        Object obj1 = args.get("pathToTempDir");
        //Sets the object like an arraylist
        String tmpDir = obj1.toString();
        
        //Receives the advanced options that the user gives
        Object obj2 = args.get("advancedOptions");
        //Sets the object like an ArrayList
        ArrayList options = (ArrayList) obj2;

        //Gets the option, which will be either empty(will change to default), Default or Advanced
        String firstFunction = (String) options.get(0);
        
        //Gets the parameters of the R-package settings
        String argsList = (String)options.get(1);
        //The parameters are seen one string "800,30,300" with splitting on the "," all settings 
        //can be retrieved for later.
        List<String> sublist = new ArrayList<>(Arrays.asList(argsList.split(",")));
        
//        String hiddenList = (String)options.get(2);
//        
//        System.out.println(hiddenList + "length " + hiddenList.length());
        
        System.out.println(args);
        
        
       
//        try{
//            System.out.println("call R methods");
//            
//            // Tries to call the start function of the call methods
//            CallRMethods call = new CallRMethods();
//            call.runRFunctions(firstFunction, tmpDir, sublist);
//               
//        }catch(NullPointerException e){
//                System.out.println("error integration: " + e);
//            }
    }

 
    
}
