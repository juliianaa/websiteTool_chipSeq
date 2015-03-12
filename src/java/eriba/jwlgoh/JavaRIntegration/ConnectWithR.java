/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import org.rosuda.JRI.Rengine;

/**
 *
 * @author Eriba
 */
public class ConnectWithR {
    private Rengine re;

    /**
     *
     * @return the connection that has been made with R
     */
    public Rengine rConnect() {
        
        //new R engine
        String[] engineArgs = new String[1];
        engineArgs [0] = "–vanilla";
        re=new Rengine (engineArgs, true, null);
        
        // Sets the library trees where the needed packages can be found
        re.eval(".libPaths(\"C:/Users/Eriba/Documents/R/win-library/3.1\")");
        // Calls the needed packages
        re.eval("library(rJava)");
        re.eval("library(chromstaR)");
        
        // Calls the script where all the calculations will be made
        re.eval("source('C:/Users/Eriba/Documents/chromstaR_0.9/callChromstaROptions.R')");
        
        
        if(! re.waitForR()){
            //Can't make connection with R, program will be stopped immediately
            System.out.println("Cannot load R");
            System.exit(1);
        }

        return re;
    
    }
    
    /**
     *
     */
    public void stopRConnection(){
        //done
        re.end();
    }
    
}
