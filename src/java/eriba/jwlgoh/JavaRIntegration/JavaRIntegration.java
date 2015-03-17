/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 *
 * @author Eriba
 */
public class JavaRIntegration {
     private String zipFile;
     private String tmpDir;
        
    /**
     *
     * @param args
     */
    public void start(Map<String, Object> args){
        
        System.out.println("In program!");
       
         //gets the paths to where the files are saved
        Object obj1 = args.get("pathToTempDir");
        //sets the object like an arraylist
        tmpDir = obj1.toString();
        
        //receives the advanced options that the user gives
        Object obj2 = args.get("advancedOptions");
        //sets the object like an ArrayList
        ArrayList options = (ArrayList) obj2;
        //get the first option
        String firstFunction = (String) options.get(0);
        
        String argsList = (String)options.get(1);
        
        List<String> sublist = new ArrayList<>(Arrays.asList(argsList
                .split(",")));
        
        CallRMethods call = new CallRMethods();
        
        // Tries to call the start function of the call methods
        try{
            System.out.println("call R methods");
  
            call.runRFunctions(firstFunction, tmpDir, sublist);
            compressFilesToZip(tmpDir);
               
        }catch(NullPointerException e){
                System.out.println("error integration: " + e);
            }
    }

 
//    
    public void compressFilesToZip(String tmpDir){
        try {
            System.out.println("compress files");
            File f = new File(tmpDir);
            String[] getAllFiles = f.list();
            ArrayList exportedFiles = new ArrayList();

            for (String bla : getAllFiles){
                if(bla.startsWith("export")){
                    exportedFiles.add(bla);
                }
            }
            
            System.out.println(exportedFiles);
            
            
            zipFile = tmpDir + File.separator + "chromstaR_results.zip";
            // create byte buffer

            byte[] buffer = new byte[1024];

            FileOutputStream fos = new FileOutputStream(zipFile);

            try (ZipOutputStream zos = new ZipOutputStream(fos)) {
                for (int i=0; i < exportedFiles.toArray().length; i++) {
                    
                    System.out.println("bb " + exportedFiles.get(i));
                    File srcFile = new File(tmpDir + File.separator + exportedFiles.get(i));
                    // begin writing a new ZIP entry, positions the stream to the start of the entry data
                    try (FileInputStream fis = new FileInputStream(srcFile)) {
                        // begin writing a new ZIP entry, positions the stream to the start of the entry data
                        zos.putNextEntry(new ZipEntry(srcFile.getName()));
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            zos.write(buffer, 0, length);
                        }
                        zos.closeEntry();
                        // close the InputStream
                    }
                }
            }
        }
        catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }
        
        System.out.println("done with compressing");
    }
    
    public String getZipFile(){
        return zipFile;
        
    }
}
