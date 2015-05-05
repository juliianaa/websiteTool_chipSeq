/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import org.rosuda.JRI.Rengine;

/**
 * 
 * This class contains only one method which is the method that will connect Java with R.
 *
 * @author jwlgoh
 */
public class ConnectWithR {
    private Rengine re = Rengine.getMainEngine();

    /**
     * Creates a new R engine which is the bridge between Java and R. 
     * 
     * 
     * (R Native Interface) are low-level native methods that should be 
     * avoided if a high-level methods exists. They do NOT attempt any synchronization, so it is the duty of the calling 
     * program to ensure that the invocation is safe (see {@link #getRsync()} for details).
     *  return the current main R engine instance. Since there can be only one true R instance at a time, this is 
     * also the only instance. This may not be true for future versions, though.
     * 
     * 
     * (return statement)return current instance of the R engine or <code>null</code> if no R engine was started yet. 
     *
     * @return the connection that has been made with R
     */
    public Rengine rConnect() {
        
        
        if(re == null){
            
            //new R engine
            String rAgs[] = new String[10];
            rAgs [0] = "–vanilla";
            re = new Rengine(rAgs, false, null);
            
            // Sets the library trees where the needed packages can be found
            re.eval(".libPaths('/srv/molgenis/R/x86_64-redhat-linux-gnu-library/3.1')");
            // Calls the needed packages
            re.eval("library(rJava)");
            re.eval("library(chromstaR)");

            // Calls the script where all the calculations will be made
            re.eval("source('/srv/molgenis/rScript/callChromstaROptions.R')");
            
            if(! re.waitForR()){
                //Can't make connection with R, program will be stopped immediately
                System.out.println("Cannot load R");
                System.exit(1);
            }
        }
        
        //Returns the connection with R 
        return re;
    }
}
