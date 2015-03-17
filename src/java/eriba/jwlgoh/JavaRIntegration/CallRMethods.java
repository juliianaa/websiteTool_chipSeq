/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.util.List;
import org.rosuda.JRI.Rengine;


/**
 *
 * @author Eriba
 */
public class CallRMethods {
    private final ConnectWithR r = new ConnectWithR();
    /**
     *
     * @param firstFunction
     * @param tmpDir
     * @param options
     */
    public void runRFunctions(Object firstFunction, String tmpDir, List options) {
        
        System.out.println("call r methods program");
        
        String tmp_dir = tmpDir.replace("\\", "/");
        
        //receive the R connection
        Rengine re = r.rConnect();
        
        try{
            //If it is a default then the default option will only be done
            //else the advanced option will be done
            if (!(firstFunction.equals("Default")|firstFunction.equals(""))){
                System.out.println("to advanced as default params are changed");
                re.eval("inputOption('"+tmp_dir+"',"+options.get(0)+","+options.get(1)+","+options.get(2)+")");

            }else{
                
                System.out.println("default as no advanced options are given");
                re.eval("inputOption('"+tmp_dir+"')");
            }

        }catch(NullPointerException e){
                System.out.println("error call R methods: " + e);
        }
        System.out.println("done with calculations");
        r.stopRConnection();
        
    }
  
}
