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
     * @param tmpDir
     * @param analysisOption
     * @param settingsValues
     * @param noa
     */
    public void start(String tmpDir,String analysisOption, ArrayList settingsValues, int noa){
        
        System.out.println("In program!");
       
   
        
       
        try{
            System.out.println("call R methods");
            
            // Tries to call the start function of the call methods
            CallRMethods call = new CallRMethods();
            call.runRFunctions(tmpDir, analysisOption, settingsValues, noa);
               
        }catch(NullPointerException e){
                System.out.println("error integration: " + e);
            }
    }


 
    
}
