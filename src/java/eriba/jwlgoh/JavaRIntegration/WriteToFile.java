/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.io.*;
import java.util.ArrayList;

/**
 * This class contains one method that is responsible for writing a text file that contains 
 * all the information about which file(s) were uploaded and which settings where used for the
 * analysis.
 * 
 * @author Eriba
 */
public class WriteToFile {

    /**
     * Writes the information of the settings and files that were used for the analysis to a .txt file
     * 
     * @param analysisResultsDir
     * @param resultsDirName
     * @param settings
     * @param fileNames
     * @param noa
     */
    public void writeToTxt(String analysisResultsDir,  String resultsDirName, ArrayList<String> settings, ArrayList<String> fileNames, int noa) { 
        
        try {
            
            String firstSentence = "You gave the following file for analysis number " + noa + ": \n \n";
            
            String Secondcontent = "\n Used the settings of: \n \n Bins: " + settings.get(0) + 
                    " \n Univariate maximum time: " + settings.get(1) 
                    + " \n Multivariate maximum time: " + settings.get(2);
 
            File file = new File(analysisResultsDir + resultsDirName + "_settings.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                    file.createNewFile();
            }
            

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            //writes the first sentence of the file about which files where used for the analysis
            bw.write(firstSentence);
            
            //if the analysis has not been done yet the files name will be given.
            //If the analysis has been done at least once, the files name will not be given
            //but will ask the user to go to the file called analysis_1_settings.txt
            if (noa == 1){
               
                for (String name : fileNames){
                    bw.write(name + "\n");
                }
            }else{
                bw.write("Used the previous files given: see analysis_1_settings.txt");
            }
            
            //writes the second part of the txt file which consists of the settings that were used
            //for the analysis
            bw.write(Secondcontent);
            bw.close();

        } catch (IOException e) {
            System.out.println("error writing to file: " + e);
        }
        
        
    }
    
}
