/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.util.ArrayList;
import org.rosuda.JRI.Rengine;


/**
 * This class only has one method, which will be calling the method to make connection with R and
 * gives the parameters to the function in the R-script.
 *
 * @author jwlgoh
 */
public class CallRMethods {
    
    
    private final ConnectWithR r = new ConnectWithR();
    
    /**
     * Upon receiving the parameters, this method will be calling the function in the R-script 
     * with the needed parameters for the calculations. 
     * 
     * @param analysisOption
     * @param tmpDir
     * @param options
     * @param analysisDir
     */
    public void runRFunction(String tmpDir,String analysisOption, ArrayList options, String analysisDir) {
        
        System.out.println("call r methods program");
        
        //Replace the slashes for back slashes as R only accepts paths with back slashes.
        String tmp_dir = tmpDir.replace("\\", "/");
        String noa = analysisDir.replace("\\", "/");
  
        
        //Receives the R connection
        Rengine re = r.rConnect();
        
        try{

            //Checks which option the user has given for the calculations. 
            if (!(analysisOption.equals("Default")|analysisOption.equals(""))){
                //Enters here when the user chose the Advanced option, this means that the user
                //has changed a parameter setting to liking instead of using the default setting.
                System.out.println("to advanced as default params are changed");

                //How the parameters will be given to the R-script function
                re.eval("inputOption('" + tmp_dir + "','" + noa + "'," + options.get(0) + "," + options.get(1) +
                        "," + options.get(2) + ")");

            }else{

                //Enters here when the user uses the Default option, which only the path of where
                //the uploaded file(s) needs to be given to the function of the R-scipt.
                System.out.println("default as no advanced options are given");
                re.eval("inputOption('"+ tmp_dir + "','" + noa + "')");
            }

        }catch(NullPointerException e){
                System.out.println("error call R methods: " + e);
        }
        
        System.out.println("done with calculations");
    }
  
}
