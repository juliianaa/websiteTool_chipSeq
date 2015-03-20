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
    private final String uploadPath = "C:\\Users\\Eriba\\Documents\\temp_chromstaR\\";

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
            HttpServletResponse response) throws ServletException, IOException {
            
            String tmp_dir = null;
            Map<String, Object> args = new HashMap<>();
            ArrayList<String> checkedFunctions = new ArrayList<>();

            try {   
                    //Saves the given parameters as from Ajax in a List as a FileItem.
                    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
                            .parseRequest(request);
                    
                    //Calls the java class/method that creates the temporary directory to save the
                    //uploaded file(s) from the client.
                    createTempDir tmpDir = new createTempDir();
                    tmp_dir = tmpDir.createDir(uploadPath);
                    
                    //Checks if the given upload is not empty
                    if (items != null && items.size() > 0) {
                         
                        // iterates over the form fields
                        for (FileItem item : items) {
                        
                            if (!item.isFormField()) {
                                //If item is a file, it will not be seen as a FormField.
                                //Gets the name of the uploaded file(s)
                                String fileName = new File(item.getName()).getName();
                                
                                //Saves the file in the temporary directory that was created
                                String filePath = tmp_dir + File.separator + fileName;
                                File storeFile = new File(filePath);

                                // saves the file on disk
                                item.write(storeFile);

                            }if (item.isFormField()){
                                //Is not a File, all other parameters will be added to the ArrayList
                                checkedFunctions.add(item.getString());
                            }
                        }
                    }
            } catch (Exception ex) {
                Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //the parsed information will be put into a Map with the key name and the associated value
            args.put("pathToTempDir", tmp_dir);
            args.put("advancedOptions", checkedFunctions);

            System.out.println(args);
            
            try{
                //Tries to call the class/method JavaRIntegration and gives the Map.
                System.out.println("call Java R integration START OF PROGRAM");
                JavaRIntegration calculateWithR = new JavaRIntegration();
                calculateWithR.start(args);
                
                //gives back a response, where the tmp_dir will be given for compressing files to zip
                //in the DownloadZipFileServlet
                response.getWriter().print(tmp_dir);
                
            }catch(NullPointerException e){
                System.out.println("error servlet: " + e);
            }
    }
}
