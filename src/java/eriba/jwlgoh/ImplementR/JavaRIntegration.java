/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.util.ArrayList;
import java.util.Map;
import org.rosuda.JRI.Rengine;

/**
 *
 * @author Eriba
 */
public class JavaRIntegration {
    CallRMethods call = new CallRMethods();
    private Rengine re;
    private ArrayList files;
    private ArrayList options;
    
    /**
     *
     * @param args
     */
    public void start(Map<String, Object> args) {
        
        //receive the R connection
        ConnectWithR r = new ConnectWithR();
        re = r.rConnect();
        
         //gets the paths to where the files are saved
        Object obj1 = args.get("pathToFiles");
        //sets the object like an arraylist
        files = (ArrayList) obj1;
        
        //receives the advanced options that the user gives
        Object obj2 = args.get("advancedOptions");
        //sets the object like an ArrayList
        options = (ArrayList) obj2;
        //get the first option
        Object firstFunction = (String) options.get(0);
        
        System.out.println(firstFunction);
        
        //If it is a default then the default option will only be done
        //else the advanced option will be done
        if (!firstFunction.equals("Default")){
            call.runAdvancedFunctions(re);
        }else{
            call.runDefaultFunction(re);
            
        }
        
        
        //done
        // print a random number from uniform distribution
        //set path correctly
        //import all libraries and chromstaR package
        //send functions to new method callRFunctions
        //set method/function getResult, like this the JavaRIntergration method
        //can get the results back before sending it to the website or
        //to save the results in a file for the user to download
        
    }
    
    
    
    




    
    
}
