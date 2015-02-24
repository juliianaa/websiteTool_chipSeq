/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

/**
 *
 * @author Eriba
 */
public class ConnectWithR {
    Rengine re;

    void rConnect(Map<String, Object> args) {
        
        //new R engine
        String[] engineArgs = new String[1];
        engineArgs [0] = "–vanilla";
        re=new Rengine (engineArgs, false, null);
        
        
        re.eval("setwd('C:\\Users/Eriba/Documents/')");
//        REXP result = re.eval("getwd()");
        REXP result = re.eval("library(chromstaR)");
        
        //gets the paths to where the files are saved
        Object obj1 = args.get("pathToFiles");
        ArrayList files = new ArrayList();
        //sets the object back to an arraylist
        files = (ArrayList) obj1;
        
        //gets all the check functions
        Object obj2 = args.get("advancedOptions");
        ArrayList functions = new ArrayList();
        //sets the object back to an arraylist
        functions = (ArrayList) obj2;
        
        //gets the path of the temp dir
        Object obj3 = args.get("pathToTempDir");
        String tmpDir = new String();
        //sets the String back to an arraylist
        tmpDir = (String) obj3;
        
        System.out.println(tmpDir);
        
        for (int i = 0; i < files.size(); i++){
            System.out.println(files.get(i));
            
//            bedfiles<-list.files(system.file(file.path("extdata","brain"),package="chromstaR"),full=T)
//            //Binthedataintobinsize1000bpandbuildtheunivariateHiddenMarkovModel(HMM)
//            binned.data.list<-list()
//            uni.HMMs<-list()
//            for(bedfile in bedfiles){
//              binned.data.list[[bedfile]]<-bed2binned(bedfile,assembly='hg19',binsize=1000,save.as.RData=F)
//              uni.HMMs[[bedfile]]<-callPeaksUnivariate(binned.data.list[[bedfile]],ID=basename(bedfile),
//              max.time=30,eps=0.01)
//            }
//            //BuildthemultivariateHiddenMarkovModelfromthelistofunivariatefits
//            multi.hmm<-callPeaksMultivariate(uni.HMMs,eps=0.1,max.time=300)
//
//
//            //Exportdifferentiallymodifiedregionsforvisualinspectioninthegenomebrowser
//            export.multihmm2bed(multi.hmm,file='multivariate_peak_calls_example_H3K36me3',exclude.states=c(0,127))
//            export.binned2wiggle(binned.data.list,file='read_counts_example_H3K36me3')
            
            
            
            
        }
        
        
        
        //done
        re.end();

        

        
//        re.eval("setwd('C:\\Users\\Eriba\\Documents)");
//        System.out.println (re.eval("getwd()"));

        // print a random number from uniform distribution
       


       
       //set path correctly
       //import all libraries and chromstaR package
        
       //send functions to new method callRFunctions
       
       //set method/function getResult, like this the JavaRIntergration method
       //can get the results back before sending it to the website or
       //to save the results in a file for the user to download
    }

    
}
