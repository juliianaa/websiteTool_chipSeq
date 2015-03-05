/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.io.File;
import java.util.ArrayList;
import org.rosuda.JRI.Rengine;


/**
 *
 * @author Eriba
 */
public class CallRMethods {
    private Rengine re;
    private String tmp_dir;
    private ArrayList advancedOptions = null;
    private boolean exportFileExists = false;
    private final ArrayList exportedFiles = null;
    ConnectWithR r = new ConnectWithR();
    /**
     *
     * @param firstFunction
     * @param tmpDir
     * @param options
     */
    public void startRFunctions(Object firstFunction, String tmpDir, ArrayList options) {
        
        tmp_dir = tmpDir;
        advancedOptions = options;
        
        //receive the R connection
        re = r.rConnect();
        

        getExportedFiles();
        try{ 
            if (exportFileExists == false){
                //If it is a default then the default option will only be done
                //else the advanced option will be done
                if (!(firstFunction.equals("Default")|firstFunction.equals(""))){
                        runAdvancedFunctions();
                    }else{
                        runDefaultFunction();
                    }
            }else{
                System.out.println("Files already exists: ");
                System.out.println(exportedFiles);
            }
        }catch(NullPointerException e){
                System.out.println("error servlet: " + e);
        }
    }

    /**
     *
     * @throws NullPointerException
     */
    public void runDefaultFunction(){

        // Calls the function that is checked by the user.
        re.eval("defaultOptions('"+tmp_dir+"')");

        getExportedFiles();
        System.out.println(exportedFiles);

        //done with the function
        r.stopRConnection();


        
    }

    /**
     *
     */
    public void runAdvancedFunctions() {
        System.out.println("advanced");
    }
       
    /**
     *
     */
    public void getExportedFiles() {
        
        File f = new File(tmp_dir);
        String[] getAllFiles = f.list();
                
        for (String bla : getAllFiles){
            if(bla.startsWith("export")){
                exportFileExists = true;
                exportedFiles.add(bla);
            }
        }
    }
  
}
