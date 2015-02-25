/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

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
        re=new Rengine (engineArgs, false, null);
        
        //set path to where R package, chromstaR is
        re.eval("setwd('C:\\\\Users/Eriba/Documents/chromstaR_0.9/')");
        
        //load R package chromstaR library
        re.eval("library(chromstaR)");
        
       
        return re;
    
    }
    
    /**
     *
     */
    public void stopRConnection(){
        re.end();
    }
    
}
