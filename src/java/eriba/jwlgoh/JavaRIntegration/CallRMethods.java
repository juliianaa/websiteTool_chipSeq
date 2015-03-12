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
    private Rengine re;
    private String tmp_dir;
    private List advancedOptions;
   
    private final ConnectWithR r = new ConnectWithR();
    private String zipFile;
    /**
     *
     * @param firstFunction
     * @param tmpDir
     * @param options
     */
    public void startRFunctions(Object firstFunction, String tmpDir, List options) {
        
        System.out.println("call r methods program");
        
        tmp_dir = tmpDir.replace("\\", "/");
        advancedOptions = options;
        
        //receive the R connection
        re = r.rConnect();
        
        try{ 
   
            //If it is a default then the default option will only be done
            //else the advanced option will be done
            if (!(firstFunction.equals("Default")|firstFunction.equals(""))){
                System.out.println("to advanced");
                runAdvancedFunction();
                }else{
                System.out.println("default");
                runDefaultFunction();
                }

        }catch(NullPointerException e){
                System.out.println("error call R methods: " + e);
        }
    }

    /**
     *
     * @throws NullPointerException
     */
    public void runDefaultFunction(){
        System.out.println("in default");
        // Calls the function that is checked by the user.
        re.eval("defaultOptions('"+tmp_dir+"')");
        System.out.println("done with default options");
        //done with the function
        r.stopRConnection();
    }

    /**
     *
     */
    public void runAdvancedFunction() {
        System.out.println("advanced"); 
        System.out.println(advancedOptions);
        
        try{
            // Calls the function that is checked by the user.
            re.eval("advancedOptions('"+tmp_dir+"',"+advancedOptions.get(0)+","+advancedOptions.get(1)+","+advancedOptions.get(2)+")");
            System.out.println("done with advance options");
            //done with the function
            r.stopRConnection();
        }catch(IndexOutOfBoundsException IOBE){
            System.out.println(IOBE);
        }
    }
  
}
