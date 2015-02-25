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
public class CallRMethods {
    private Rengine re;

    public void runDefaultFunction(Rengine re) {
        System.out.println("in default");

        //gets all the files from the tmpDir directory
        

//bedFiles <- list.files("C:/Users/Eriba/Documents/temp_chromstaR/HistoneHMM_7383799876110895811", full=T)
//
//uni.HMMs <- list()
//binned.data.list <- list()
//
//for (bedfile in bedFiles) {
//  binned.data <- bed2binned(bedfile, assembly='hg19', binsize=800, save.as.RData=F)
//  binned.data.list[[bedfile]] <- binned.data
//  uni.HMMs[[bedfile]] <- callPeaksUnivariate(binned.data, ID=basename(bedfile), max.time=30, eps=0.01)
//}
//
//multi.hmm <- callPeaksMultivariate(uni.HMMs, eps=0.1, max.time=300)
//
//## Export the binned read counts
//export.binned2wiggle(binned.data.list, filename='chromstaR-example_binned_read_counts.uni.HMM')
//## Export the univariate calls
//export.unihmm2bed(uni.HMMs, filename='chromstaR-example_state_calls_univariate.HMMs')
//
//## Export the binned read counts
//export.multihmm2wiggle(multi.hmm, filename='chromstaR-example_read_counts_example.multi.HMM')
//## Export the state calls for each sample
//export.multihmm2bed(multi.hmm, separate.tracks=TRUE, exclude.states=c(0), filename='chromstaR-example_state_calls_multi.HMM')
//       
        
        
    }

    public void runAdvancedFunctions(Rengine re) {
        System.out.println("advanced");
    }
    
    /**
     *
     */
    public void exportToFile(){
        System.out.println("bla file");
    }

    
}
