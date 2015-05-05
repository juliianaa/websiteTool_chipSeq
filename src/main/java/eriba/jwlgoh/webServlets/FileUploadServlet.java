package eriba.jwlgoh.webServlets;

import eriba.jwlgoh.JavaRIntegration.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * JavaServlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    
    /**
    * Constructs temporary directory path to store upload file
    **/
    private final String uploadPath = "/srv/molgenis/temp_chromstaR/";
    private String tmp_dir = null;
    private String user_dir = null;

    /**
     * Upon receiving the files and parameters that contains the R-package settings upload submission. 
     * The request will be parsed for later use in the program.
     *
     * @param request 
     * @param response
     * @throws ServletException States that something went wrong with the JavaServlet
     * @throws java.io.IOException Catches the exception if the previous exception was not catch.
     */
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, NumberFormatException{
            
            ArrayList<Object> checkedFunctions = new ArrayList<>();
            ArrayList<String> fileName = new ArrayList<>();
            int noa = 0;

            try {

                //Saves the given parameters as from Ajax in a List as a FileItem.
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
                        .parseRequest(request);

                //Checks if the given upload is not empty
                if (items != null && items.size() > 0) {
                    
                    // iterates over the form fields
                    for (FileItem itemFormField : items) {
                        if (itemFormField.isFormField()){

                            //Is not a File, all other parameters will be added to the ArrayList
                            checkedFunctions.add(itemFormField.getString());
                        }
                    }
                    
                    //Settings for 2nd analysis
                    String secondAnalysisValue = (String) checkedFunctions.get(2);
                    ArrayList secondAnalysisList = new ArrayList<>(Arrays.asList(secondAnalysisValue.split(",")));
                    
                    //number of analysis
                    String x = (String) secondAnalysisList.get(0);
                    
                    noa = noa + Integer.parseInt(x);
                    
                    //Path to the file where the previous files are for a second analysis run
                    String secAnalysis = (String) secondAnalysisList.get(1);
                    
                    
                    if (secAnalysis.equals("none")){
                        
                        CreateTempDir tmpDir = new CreateTempDir();
                        
                        user_dir = tmpDir.createDir(uploadPath, "User_");
                        
                        //Calls the java class/method that creates the temporary directory to save the
                        //uploaded file(s) from the client.
                        tmp_dir = tmpDir.createDir(user_dir, "User_files_");
                        
                        // iterates over the not form fields
                        for (FileItem item : items) {
                            if (!item.isFormField()) {
                                //If item is a file, it will not be seen as a FormField.
                                //Gets the name of the uploaded file(s)
                                String fileNameUserInput = new File(item.getName()).getName();
                                
                                fileName.add(fileNameUserInput);
                                

                                //Saves the file in the temporary directory that was created
                                String filePath = tmp_dir + File.separator + fileName;
                                File storeFile = new File(filePath);

                                // saves the file on disk
                                item.write(storeFile);

                            }
                        }
                    }else{
                        tmp_dir = secAnalysis;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //the parsed information will be put into a Map with the key name and the associated value

            
            try{
                //Tries to call the class/method JavaRIntegration and gives the Map.
                System.out.println("call Java R integration START OF PROGRAM");
  
                JavaRIntegration calculateWithR = new JavaRIntegration();
                String args = calculateWithR.start(user_dir, tmp_dir, fileName, checkedFunctions, noa);

                //gives back a response, where the tmp_dir will be given for compressing files to zip
                //in the DownloadZipFileServlet
                response.getWriter().print(args);
                
                
            }catch(NullPointerException e){
                System.out.println("error servlet: " + e);
            }
    }
}
