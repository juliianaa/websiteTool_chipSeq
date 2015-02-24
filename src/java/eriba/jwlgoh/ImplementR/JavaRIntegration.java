/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Eriba
 */
public class JavaRIntegration {
    ConnectWithR r = new ConnectWithR();
    

    public void start(Map<String, Object> args) {
        
//        System.out.println(checkedFunctions);
        //receive the R connection? format still unclear
        r.rConnect(args);
        
        
    }
    
    /**
     *
     * @return
     */
    public String getResults() {
//        String results = r.getResultOfR();
        
        return null;
    }

    
    
}
