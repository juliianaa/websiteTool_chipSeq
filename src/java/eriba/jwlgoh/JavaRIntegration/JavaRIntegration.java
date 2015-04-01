/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.io.File;
import java.util.*;

/**
 * This class contains one method which is the start method where all the needed classes/methods 
 * will be called when needed. This class/method can be seen as the main class/method of the program. 
 * 
 * @author jwlgoh
 */
public class JavaRIntegration {
    /**
     * This method can be seen as the main method where the needed method will be send to the next 
     * method with the needed values to retrieve the results.
     *
     * @param user_dir
     * @param tmp_dir
     * @param fileNames
     * @param checkedFunctions
     * @param noa
     * @return 
     */
    public String start(String user_dir, String tmp_dir, ArrayList<String> fileNames, ArrayList<Object> checkedFunctions, int noa){
        
        System.out.println("In program!");
       
        String args = null;
        
        try{
            System.out.println("call R methods");
            
            // Tries to call the start function of the call methods
            CallRMethods call = new CallRMethods();
            
            //Default or Advanced
            String analysisOption = (String) checkedFunctions.get(0);

            //Settings for R-package
            String settings = (String) checkedFunctions.get(1);
            ArrayList<String> settingsValues = new ArrayList<>(Arrays.asList(settings.split(",")));
            
            String resultsDirName = File.separator + "analysis_" + noa;
            
            String analysisResultsDir = user_dir + resultsDirName;
            
            call.runRFunctions(tmp_dir, analysisOption, settingsValues, analysisResultsDir);
            
            WriteToFile wf = new WriteToFile();
            wf.writeToTxt(analysisResultsDir, resultsDirName, settingsValues, fileNames, noa);
                    
                    
            //sets with the needed information into a String format for later use if the user
            //wishes to do another analysis with the files but, with different settings.
            args = user_dir+","+tmp_dir +","+(noa + 1);
               
        }catch(NullPointerException e){
                System.out.println("error integration: " + e);
            }
        return args;
    }

}
